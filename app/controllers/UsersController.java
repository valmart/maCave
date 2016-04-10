package controllers;

import forms.LoginForm;
import forms.SignupForm;
import managers.CaveManager;
import managers.UserManager;
import models.Cave;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

/**
 * Created by val on 02/10/15.
 */
public class UsersController extends Controller {
    public static Result    login(){
        Form<LoginForm> loginForm = form(LoginForm.class);
        return ok(views.html.signin.render(loginForm));
    }

    public static Result    doLogin(){
        final Form<LoginForm> filledForm = form(LoginForm.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.signin.render(filledForm));
        } else {
            UserManager.AuthenticationState result = UserManager.authenticate(filledForm.get().email, filledForm.get().password);
            System.out.println(result);
            if (result == UserManager.AuthenticationState.AUTHENTICATED)
                return redirect(routes.CaveController.showCave());
        }
        return ok(views.html.signup.render(null));
    }

    public static Result    signup(){
        Form<SignupForm> signupForm = form(SignupForm.class);
        return ok(views.html.signup.render(signupForm));
    }

    public static Result    doSignup() {
        final Form<SignupForm> filledForm = form(SignupForm.class).bindFromRequest();
        if (filledForm.hasErrors()){
            return badRequest(views.html.signup.render(filledForm));
        } else {
            User user = UserManager.create(filledForm.get());
            if (user == null)
                return badRequest(views.html.signup.render(filledForm));
            CaveManager.create(user);
            UserManager.authenticate(filledForm.get().email, filledForm.get().password);
            return redirect(routes.CaveController.showCave());
        }
    }

    public static Result logout(){
        UserManager.logout(ctx());
        return ok(views.html.signin.render(null));
    }
}
