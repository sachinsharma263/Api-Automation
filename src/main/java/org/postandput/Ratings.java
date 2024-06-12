package org.postandput;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Ratings {

    @JsonAlias("2020")
    private int t2020;

    @JsonAlias("2021")
    private int t2021;

    private List<Integer> annotation;

    public Ratings() {
    }

    public int getT2020() {
        return t2020;
    }

    public void setT2020(int t2020) {
        this.t2020 = t2020;
    }

    public int getT2021() {
        return t2021;
    }

    public void setT2021(int t2021) {
        this.t2021 = t2021;
    }

    public List<Integer> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(List<Integer> annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "t2020=" + t2020 +
                ", t2021=" + t2021 +
                ", annotation=" + annotation +
                '}';
    }
}
