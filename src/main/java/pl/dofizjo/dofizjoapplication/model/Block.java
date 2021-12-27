package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// Block of text, composed of h1 title and p content
public class Block {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
