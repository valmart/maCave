package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by val on 20/09/15.
 */
@Entity
public class Cave extends Model {
    @Id
    public Long             id;

    @Column(nullable = false, unique=true)
    public String           name;

    @Column(nullable=false)
    @ManyToOne
    public User             owner;

    @Column(nullable = false)
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date             creation_date;
    @Column(nullable = false)
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date             last_update_date;

    @OneToMany(cascade=CascadeType.ALL)
    public List<Bouteille>  bouteilles;
}
