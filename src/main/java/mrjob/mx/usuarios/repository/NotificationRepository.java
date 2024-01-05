package mrjob.mx.usuarios.repository;

import mrjob.mx.usuarios.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
