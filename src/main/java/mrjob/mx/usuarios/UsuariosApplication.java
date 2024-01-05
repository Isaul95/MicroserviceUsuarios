package mrjob.mx.usuarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class UsuariosApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
		LOGGER.info("Spring boot start DATETIME: " + new Date());
	}

	//@PostConstruct
	//public void init(){
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT-6"));
	//}

}
