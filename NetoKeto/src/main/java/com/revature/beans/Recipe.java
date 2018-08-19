package com.revature.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RECIPES")
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSeq")
    @SequenceGenerator(allocationSize = 1, name = "recipeSeq", sequenceName = "PK_RECIPE_SEQ")
    private int recipeId;

    @Column
    private String recipeName;

    @Column
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DELETEDBY")
    private User deletedBy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "OWNERID", nullable = false, referencedColumnName = "AccountID")
    private User owner;

    @Column
    private Boolean flagged;

    @NotNull
    @Column
    private Date dateCreated;

    @NotNull
    @Size(max = 300)
    @Column
    private String description;

    @NotNull
    @Size(max = 300)
    @Column
    private String ingredients;

    @NotNull
    @Size(max = 300)
    @Column
    private String cookingInstructions;

    @OneToOne(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image image;
    
    @JsonIgnore
    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "recipe")
    private List<RecipeRating> recipeRatings;

    public int getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }

    public String getRecipeName()
    {
        return recipeName;
    }

    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public Boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public User getDeletedBy()
    {
        return deletedBy;
    }

    public void setDeletedBy(User deletedBy)
    {
        this.deletedBy = deletedBy;
    }

    @NotNull
    public User getOwner()
    {
        return owner;
    }

    public void setOwner(@NotNull User owner)
    {
        this.owner = owner;
    }

    public Boolean isFlagged()
    {
        return flagged;
    }

    public void setFlagged(Boolean flagged)
    {
        this.flagged = flagged;
    }

    @NotNull
    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(@NotNull Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

    public List<RecipeRating> getRecipeRatings()
    {
        return recipeRatings;
    }

    public void setRecipeRatings(List<RecipeRating> recipeRatings)
    {
        this.recipeRatings = recipeRatings;
    }

    @NotNull
    public String getDescription()
    {
        return description;
    }

    public void setDescription(@NotNull String description)
    {
        this.description = description;
    }

    @NotNull
    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(@NotNull String ingredients)
    {
        this.ingredients = ingredients;
    }

    @NotNull
    public String getCookingInstructions()
    {
        return cookingInstructions;
    }

    public void setCookingInstructions(@NotNull String cookingInstructions)
    {
        this.cookingInstructions = cookingInstructions;
    }

    @Override
    public String toString()
    {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", deleted=" + deleted +
                ", deletedBy=" + deletedBy +
                ", owner=" + owner +
                ", flagged=" + flagged +
                ", dateCreated=" + dateCreated +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", cookingInstructions='" + cookingInstructions + '\'' +
                ", image=" + image +
                ", comments=" + comments +
                ", recipeRatings=" + recipeRatings +
                '}';
    }
}
