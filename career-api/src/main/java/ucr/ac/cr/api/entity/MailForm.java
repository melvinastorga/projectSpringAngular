package ucr.ac.cr.api.entity;

public class MailForm {

	private String name, mail, body, subject;

	public MailForm() {
		
	}

	public MailForm(String name, String mail, String body, String subject) {
		super();
		this.name = name;
		this.mail = mail;
		this.body = body;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
