package forms;


import models.Couleur;
import play.data.validation.Constraints;

/**
 * Created by val on 20/09/15.
 */
public class BouteilleForm {
    @Constraints.Required
    public String           domaine;

    public String           appellation;

    public int              volume_bouteille;

    @Constraints.Required
    public int              millesime;

    @Constraints.Required
    public Couleur          couleur;

    @Constraints.Required
    public int              nbr_bouteille;
}
