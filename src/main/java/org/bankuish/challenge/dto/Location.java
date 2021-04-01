package org.bankuish.challenge.dto;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class Location {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<URL> residents;
    private URL url;
    private Date created;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<URL> getResidents() {
        return residents;
    }

    public void setResidents(List<URL> residents) {
        this.residents = residents;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
