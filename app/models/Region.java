package models;

/**
 * Created by val on 19/09/15.
 */
public enum Region {
    BORDEAU ("Bordeau"),
    ANJOU ("Anjou"),
    ALSACE ("Alsace");

    private String region;

    Region(String region){
        this.region = region;
    }

    public String getRegion(){
        return (this.region);
    }
}
