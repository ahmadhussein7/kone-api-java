package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    private int version_major;
    private int version_minor;
    private List<Group> groups;

    private List<Destination> destinations;

    public int getVersion_major() {
        return version_major;
    }

    public void setVersion_major(int version_major) {
        this.version_major = version_major;
    }

    public int getVersion_minor() {
        return version_minor;
    }

    public void setVersion_minor(int version_minor) {
        this.version_minor = version_minor;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
