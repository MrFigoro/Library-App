package com.mylibrary.app.api;

import com.fasterxml.jackson.annotation.JsonProperty;
//import org.hibernate.validator.constraints.NotEmpty;

public class User {

//    @NotEmpty
    private String firstName;
//    @NotEmpty
    private String lastName;
    private String id;

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
