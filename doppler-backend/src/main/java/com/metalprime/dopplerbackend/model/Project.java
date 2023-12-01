package com.metalprime.dopplerbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> partners_id;

    private String description;

    private String name;

    private String bean_id;

    public Project() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getPartners_id() {
        return partners_id;
    }

    public void setPartners_id(List<Integer> partners_id) {
        this.partners_id = partners_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBean_id() {
        return bean_id;
    }

    public void setBean_id(String bean_id) {
        this.bean_id = bean_id;
    }

}
