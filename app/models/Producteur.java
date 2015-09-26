package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by val on 19/09/15.
 */
@Entity
public class Producteur extends Model {
    @Id
    Long     id;

    @Constraints.Required
    String  nom;

    @Constraints.Required
    String  prenom;

    @Constraints.Required
    Region  region;

    @Constraints.Required
    Pays    pays;
}
