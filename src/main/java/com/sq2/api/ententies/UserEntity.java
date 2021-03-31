package com.sq2.api.ententies;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    private int id;
    private String firstName;
    private String lastname;

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
