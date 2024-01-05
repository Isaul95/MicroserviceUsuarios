package mrjob.mx.usuarios.dto;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class NotificationDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long notifiyId;
    private Long categoryId;
    private String categoryDesc;
    private Long divisionId;
    private String divisionesDesc;
    private String direccion;
    private String elementType;
    private String accessPath;
    private String status;
    private List<NotificationUserDTO> buyers;
    private List<NotificationUserDTO> attendees;
    private List<NotificationUserDTO> dmms;
    private List<NotificationUserDTO> directors;
    private List<NotificationUserDTO> refillers;


    public void initializeUsers() {
        buyers = new ArrayList<>();
        attendees = new ArrayList<>();
        dmms = new ArrayList<>();
        directors = new ArrayList<>();
        refillers = new ArrayList<>();
    }

}
