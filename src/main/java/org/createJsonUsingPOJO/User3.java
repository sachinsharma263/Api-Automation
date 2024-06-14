package org.createJsonUsingPOJO;

import java.util.ArrayList;
import java.util.List;

public class User3 {

    private String email;
    private String firstName;
    private  String lastName;

    private List<String> technolgies;

    Address address;

    public User3(String email, String firstName, String lastName) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;

        technolgies=new ArrayList<String>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getTechnolgies() {
        return technolgies;
    }

    public void setTechnolgies(List<String> technolgies) {
        this.technolgies = technolgies;
    }
    public  void addTechnoligies(String technology)
    {
        this.technolgies.add(technology);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
