package models;

import com.avaje.ebean.Model;
import managers.BarCode;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by val on 20/09/15.
 */
@Entity
public class Cave extends Model {
    @Id
    public Long             id;

    @Column(nullable=false)
    @ManyToOne
    public User             owner;

    @OneToMany(cascade=CascadeType.ALL)
    public List<Bouteille>  bouteilles;

    @Column(nullable = false)
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date             creation_date;

    @Column(nullable = false)
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date             last_update_date;

    public String           qr_code;

    public static Finder<Long, Cave> find = new Finder<Long, Cave>(Long.class, Cave.class);

    public Cave(User owner){
        this.owner = owner;
        this.creation_date = new Date();
        this.last_update_date = new Date();
        this.bouteilles = new ArrayList<>();
    }
}
