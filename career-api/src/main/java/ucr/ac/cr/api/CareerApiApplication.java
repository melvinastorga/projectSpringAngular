package ucr.ac.cr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
//@SpringBootApplication @ComponentScan({ "com.example.controller","com.example.repository", "com.example.service" } )
@SpringBootApplication @ComponentScan({ "ucr.ac.cr.api.controller","ucr.ac.cr.api.entity","ucr.ac.cr.api.repository", "ucr.ac.cr.api.service","ucr.ac.cr.api.service.jpa" } )
@EnableJpaRepositories("ucr.ac.cr.api.repository")
public class CareerApiApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(CareerApiApplication.class, args);
	}


	
}
