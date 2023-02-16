package org.example.models.resources;

import java.util.List;

public class Group {
    private String name;

    private String id;

    private List<Object> kens;

    private String desc;

    private List<String> products;

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public List<Object> getKens(){
        return kens;
    }

    public String getDesc(){
        return desc;
    }

    public List<String> getProducts(){
        return products;
    }
}
