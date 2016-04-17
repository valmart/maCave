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
        if (currUser != null) {
            if (currUser.caves.size() > 0) {
                // Une seule cave par utilisateur (pour l'instant)
                Cave cave = currUser.caves.get(0);
                return (ok(views.html.cave.render(cave)));
            }
        }
        return ok(views.html.signup.render(null));
    }

    public static Result getHistorique(){
        User currUser = Application.getLocalUser(session());
        if (currUser != null) {
            if (currUser.caves.size() > 0) {
                Cave cave = currUser.caves.get(0);
                return (ok(views.html.liste_historique.render(cave)));
            }
        }
        return ok(views.html.signup.render(null));
    }
}
