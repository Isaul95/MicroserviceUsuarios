package mrjob.mx.usuarios.repository;

import mrjob.mx.usuarios.entity.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationUserRepository extends JpaRepository<NotificationUser,Long> {

    NotificationUser findByUser(Long notifiyUserId);

}
