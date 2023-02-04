package com.psrestassured.pojoobjects;

public class User {

    private String email;
    private String job;

    public User(String email, String job){

        this.email=email;
        this.job=job;

    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
