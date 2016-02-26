package managers;

import forms.BouteilleForm;
import models.Bouteille;
import models.Cave;
import models.Couleur;
import play.db.ebean.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by val on 19/09/15.
 */
public class BouteilleManager {

    public static void create(BouteilleForm bouteilleForm, Cave cave) {
        int i = bouteilleForm.nbr_bouteille;
        while (i > 0) {
            Bouteille bouteille = new Bouteille();
            bouteille.millesime = bouteilleForm.millesime;
            bouteille.couleur = bouteilleForm.couleur;
            bouteille.date_creation = new Date();
            bouteille.degre_alcool = bouteilleForm.degre_alcool;
            bouteille.volume_bouteille = bouteilleForm.volume_bouteille;
            bouteille.isAvailable = true;
            bouteille.derniere_modification = new Date();
            bouteille.save();
            BarCode barCode = new BarCode(bouteille.id);
            bouteille.qr_code = barCode.path;
            bouteille.cave = cave;
            bouteille.update();
            cave.bouteilles.add(bouteille);
            i--;
        }
        cave.update();
    }

    public static void  addQR(Bouteille bouteille, BarCode qr){
        bouteille.qr_code = qr.path;
    }

    @Transactional
    public static void  delete(Bouteille bouteille){
        bouteille.isAvailable = false;
        bouteille.update();
    }

    public static List<Bouteille> getAvailableBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .findList();
    }

    public static List<Bouteille>   getAvailableRedBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROUGE)
                .findList();
    }

    public static List<Bouteille>   getAvailableWhiteBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.BLANC)
                .findList();
    }

    public static List<Bouteille>   getAvailableRoseBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROSE)
                .findList();
    }

    public static List<Bouteille>   getAvailableOtherBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.AUTRE)
                .findList();
    }

    public static List<Bouteille>   getDrunkBottles(){
        return Bouteille.find.where()
                .eq("isAvailable", false)
                .findList();
    }
}
