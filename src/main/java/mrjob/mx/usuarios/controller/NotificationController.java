package mrjob.mx.usuarios.controller;

import mrjob.mx.usuarios.dto.NotificationDTO;
import mrjob.mx.usuarios.dto.ResultadoOperacionResponse;
import mrjob.mx.usuarios.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotificationController {

    private static Logger Logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;


    @PostMapping(value = "/manager/responsable/save")
    public ResponseEntity<ResultadoOperacionResponse> guardarUsuario(@RequestBody NotificationDTO notification) {
            return new ResponseEntity<>(notificationService.guardarUser(notification), HttpStatus.OK);
    }


}
