package controllers;

import managers.UserManager;
import models.User;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by val on 20/09/15.
 */
public class Application extends Controller{

    public static final String FLASH_MESSAGE = "message";
    public static final String FLASH_ERROR = "error";

    public static User getLocalUser(final Http.Session session) {
        User user = UserManager.getCurrentUser(session);
        System.out.println(user);
        return (user);
    }

    public static Result index(){
        return ok(views.html.index.render("Bienvenue sur cavavin"));
    }
}
