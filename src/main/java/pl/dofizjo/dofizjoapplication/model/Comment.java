package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private int id;
    private int postId;
    private String author;
    private String content;
    private Date createdAt;

    public Comment (int postId, String author, String content, Date createdAt) {
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }
}
