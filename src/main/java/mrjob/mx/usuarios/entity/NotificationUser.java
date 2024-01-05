package mrjob.mx.usuarios.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString
@Table(name = "USER_NOTIFICATION", schema = "ISAUL")
@SequenceGenerator(name="Seq_usernotification", sequenceName = "ISAUL.SEQ_USER_NOTIFICATION", allocationSize=1)
public class NotificationUser {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_usernotification")
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "notifiy_id", referencedColumnName = "notifiy_id")
    private Notification notification;

    @Column(name = "user_type")
    private String userType;

    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  //@JoinColumn(name = "user_id", referencedColumnName = "id")
    private CatUser user;

    @Column(name = "user_regis", nullable = false)
    private String createdUser;

    @Column(name = "user_update")
    private String modifiedUser;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-6")
    @Column(name = "regis_date")
    private Date createdDate = new Date();

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss", timezone = "GMT-6")
    @Column(name = "last_update")
    private Date modifiedDate;

}
