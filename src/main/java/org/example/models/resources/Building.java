package org.example.models.resources;

import java.util.List;

public class Building {
    private String name;

    private List<Group> groups;

    private String id;

    private String desc;

    public String getName(){
        return name;
    }

    public List<Group> getGroups(){
        return groups;
    }

    public String getId(){
        return id;
    }

    public String getDesc(){
        return desc;
    }
}
