package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.MailForm;
import ucr.ac.cr.api.service.jpa.SendMailService;

@RestController
public class SendMailController {

	  @Autowired
	    private SendMailService mailService;

	    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	    public String sendMail(@RequestBody MailForm form){

	        String message = form.getBody() +"\n\n Datos de contacto: " +
	                "\nNombre: " + form.getName() + "\nE-mail: " + form.getMail();

	        mailService.sendMail("revistaparaiso123@gmail.com",form.getMail(),form.getSubject(),message);
	       // mailService.sendMail("revistaparaiso123@gmail.com",mail,subject,message);

	        return "correo enviado";
	    }
	
}
