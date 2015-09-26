package models;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by val on 24/09/15.
 */
public enum BouteilleStatus {
    @EnumValue("DISPONIBLE")
    DISPONIBLE ("Disponible"),
    @EnumValue("CONSOMMEE")
    CONSOMME ("Consomme");

    private String status;

    BouteilleStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return (this.status);
    }
}
