package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by val on 19/09/15.
 */

@Entity
public class Bouteille extends Model {
    @Id
    public Long             id;

    @ManyToOne
    public Cave             cave;

    public String           domaine;

    public String           appellation;

    public int              millesime;

    public Couleur          couleur;

    public int              volume_bouteille;

    public String           qr_code;

    public int              prix_achat;

    public Boolean          isAvailable;

    public Boolean          isGift;

    public Date             date_utilisation;

    public Date             date_creation;

    public Date             derniere_modification;

    public Bouteille(){

    }

    public static Finder<Long, Bouteille> find = new Finder<Long, Bouteille>(Long.class, Bouteille.class);

    public static List<Bouteille> getAvailableBottles(Cave cave){
        return Bouteille.find.where()
                .eq("isAvailable", true)
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
}
