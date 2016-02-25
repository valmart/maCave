package managers;

import forms.BouteilleForm;
import models.Bouteille;
import models.Cave;
import play.db.ebean.Transactional;

import java.util.Date;

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
}
