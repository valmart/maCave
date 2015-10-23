package models;

import com.avaje.ebean.Model;
import org.mindrot.jbcrypt.BCrypt;
import play.data.format.Formats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by val on 02/10/15.
 */
@Entity
public class User extends Model{
    @Id
    public Long         id;

    @Column(nullable = false, unique=true)
    public String       email;
    public boolean      is_email_validated;
    @Column(unique=true)
    public String       nickname;
    @Column(nullable = false)
    public String       password;

    public String       first_name;
    public String       last_name;
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date         birth_date;

    @OneToMany(mappedBy = "owner")
    public List<Cave>   caves;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="account")
    //public List<String> pictures_url; // Todo : créer un objet pour stocker les images toussa toussa

    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date         creation_date;
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date         last_connection_date;

    public User(String email, String password){
        this.email = email;
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = hashPassword;
        this.caves = new ArrayList<>();
    }

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static User findByMail(String email){
        return find.where()
                .eq("email", email)
                .findUnique();
    }
}
