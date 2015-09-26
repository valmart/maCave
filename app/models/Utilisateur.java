package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by val on 19/09/15.
 */
@Entity
public class Utilisateur extends Model{
    @Id
    int     id;

    @Constraints.Required
    String  nom;

    @Constraints.Required
    String  prenom;

    @Constraints.Required
    String  pseudo;

    @Constraints.Required
    String  mot_de_passe;

    @Constraints.Required
    Date    creation;
}
