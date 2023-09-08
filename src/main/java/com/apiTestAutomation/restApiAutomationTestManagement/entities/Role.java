package com.apiTestAutomation.restApiAutomationTestManagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
   private int id;

   @Enumerated(EnumType.STRING)
   private RoleType label;

    public Role(int id, RoleType label) {
        this.id = id;
        this.label = label;
    }

    public Role() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleType getLabel() {
        return this.label;
    }

    public void setLabel(RoleType label) {
        this.label = label;
    }
}
