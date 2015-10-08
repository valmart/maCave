package controllers;

import models.Cave;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by val on 08/10/15.
 */
public class CaveController extends Controller {
    public static Result showCave(){
        User currUser = Application.getLocalUser(session());
        Cave cave = currUser.caves.get(0);
        return (ok(views.html.cave.render(cave)));
    }
}
