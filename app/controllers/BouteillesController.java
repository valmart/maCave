package controllers;

import forms.BouteilleForm;
import managers.BouteilleManager;
import models.Bouteille;
import models.Cave;
import models.Couleur;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

/**
 * Created by val on 19/09/15.
 */
public class BouteillesController extends Controller {

    public static Result addBottle(){
        BouteilleForm bouteille = new BouteilleForm();
        Form<BouteilleForm> bottleForm = form(BouteilleForm.class).fill(bouteille);
        return (ok(views.html.creation_bouteille.render(bottleForm)));
    }

    public static Result doAddBottle() {
        Form<BouteilleForm> form = form(BouteilleForm.class).bindFromRequest();
        if (form.hasErrors())
            return badRequest(views.html.creation_bouteille.render(form));
        Cave cave = Application.getLocalUser(session()).caves.get(0);
        BouteilleManager.create(form.get(), cave); // TODO Passer la cave en parametre dans le form ?
        flash(Application.FLASH_MESSAGE, "Your new bottle(s) have been created");
        return redirect(routes.CaveController.showCave());
    }

    public static Result bottleDetails(Long id){
        Bouteille bouteille = Bouteille.find.byId(id);
        if (bouteille != null)
            return ok(views.html.details_bouteille.render(bouteille));
        return redirect(controllers.routes.Application.index());
    }

    public static Result    deleteBottle(Long id){
        Bouteille bouteille = Bouteille.find.byId(id);
        BouteilleManager.delete(bouteille);
        flash(Application.FLASH_MESSAGE, "La bouteille est inscrite comme consommée");
        return redirect(routes.CaveController.showCave());
    }

    public static Result    giveBottleAsGift(Long id){
        Bouteille bouteille = Bouteille.find.byId(id);
        BouteilleManager.give(bouteille);
        flash(Application.FLASH_MESSAGE, "La bouteille est inscrite comme offerte");
        return redirect(routes.CaveController.showCave());
    }

    public static Result    getBottleList(String couleur){
        Couleur enumColor = Couleur.valueOf(couleur.toUpperCase());
        User currUser = Application.getLocalUser(session());
        if (currUser != null) {
            if (currUser.caves.size() > 0) {
                Cave cave = currUser.caves.get(0);
                return (ok(views.html.liste_page.render(cave, enumColor)));
            }
        }
        return ok(views.html.signup.render(null));
    }
}
