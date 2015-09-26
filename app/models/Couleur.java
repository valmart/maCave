package models;

import com.avaje.ebean.annotation.EnumValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by val on 19/09/15.
 */
public enum Couleur {
    @EnumValue("ROUGE")
    ROUGE ("Rouge"),
    @EnumValue("BLANC")
    BLANC ("Blanc"),
    @EnumValue("ROSE")
    ROSE  ("Rose");

    private String couleur;

    Couleur(String couleur){
        this.couleur = couleur;
    }

    public String getCouleur(){
        return (this.couleur);
    }

    public static List<Couleur> getCouleurs()
    {
        List<Couleur> couleurs = Arrays.asList(values());
        Collections.sort(couleurs, new Comparator<Couleur>() {
            @Override
            public int compare(final Couleur object1, final Couleur object2) {
                return object1.getName().compareTo(object2.getName());
            }
        });
        return couleurs;
    }


    public String getName()
    {
        return getCouleur();
    }

    public String getCode()
    {
        return name();
    }
}
