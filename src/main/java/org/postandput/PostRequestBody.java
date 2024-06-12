package org.postandput;

import java.util.List;

public class PostRequestBody {

    private int id;
    private String name;
    private String job;
    private List<String> designations;

    private Ratings rating;

    public PostRequestBody() {
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<String> getDesignations() {
        return designations;
    }

    public void setDesignations(List<String> designations) {
        this.designations = designations;
    }

    public Ratings getRating() {
        return rating;
    }

    public void setRating(Ratings rating) {
        this.rating = rating;
    }
}
