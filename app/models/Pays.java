package models;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by val on 19/09/15.
 */
public enum Pays {
    @EnumValue("FRANCE")
    FRANCE ("France"),
    @EnumValue("ITALIE")
    ITALIE ("Italie"),
    @EnumValue("AUSTRALIE")
    AUSTRALIE ("Australie"),
    @EnumValue("CHILI")
    CHILI ("Chili");

    private String pays;

    Pays(String pays){
        this.pays = pays;
    }

    public String getPays(){
        return (this.pays);
    }
}
