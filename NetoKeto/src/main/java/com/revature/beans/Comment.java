package com.revature.beans;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENTS")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSeq")
    @SequenceGenerator(allocationSize = 1, name = "commentSeq", sequenceName = "PK_COMMENT_SEQ")
    @Column
    private int commentId;

    @Column
    private String content;

    @Column
    private boolean flagged;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RECIPEID")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNERID")
    private User owner;

    @Column
    private LocalDateTime createdOn;

    public int getCommentId()
    {
        return commentId;
    }

    public void setCommentId(int commentId)
    {
        this.commentId = commentId;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public boolean isFlagged()
    {
        return flagged;
    }

    public void setFlagged(boolean flagged)
    {
        this.flagged = flagged;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public LocalDateTime getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn)
    {
        this.createdOn = createdOn;
    }

    @Override
    public String toString()
    {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", flagged=" + flagged +
                ", recipe=" + recipe +
                ", owner=" + owner +
                ", createdOn=" + createdOn +
                '}';
    }
}
