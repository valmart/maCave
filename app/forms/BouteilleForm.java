package forms;


import models.Couleur;
import play.data.validation.Constraints;

/**
 * Created by val on 20/09/15.
 */
public class BouteilleForm {
    @Constraints.Required
    public String           domaine;

    @Constraints.Required
    public String           appellation;

    @Constraints.Required
    public int              volume_bouteille;

    @Constraints.Required
    public int              millesime;

    @Constraints.Required
    public Couleur          couleur;

    @Constraints.Required
    public int              nbr_bouteille;

    @Constraints.Required
    public boolean          isGift;

    public String           infos;

    public String validate() {
        if(nbr_bouteille < 1) {
            return "Le nombre de bouteille doit être supérieur à 1";
        }
        return null;
    }
}
