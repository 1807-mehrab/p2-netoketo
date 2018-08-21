package com.revature.beans;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "RECIPERATINGS")
@JsonRootName(value = "reciperating")
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
    private Date dateCreated;

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

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
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
