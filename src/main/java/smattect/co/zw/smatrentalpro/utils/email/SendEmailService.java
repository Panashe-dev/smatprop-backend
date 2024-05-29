package smattect.co.zw.smatrentalpro.utils.email;

public interface SendEmailService {

    void emailNotification(String  name,String from,String to, String subject, String message);

    void emailNotificationWithAttachment(String name,String to, String from,String subject, String message, byte[] attachment, String attachmentName);

    void  sendMailNotificationWithAttachmentToMultipleReceipts(String name,String []to, String from, String subject, String message, byte[] attachment, String attachmentName);
}
