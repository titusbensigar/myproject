package controllers;

import java.util.UUID;

import models.User;
import models.VerifyCode;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

public class Application extends Controller {

    public static Result index() {
//        return ok(index.render());
        return login();
    }
    
    public static Result login() {
        return ok(login.render());
    }
    
    public static Result join(Long userId, String code) {
    	Logger.info("userId: " + userId + " ; code: " + code);
    	User user = User.findById(userId);
    	String email = null;
    	if (user != null) {
    		email = user.email;
    	}
    	VerifyCode vCode = VerifyCode.find(email, code);
    	if (vCode != null) {
    		flash("success","Verification code matched.");
    		 return ok(dashboard.render());
    	} else {
    		flash("error","Verification code not matched.");
            return ok(login.render());
    	}
       
    }

    public static Result registerUser() {
    	Form<User> userForm = Form.form(User.class);
    	Logger.info("userForm: " + userForm);
    	User user = userForm.bindFromRequest().get();
    	Logger.info("user: " + user);
    	Logger.info("user: " + user.email);
    	user.save();
    	String uuid = UUID.randomUUID().toString();
    	VerifyCode verifyCode = new VerifyCode();
    	verifyCode.emailAddress = user.email;
    	verifyCode.type = "join";
    	verifyCode.code = uuid;
    	verifyCode.save();
    	MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
    	mail.setSubject("Registration - myproject");
    	mail.addRecipient(user.email);
    	mail.addFrom("Titus Bensigar <titus.bensigar@gmail.com>");
//    	mail.setReplyTo("Do Not Reply <noreply@gmail.com>");
    	//sends html
    	String url = "http://localhost:9000/join/"+user.id+"/" + uuid;
    	StringBuffer msg = new StringBuffer();
    	msg.append("<html>Hello ").append(user.firstname).append(", <br/><br/> Please click the below link to accept the registration with myproject");
    	msg.append("<br/> ").append(url).append("<br/><br/>").append("Regards,<br/> myproject Team</html>");
    	mail.sendHtml(msg.toString() );
    	flash("success","Successfully registered with myproject, please check your email to activate your login.");
        return ok(login.render());
    }
}
