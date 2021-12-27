package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// Blog post, composed of author, title, content and post date
public class Post {

    int id;

    @NotNull
    @Size(min = 1, max = 50, message = "Author must be between 1 and 50 characters long")
    private String author;

    @NotNull
    @Size(min = 1, max = 50, message = "Author must be between 1 and 50 characters long")
    private String title;

    @NotNull
    private String content;

    private Date createdAt;

    // Lombok is idiotic
    public Post(int id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
