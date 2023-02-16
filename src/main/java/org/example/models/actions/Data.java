package org.example.models.actions;

import java.util.List;

public class Data {

    private int version_minor;

    private List<CallType> call_types;

    private List<Object> functions;

    private int version_major;

    private List<Object> action_set;

    public int getVersion_minor() {
        return version_minor;
    }

    public void setVersion_minor(int version_minor) {
        this.version_minor = version_minor;
    }

    public List<CallType> getCall_types() {
        return call_types;
    }

    public void setCall_types(List<CallType> call_types) {
        this.call_types = call_types;
    }

    public List<Object> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Object> functions) {
        this.functions = functions;
    }

    public int getVersion_major() {
        return version_major;
    }

    public void setVersion_major(int version_major) {
        this.version_major = version_major;
    }

    public List<Object> getAction_set() {
        return action_set;
    }

    public void setAction_set(List<Object> action_set) {
        this.action_set = action_set;
    }
}
