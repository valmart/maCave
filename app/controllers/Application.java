package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by val on 20/09/15.
 */
public class Application extends Controller{

    public static final String FLASH_MESSAGE = "message";
    public static final String FLASH_ERROR = "error";

    public static Result index(){
        return ok(views.html.index.render("Bienvenue sur cavavin"));
    }
}
