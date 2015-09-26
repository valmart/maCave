package models;

import com.avaje.ebean.annotation.EnumValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by val on 20/09/15.
 */
public enum Category {
    @EnumValue("VIN_DE_TABLE")
    VIN_DE_TABLE ("Vin de table"),
    @EnumValue("VIN_DE_PAYS")
    VIN_DE_PAYS ("Vin de pays"),
    @EnumValue("AOC")
    AOC  ("AOC");

    private String category;

    Category(String category){
        this.category = category;
    }

    public String getCategory(){
        return (this.category);
    }

    public static List<Category> getCategories()
    {
        List<Category> categories = Arrays.asList(values());
        Collections.sort(categories, new Comparator<Category>() {
            @Override
            public int compare(final Category object1, final Category object2) {
                return object1.getName().compareTo(object2.getName());
            }
        });
        return categories;
    }


    public String getName()
    {
        return getCategory();
    }

    public String getCode()
    {
        return name();
    }
}
