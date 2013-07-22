package www.jointeams.com.QApp.util;

public class RegistrationEmail {

	public static String getMsg(String emailId) {
		String msg = "<h1>Skoolaid.ca</h1><p>&nbsp;</p><div>Here is the link to activate your account "
				+ "on skoolaid <a href=\"http://www.skoolaid.ca/verify_email.xhtml?id="
				+ emailId
				+ "\">http://www.schoolaid.ca/verify_email.xhtml?id="
				+ emailId
				+ "</a> <br /> If you did not sign up, disregard this email.</div>";
		return msg;
	}
}
