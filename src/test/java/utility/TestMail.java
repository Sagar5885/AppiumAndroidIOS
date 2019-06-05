package utility;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestMail {

	public static void main(String args[]) throws AddressException, MessagingException {
		monitoringMail monitoringMail = new monitoringMail();
		monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}
}
