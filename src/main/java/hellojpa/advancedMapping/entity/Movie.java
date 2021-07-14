package hellojpa.advancedMapping.entity;

import javax.persistence.Entity;

@Entity
public class Movie extends Item{
    private String director;
    private String actor;

    public Movie() {
    }

    public Movie(String director, String actor) {
        this.director = director;
        this.actor = actor;
    }
}
