package com.example.arek.zadanie6;

/**
 * Created by Arek on 2017-04-12.
 */

public class Entry {
    public int Logo;
    public String Name;
    public String[] Categories;

    public Entry(String name, int logo)
    {
        this.Name = name;
        this.Logo = logo;
    }

    public Entry(String name, int logo, String[] categories){
        this.Name = name;
        this.Logo = logo;
        this.Categories = categories;
    }

}
