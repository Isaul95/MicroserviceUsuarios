package mrjob.mx.usuarios.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotificationUserDTO {

    private Long notifiyUserId;
    private Integer idUsuario;
  //private Integer userId;
    private String userComplete;
    private String email;
    private boolean deleted;
    private Integer oldUserId;

}
