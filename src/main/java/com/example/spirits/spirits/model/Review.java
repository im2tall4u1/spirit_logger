package com.example.spirits.spirits.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Review {
    @Id
    private int reviewId;
    private int rating;
    private int spiritId;
    private String description;

    public Review(){
        super();
    }

    public Review(int reviewId, int rating, int spiritId, String description){
        super();
        this.reviewId = reviewId;
        this.rating = rating;
        this.spiritId = spiritId;
        this.description = description;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSpiritId() {
        return spiritId;
    }

    public void setSpiritId(int spiritId) {
        this.spiritId = spiritId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Review [id=" + reviewId + ", rating=" + rating + ", spiritId=" + spiritId + ", description=" + description
        + "]";
    }
    
}
