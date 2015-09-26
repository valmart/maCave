package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by val on 20/09/15.
 */
@Entity
public class Cave extends Model {
    @Id
    Long    id;

    @Constraints.Required
    String  name;
}
