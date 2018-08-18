package com.revature.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RECIPES")
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSeq")
    @SequenceGenerator(allocationSize = 1, name = "recipeSeq", sequenceName = "PK_RECIPE_SEQ")
    private int recipeId;

    @Column
    private boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DELETEDBY")
    private User deletedBy;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNERID", nullable = false)
    private User owner;

    @Column
    private boolean flagged;

    @NotNull
    @Column
    private LocalDateTime dateCreated;

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

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;

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

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
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

    public boolean isFlagged()
    {
        return flagged;
    }

    public void setFlagged(boolean flagged)
    {
        this.flagged = flagged;
    }

    @NotNull
    public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(@NotNull LocalDateTime dateCreated)
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
