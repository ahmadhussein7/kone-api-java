package org.example.models.actions;

public class CallType {

    private int action_id;

    private String action_type;

    private boolean preferred_allowed;

    private String name;

    private boolean enabled;

    private int key;

    private boolean direct_allowed;

    private boolean group_call_allowed;

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public boolean isPreferred_allowed() {
        return preferred_allowed;
    }

    public void setPreferred_allowed(boolean preferred_allowed) {
        this.preferred_allowed = preferred_allowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isDirect_allowed() {
        return direct_allowed;
    }

    public void setDirect_allowed(boolean direct_allowed) {
        this.direct_allowed = direct_allowed;
    }

    public boolean isGroup_call_allowed() {
        return group_call_allowed;
    }

    public void setGroup_call_allowed(boolean group_call_allowed) {
        this.group_call_allowed = group_call_allowed;
    }

    @Override
    public String toString() {
        return action_type + " - " + name + " - " + action_id;
    }
}
