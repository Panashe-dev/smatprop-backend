package smattect.co.zw.smatrentalpro.utils.email.impl;



import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.utils.email.SendEmailService;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;


@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Value("${twilio.api.key}")
    private  String twilioAPIKey;

    @Override
    public void emailNotification(String name, String from, String to, String subject, String message) {
        try {
            Email sent = new Email(from);
            sent.setName(name);
            Email receive = new Email(to);
            Content content = new Content("text/html", message);
            Mail mail = new Mail(sent, subject, receive, content);
            SendGrid sg = new SendGrid(twilioAPIKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info("Status code"+response.getStatusCode());
            log.info("Body"+response.getBody());
            log.info(response.getHeaders().toString());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new BusinessValidationException("");
        }
    }

    @Override
    public void emailNotificationWithAttachment(String name,String to, String from, String subject, String message, byte[] attachment, String attachmentName) {
        Email rec = new Email(from);
        rec.setName(name);
        Email receiver = new Email(to);
        Content content = new Content("text/html", message);

        Mail mail = new Mail(rec, subject, receiver, content);

        Attachments attachments3 = new Attachments();
        Base64 x = new Base64();
        String imageDataString = x.encodeAsString(attachment);
        attachments3.setContent(imageDataString);
        attachments3.setType("application/pdf");
        attachments3.setFilename(attachmentName);
        attachments3.setDisposition("attachment");
        attachments3.setContentId("Reports");
        mail.addAttachments(attachments3);

        SendGrid sg = new SendGrid(twilioAPIKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info("Status code"+response.getStatusCode());
            log.info("Body"+response.getBody());
            log.info(response.getHeaders().toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to process request,please try again.");
        }

    }

    @Override
    public void  sendMailNotificationWithAttachmentToMultipleReceipts(String name,String []to, String from, String subject, String message, byte[] attachment, String attachmentName){
        Email rec = new Email(from);
        rec.setName(name);
        Content content = new Content("text/html", message);
        Mail mail = new Mail ();
        mail.setFrom(rec);
        mail.setSubject(subject);
        mail.addContent(content);
        Personalization personalization = new Personalization();
        for (int i = 0, size = to.length; i < size; i++) {
            personalization.addTo (new Email (to [i]));
        }
        mail.addPersonalization (personalization);

        Attachments attachments3 = new Attachments();
        Base64 x = new Base64();
        String imageDataString = x.encodeAsString(attachment);
        attachments3.setContent(imageDataString);
        attachments3.setType("application/pdf");
        attachments3.setFilename(attachmentName);
        attachments3.setDisposition("attachment");
        attachments3.setContentId("Reports");
        mail.addAttachments(attachments3);

        SendGrid sg = new SendGrid(twilioAPIKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info("Status code"+response.getStatusCode());
            log.info("Body"+response.getBody());
            log.info(response.getHeaders().toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to process request,please try again.");
        }


    }
}
