package com.revature.beans;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSeq")
    @SequenceGenerator(allocationSize = 1, name = "accountSeq", sequenceName = "PK_ACCOUNT_SEQ")
    @Column(name = "ACCOUNTID")
    private int userId;

    @NotNull
    @Size(max = 50)
    @Column(name = "USERNAME", unique = true, nullable = false, length = 50)
    private String username;

    @NotNull
    @Size(max = 50)
    @Column(name = "PASSWORD", nullable = false, length = 50)
    private String password;

    @NotNull
    @Size(max = 50)
    @Column(name = "EMAIL", unique = true, nullable = false, length = 50)
    private String email;

    @NotNull
    @Min(0)
    @Max(1)
    // if userType is 1, user is moderator, else user is not admin
    @Column(name = "ACCOUNTTYPE", nullable = false)
    private int userType;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Recipe> recipesCreated;

    @OneToMany(mappedBy = "deletedBy", cascade = CascadeType.ALL)
    private List<Recipe> recipesDeleted;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Comment> postedComments;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<RecipeRating> recipeRatingsUserRated;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

    public List<Recipe> getRecipesCreated()
    {
        return recipesCreated;
    }

    public void setRecipesCreated(List<Recipe> recipesCreated)
    {
        this.recipesCreated = recipesCreated;
    }

    public List<Recipe> getRecipesDeleted()
    {
        return recipesDeleted;
    }

    public void setRecipesDeleted(List<Recipe> recipesDeleted)
    {
        this.recipesDeleted = recipesDeleted;
    }

    public List<Comment> getPostedComments()
    {
        return postedComments;
    }

    public void setPostedComments(List<Comment> postedComments)
    {
        this.postedComments = postedComments;
    }

    public List<RecipeRating> getRecipeRatingsUserRated()
    {
        return recipeRatingsUserRated;
    }

    public void setRecipeRatingsUserRated(List<RecipeRating> recipeRatingsUserRated)
    {
        this.recipeRatingsUserRated = recipeRatingsUserRated;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}