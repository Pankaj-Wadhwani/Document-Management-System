
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailExample {
//	public static void main(String[] args) {
//            sendMail("abc","abc","abc");
//        }
        public static void sendMail(String userName,String docName,String date,String toEmailId,String str1,String str2){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("pankajwadhwani100@gmail.com","pan3126637109kaj");
				}
			});

		try {
                        //String name="abc" ,docName="aa",date="tss";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pankajwadhwani100@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmailId));
			message.setSubject("VESP Document Management System");
			message.setText("Dear " +userName + ",\n                      Thankyou for "+ str1 +" . You "+ str2 +" "+docName+" document on the date "+date+".\n"+"Thanks.");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
                     JOptionPane.showMessageDialog(null, e.getMessage(),"Email",JOptionPane.ERROR_MESSAGE);
		}
	}
}