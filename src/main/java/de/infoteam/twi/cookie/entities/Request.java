package de.infoteam.twi.cookie.entities;

public class Request {

    private String recipeName;

    public Request() {

    }

    public Request(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String toString() {
        return "Request=[recipeName="+recipeName+"]";
    }
}
