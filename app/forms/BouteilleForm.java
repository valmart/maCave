package forms;


import models.Category;
import models.Couleur;
import models.Producteur;
import models.Utilisateur;
import play.data.validation.Constraints;

import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by val on 20/09/15.
 */
public class BouteilleForm {
    @Constraints.Required
    public String           domaine;

    @Constraints.Required
    public Category                category;

    public int              degre_alcool;

    public int              volume_bouteille;

    public Producteur       producteur;

    @Constraints.Required
    public int              millesime;

    public String           appellation;

    @Constraints.Required
    public Couleur          couleur;

    @Constraints.Required
    public int              nbr_bouteille;
}
