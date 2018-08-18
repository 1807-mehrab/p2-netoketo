package com.revature.beans;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "RECIPERATINGS")
public class RecipeRating
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeRatingSeq")
    @SequenceGenerator(allocationSize = 1, name = "recipeRatingSeq", sequenceName = "PK_RECIPERATING_SEQ")
    @Column
    private int ratingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNERID")
    private User owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RECIPEID")
    private Recipe recipe;

    @Pattern(regexp = "-1|1")
    @Column
    private int valNum;

    @Column
    private LocalDateTime dateCreated;

    public int getRatingId()
    {
        return ratingId;
    }

    public void setRatingId(int ratingId)
    {
        this.ratingId = ratingId;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public int getValNum()
    {
        return valNum;
    }

    public void setValNum(int valNum)
    {
        this.valNum = valNum;
    }

    public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString()
    {
        return "RecipeRating{" +
                "ratingId=" + ratingId +
                ", owner=" + owner +
                ", recipe=" + recipe +
                ", valNum=" + valNum +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
