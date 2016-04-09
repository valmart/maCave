package managers;

import controllers.Application;
import forms.BouteilleForm;
import models.Bouteille;
import models.Cave;
import models.Couleur;
import models.User;
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
            bouteille.appellation = bouteilleForm.appellation;
            bouteille.domaine = bouteilleForm.domaine;
            bouteille.millesime = bouteilleForm.millesime;
            bouteille.couleur = bouteilleForm.couleur;
            bouteille.date_creation = new Date();
            bouteille.volume_bouteille = bouteilleForm.volume_bouteille;
            bouteille.isAvailable = true;
            bouteille.isGift = (bouteilleForm.isGift == true ? true : false);
            bouteille.infos = bouteilleForm.infos;
            bouteille.giveAsGift = false;
            bouteille.derniere_modification = new Date();
            bouteille.save();
            bouteille.qr_code = BarCode.addToBottle(bouteille.id);
            bouteille.cave = cave;
            bouteille.update();
            cave.bouteilles.add(bouteille);
            cave.bouteille_max = (cave.bouteille_max < Bouteille.getAvailableBottles(cave).size() ? Bouteille.getAvailableBottles(cave).size(): cave.bouteille_max);
            i--;
        }
        cave.update();
    }

    @Transactional
    public static void  delete(Bouteille bouteille){
        bouteille.isAvailable = false;
        bouteille.date_utilisation = new Date();
        bouteille.update();
    }

    @Transactional
    public static void give(Bouteille bouteille){
        bouteille.giveAsGift = true;
        BouteilleManager.delete(bouteille);
    }
}
