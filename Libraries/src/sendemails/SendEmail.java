package sendemails;

//import java.net.MalformedURLException;
//import java.net.URL;

import org.apache.commons.mail.*;

public class SendEmail {

	public static void send() {

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ivan.bsto@gmail.com", "1357301i"));
		email.setSSLOnConnect(true);

		try {
			
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("/home/stoilov/Pictures/kon.gif");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Picture of John");
			attachment.setName("John");
			
			email.setFrom("ivan.bsto@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This nice ");
			email.addTo("ivan.bsto@gmail.com");

			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");

			email.attach(attachment);

			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		send();
	}

}
