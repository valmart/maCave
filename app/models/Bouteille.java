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

    public Category         category;

    public int              degre_alcool;

    public int              volume_bouteille;

    @ManyToOne
    public Producteur       producteur;

    public int              millesime;

    public Couleur          couleur;

    public int              nbr_bouteille;

    public String           qr_code;

    @ManyToOne
    public Utilisateur      createur;

    public Date             date_creation;

    @ManyToOne
    public Utilisateur      dernier_modificateur;

    public Date             derniere_modification;

    public int              prix_achat;

    public String           origine;

    public BouteilleStatus  status;

    public int              note;

    public Date             date_ouverture;

    public Bouteille(){

    }

    public static Finder<Long, Bouteille> find = new Finder<Long, Bouteille>(Long.class, Bouteille.class);

    public static List<Bouteille> findAll(){
        return find.where()
                .eq("status", BouteilleStatus.DISPONIBLE)
                .findList();
    }

    public static List<Bouteille>   findRedBottles(){
        return find.where()
                .eq("status", BouteilleStatus.DISPONIBLE)
                .eq("couleur", Couleur.ROUGE)
                .findList();
    }

    public static List<Bouteille>   findWhiteBottles(){
        return find.where()
                .eq("status", BouteilleStatus.DISPONIBLE)
                .eq("couleur", Couleur.BLANC)
                .findList();
    }

    public static List<Bouteille>   findRoseBottles(){
        return find.where()
                .eq("status", BouteilleStatus.DISPONIBLE)
                .eq("couleur", Couleur.ROSE)
                .findList();
    }

    public static List<Bouteille>   findDrunkBottles(){
        return find.where()
                .eq("status", BouteilleStatus.CONSOMME)
                .findList();
    }
}
