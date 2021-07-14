package hellojpa.advancedMapping.entity;

import javax.persistence.Entity;

@Entity
public class Album extends Item{
    private String artist;

    public Album() {
    }

    public Album(String artist) {
        this.artist = artist;
    }
}
