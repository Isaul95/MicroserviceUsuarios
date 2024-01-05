package mrjob.mx.usuarios.entity;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "NOTIFICATION", schema = "ISAUL")
@SequenceGenerator(name="Seq_notification", sequenceName = "ISAUL.SEQ_NOTIFICATION", allocationSize=1)
public class Notification {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_notification")
    @Column(name = "notifiy_id")
    private Long notifiyId;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "division_id")
    private Long divisionId;
    @Column(name = "direction")
    private String direction;
    @Column(name = "element_type")
    private String elementType;
    @Column(name = "access_path")
    private String accessPath;
    @Column(name = "status", nullable = false)
    private String status;


}
