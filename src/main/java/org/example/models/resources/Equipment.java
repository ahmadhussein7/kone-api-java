package org.example.models.resources;

import java.util.List;

public class Equipment {
    private String name;

    private String id;

    private String desc;

    private List<String> products;

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getDesc(){
        return desc;
    }

    public List<String> getProducts(){
        return products;
    }
}
