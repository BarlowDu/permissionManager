package com.barlow.permission.model;

/**
 * Created by dtc on 2017/3/25.
 */
public class Resource {
    private int id;
    private String name;
    private String url;
    private int parent_id;
    private String parent_ids;
    private String permission;
    private boolean available;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(String parent_ids) {
        this.parent_ids = parent_ids;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
