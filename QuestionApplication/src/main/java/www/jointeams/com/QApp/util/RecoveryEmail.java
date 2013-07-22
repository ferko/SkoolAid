package www.jointeams.com.QApp.util;

public class RecoveryEmail {

	public static String getMsg(String emailId, String userName) {
		String msg = "<h1>Skoolaid.ca</h1><p>&nbsp;</p><div>Here is the link to reset your password "
				+ "on skoolaid for username: <h5>" + userName +
				"</h5>  <a href=\"http://www.skoolaid.ca/password_reset.xhtml?id="
				+ emailId
				+ "\">http://www.skoolaid.ca/paasword_reset.xhtml?id="
				+ emailId
				+ "</a> <br /> If you did not sign up, disregard this email.</div>";
		return msg;
	}
}
