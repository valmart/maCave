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

    //public int            prix_achat;

    public Boolean          isAvailable;

    public Boolean          isGift;

    public String           infos;

    public Boolean          giveAsGift;

    public Date             date_utilisation;

    public Date             date_creation;

    public Date             derniere_modification;

    public Bouteille(){
        this.isAvailable = true;
        this.giveAsGift = false;
        this.date_creation = new Date();
        this.derniere_modification = new Date();
    }

    public static Finder<Long, Bouteille> find = new Finder<Long, Bouteille>(Long.class, Bouteille.class);
}
