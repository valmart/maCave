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
            bouteille.volume_bouteille = bouteilleForm.volume_bouteille;
            bouteille.isGift = (bouteilleForm.isGift == true ? true : false);
            bouteille.infos = bouteilleForm.infos;
            bouteille.save();
            bouteille.qr_code = BarCode.addToBottle(bouteille.id);
            bouteille.cave = cave;
            bouteille.update();
            cave.bouteilles.add(bouteille);
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

    public static List<Bouteille> getAvailableBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getAvailableBottles(Cave cave, Couleur couleur){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", couleur)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getAvailableRedBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROUGE)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getAvailableWhiteBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.BLANC)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getAvailableRoseBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROSE)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getAvailableOtherBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.AUTRE)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getDrunkBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", false)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getGiftBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isGift", true)
                .eq("cave.owner", cave.owner)
                .findList();
    }

    public static List<Bouteille>   getGiveAsGiftBottles(Cave cave){
        return Bouteille.find.where()
                .eq("giveAsGift", true)
                .eq("cave.owner", cave.owner)
                .findList();
    }
}
