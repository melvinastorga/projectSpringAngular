package examen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@SpringBootApplication @ComponentScan({ "com.example.controller","com.example.repository", "com.example.service" } )
@SpringBootApplication @ComponentScan({ "examen.api.controller","examen.api.entity","examen.api.repository", "examen.api.service","examen.api.service.jpa" } )
@EnableJpaRepositories("examen.api.repository")
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

}
