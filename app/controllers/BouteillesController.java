package controllers;

import forms.BouteilleForm;
import managers.BarCode;
import managers.BouteilleManager;
import models.Bouteille;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.data.Form.form;

/**
 * Created by val on 19/09/15.
 */
public class BouteillesController extends Controller {

    public static final Form<BouteilleForm> ADD_BOUTEILLE = form(BouteilleForm.class);

    public static Result getBottleList(){
        List<Bouteille> bouteilles = Bouteille.findAll();
        return ok(views.html.liste_bouteille.render(bouteilles));
    }

    public static Result getRedBottleList(){
        List<Bouteille> bouteilles = Bouteille.findRedBottles();
        return ok(views.html.liste_bouteille.render(bouteilles));
    }

    public static Result getWhiteBottleList(){
        List<Bouteille> bouteilles = Bouteille.findWhiteBottles();
        return ok(views.html.liste_bouteille.render(bouteilles));
    }

    public static Result getRoseBottleList(){
        List<Bouteille> bouteilles = Bouteille.findRoseBottles();
        return ok(views.html.liste_bouteille.render(bouteilles));
    }

    public static Result addBottle(){
        BouteilleForm bouteille = new BouteilleForm();
        Form<BouteilleForm> bottleForm = ADD_BOUTEILLE.fill(bouteille);
        return (ok(views.html.creation_bouteille.render(bottleForm)));
    }

    public static Result doAddBottle() {
        Form<BouteilleForm> form = ADD_BOUTEILLE.bindFromRequest();
        if (form.hasErrors())
            return badRequest(views.html.creation_bouteille.render(form));
        Bouteille bouteille = BouteilleManager.create(form.get());
        BarCode barCode = new BarCode(bouteille.id);
        BouteilleManager.addQR(bouteille, barCode);
        flash(Application.FLASH_MESSAGE, "Your new bottle have been created");
        return redirect(routes.BouteillesController.getBottleList());
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
        flash(Application.FLASH_MESSAGE, "Your bottle have been deleted");
        return redirect(routes.BouteillesController.getBottleList());
    }
}
