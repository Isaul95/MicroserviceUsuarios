package mrjob.mx.usuarios.service;

import mrjob.mx.usuarios.dto.NotificationDTO;
import mrjob.mx.usuarios.dto.ResultadoOperacionResponse;

public interface NotificationService {

    ResultadoOperacionResponse guardarUser(NotificationDTO notification);
}
