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

    public String       password;

    @OneToMany(mappedBy = "owner")
    public List<Cave>   caves;

    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date         creation_date;
    @Formats.DateTime(pattern="dd/MM/yyyy HH:mm:ss")
    public Date         last_connection_date;

    public User(String email, String password){
        this.email = email;
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = hashPassword;
        this.caves = new ArrayList<>();
        this.creation_date = new Date();
        this.last_connection_date = new Date();
    }

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static User findByMail(String email){
        return find.where()
                .eq("email", email)
                .findUnique();
    }
}
