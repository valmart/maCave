package managers;

import forms.BouteilleForm;
import models.Bouteille;
import models.BouteilleStatus;
import play.db.ebean.Transactional;

import java.util.Date;

/**
 * Created by val on 19/09/15.
 */
public class BouteilleManager {
    @Transactional
    public static Bouteille create(BouteilleForm bouteilleForm) {
        Bouteille bouteille = new Bouteille();
        bouteille.domaine = bouteilleForm.domaine;
        bouteille.millesime = bouteilleForm.millesime;
        bouteille.couleur = bouteilleForm.couleur;
        bouteille.createur = null;
        bouteille.category = bouteilleForm.category;
        bouteille.date_creation = new Date();
        bouteille.degre_alcool = bouteilleForm.degre_alcool;
        bouteille.dernier_modificateur = null;
        bouteille.appellation = bouteilleForm.appellation;
        bouteille.nbr_bouteille = bouteilleForm.nbr_bouteille;
        bouteille.volume_bouteille = bouteilleForm.volume_bouteille;
        bouteille.status = BouteilleStatus.DISPONIBLE;
        bouteille.derniere_modification = new Date();
        bouteille.save();
        return (bouteille);
    }

    @Transactional
    public static void  addQR(Bouteille bouteille, BarCode qr){
        bouteille.qr_code = qr.path;
        bouteille.update();
    }

    @Transactional
    public static void  delete(Bouteille bouteille){
        if (bouteille.nbr_bouteille > 0) {
            bouteille.nbr_bouteille -= 1;
            if (bouteille.nbr_bouteille == 0)
                bouteille.status = BouteilleStatus.CONSOMME;
            bouteille.update();
        }
    }
}
