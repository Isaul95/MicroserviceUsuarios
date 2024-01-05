package mrjob.mx.usuarios.serviceImpl;

import mrjob.mx.usuarios.Enum.NotificationUserType;
import mrjob.mx.usuarios.dto.NotificationDTO;
import mrjob.mx.usuarios.dto.NotificationUserDTO;
import mrjob.mx.usuarios.dto.ResultadoOperacionResponse;
import mrjob.mx.usuarios.entity.CatUser;
import mrjob.mx.usuarios.entity.Notification;
import mrjob.mx.usuarios.entity.NotificationUser;
import mrjob.mx.usuarios.repository.CatUserRepository;
import mrjob.mx.usuarios.repository.NotificationRepository;
import mrjob.mx.usuarios.repository.NotificationUserRepository;
import mrjob.mx.usuarios.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    @Autowired
    private CatUserRepository catUserRepository;



    @Override
    public ResultadoOperacionResponse guardarUser(NotificationDTO dto) {

        ResultadoOperacionResponse response = new ResultadoOperacionResponse();

        Notification notification = new Notification();
        List<NotificationUser> notificationUser = new ArrayList<>();
        List<Long> deleteUsers = new ArrayList<>();

        notification.setAccessPath(dto.getAccessPath());
        notification.setCategoryId(dto.getCategoryId());
        notification.setDirection(dto.getDireccion());
        notification.setDivisionId(dto.getDivisionId());
        notification.setElementType(dto.getElementType());
        notification.setNotifiyId(dto.getNotifiyId());
        notification.setStatus(dto.getStatus());

        processooUsers(dto.getBuyers(), notification, NotificationUserType.BUYER, notificationUser, deleteUsers);
        processooUsers(dto.getAttendees(), notification, NotificationUserType.ATTENDEE, notificationUser, deleteUsers);
        processooUsers(dto.getDmms(), notification, NotificationUserType.DMM, notificationUser, deleteUsers);
        processooUsers(dto.getDirectors(), notification, NotificationUserType.DIRECTOR, notificationUser, deleteUsers);
        processooUsers(dto.getRefillers(), notification, NotificationUserType.REFILLER, notificationUser, deleteUsers);

        try {
            notificationRepository.save(notification);
            notificationUserRepository.saveAll(notificationUser);

            for (Long id : deleteUsers){
                notificationUserRepository.deleteById(id);

            }
            response.setMensajeExito("Se han guardado los datos correctamente...!!!");
        }catch (Exception e){
            response.setMensajeError("Error al guardar...");
        }

        return response;
    }




    private void processooUsers(List<NotificationUserDTO> users, Notification notification, NotificationUserType userType,
                                List<NotificationUser> notificationUsers, List<Long> deleteUsers) {

        String username = "Isaul";
        Date fechasActual = new Date();

        for (NotificationUserDTO user : users) {
            if (user.getNotifiyUserId() != null) { // Existentes
                if (user.isDeleted()) {
                    deleteUsers.add(user.getNotifiyUserId());
                } else if (user.getIdUsuario() != user.getOldUserId()) {  // } else if (user.getUserId() != user.getOldUserId()) {

                    CatUser catUser = catUserRepository.findByIdUsuario(user.getIdUsuario());
                    NotificationUser notificationUser = notificationUserRepository.findByUser(user.getNotifiyUserId());
                    notificationUser.setUser(catUser);
                    notificationUser.setModifiedDate(fechasActual);
                    notificationUser.setModifiedUser(username);
                    notificationUsers.add(notificationUser);
                }
            } else {
                if (!user.isDeleted()) {
                    NotificationUser notificationUser = new NotificationUser();
                    CatUser catUser = catUserRepository.findByIdUsuario(user.getIdUsuario()); // CatUser catUser = catUserRepository.findOne(user.getUserId());

                    notificationUser.setUser(catUser);
                    notificationUser.setUserType(userType.getCode());
                    notificationUser.setNotification(notification);
                    notificationUser.setCreatedDate(fechasActual);
                    notificationUser.setCreatedUser(username);
                    notificationUsers.add(notificationUser);

                }
            }
        }
    }



} // FIN CLASS
