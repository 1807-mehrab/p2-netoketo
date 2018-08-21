package com.revature.beans;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "IMAGES")
@JsonRootName(value = "image")
public class Image
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imageSeq")
    @SequenceGenerator(allocationSize = 1, name = "imageSeq", sequenceName = "PK_IMAGE_SEQ")
    private int imageId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPEID")
    private Recipe recipe;

    @Column
    private byte[] image;

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Image{" +
                "imageId=" + imageId +
                ", recipe=" + recipe +
                ", image=" + image +
                '}';
    }
}
