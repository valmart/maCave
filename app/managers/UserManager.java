package managers;

import forms.SignupForm;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.mvc.Http;

import static play.mvc.Controller.ctx;

/**
 * Created by val on 02/10/15.
 */
public class UserManager {
    public static enum AuthenticationState {
        AUTHENTICATED,
        FAILED
    }

    private static final String USER_KEY = "cave.user.id";

    public static User create(SignupForm signupForm){
        User user = UserManager.findByMail(signupForm.email);
        if (user == null) {
            User newUser = new User(signupForm.email, signupForm.password);
            newUser.save();
            return (newUser);
        }
        return user;
    }

    public static AuthenticationState authenticate(String userMail, String password){
        User user = UserManager.findByMail(userMail);
        if (BCrypt.checkpw(password, user.password)) {
            storeUser(ctx().session(), userMail);
            return (AuthenticationState.AUTHENTICATED);
        }
        return (AuthenticationState.FAILED);
    }

    public static User getCurrentUser(Http.Session session) {
        String userId = session.get(USER_KEY);
        if (userId != null) {
            return UserManager.findByMail(userId);
        }
        return null;
    }

    public static void storeUser(Http.Session session, String userMail) {
        session.put(USER_KEY, userMail);
    }

    public static void logout(final Http.Context context) {
        Http.Session session = context.session();
        session.remove(USER_KEY);
    }

    public static User findByMail(String email){
        return User.find.where()
                .eq("email", email)
                .findUnique();
    }
}
