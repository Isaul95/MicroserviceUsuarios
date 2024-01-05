package mrjob.mx.usuarios.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NotificationUserType {

    BUYER("BUY", "Buyer"),
    ATTENDEE("ATT", "Ateendee"),
    DMM("DMM", "DMM"),
    DIRECTOR("DIR", "Director"),
    REFILLER("REF", "Refiller"),
    UNKNOW("UNK", "Unknow");

    private String code;
    private String description;

    private NotificationUserType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NotificationUserType getByCode(String code) {
        for (NotificationUserType custStatus : NotificationUserType.values()) {
            if(custStatus.getCode().equals(code)) {
                return custStatus;
            }
        }
        return UNKNOW;
    }

}
