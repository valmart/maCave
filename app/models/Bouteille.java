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

    public String           appellation;

    public int              millesime;

    public Couleur          couleur;

    public int              degre_alcool;

    public int              volume_bouteille;

    public String           qr_code;

    public int              prix_achat;

    public Boolean          isAvailable;

    public Date             date_ouverture;

    public Date             date_creation;

    public Date             derniere_modification;

    public Bouteille(){

    }

    public static Finder<Long, Bouteille> find = new Finder<Long, Bouteille>(Long.class, Bouteille.class);

    public static List<Bouteille> getAvailableBottles(){
        return find.where()
                .eq("isAvailable", true)
                .findList();
    }

    public static List<Bouteille>   getAvailableRedBottles(){
        return find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROUGE)
                .findList();
    }

    public static List<Bouteille>   getAvailableWhiteBottles(){
        return find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.BLANC)
                .findList();
    }

    public static List<Bouteille>   getAvailableRoseBottles(){
        return find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.ROSE)
                .findList();
    }

    public static List<Bouteille>   getAvailableOtherBottles(){
        return find.where()
                .eq("isAvailable", true)
                .eq("couleur", Couleur.AUTRE)
                .findList();
    }

    public static List<Bouteille>   getDrunkBottles(){
        return find.where()
                .eq("isAvailable", false)
                .findList();
    }
}
