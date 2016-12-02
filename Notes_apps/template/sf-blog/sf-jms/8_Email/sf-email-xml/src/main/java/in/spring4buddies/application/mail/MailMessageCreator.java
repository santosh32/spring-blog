package in.spring4buddies.application.mail;

public interface MailMessageCreator {

	void sendMail(final MailContent mailData);
}