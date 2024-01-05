package mrjob.mx.usuarios.entity;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "CAT_USER", schema = "ISAUL")
@SequenceGenerator(name="Seq_catuser", sequenceName = "ISAUL.SEQ_CATUSER", allocationSize=1)
public class CatUser {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_catuser")
    @Column(name = "ID_USER")
    private Integer idUsuario;
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ESTADO")
    private int estado;
    @Column(name = "ROL")
    private int rol;


}
