package com.revature.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "login")
public class Login
{

    private int userId;

    private String username;

    private String password;

    private String email;

    private int userType;

    private List<Recipe> recipesCreated;

    private List<Recipe> recipesDeleted;

    private List<Comment> postedComments;

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
