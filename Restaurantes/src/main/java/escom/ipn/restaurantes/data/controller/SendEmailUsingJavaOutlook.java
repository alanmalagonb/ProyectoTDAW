package escom.ipn.restaurantes.data.controller;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingJavaOutlook {
    final String SERVIDOR_SMTP = "smtp.office365.com";
    final int PORTA_SERVIDOR_SMTP = 587;
    final String CONTA_PADRAO = "restaurantesweb0@outlook.com";
    final String SENHA_CONTA_PADRAO = "Restaurantes123";
    final String sender = "restaurantesweb0@outlook.com";
    String recvr = "";
    final String emailsubject = "Recuperar Contraseña";
    String password = "";
    final String msg = "Tu contraseña es: ";

    public void Email(String recvr, String password) {
        this.recvr = recvr;
        this.password = password;
        final Session newsession = Session.getInstance(this.Eprop(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);
            }
        });
        try {
            final Message newmes = new MimeMessage(newsession);
            newmes.setRecipient(Message.RecipientType.TO, new InternetAddress(recvr));
            newmes.setFrom(new InternetAddress(sender));
            newmes.setSubject(emailsubject); 
            newmes.setText(msg + password);
            newmes.setSentDate(new Date()); 
            Transport.send(newmes);
            System.out.println("Mensaje Enviado!");
        } catch (final MessagingException ex) { 
            System.out.println("Error email");
            System.out.println(ex);
        }
    }
    
    public Properties Eprop() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        return config;
    }
}
