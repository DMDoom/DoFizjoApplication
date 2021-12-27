package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Review {

    private Long id;

    @NotNull
    private String author;

    @NotNull
    private String discipline;

    @NotNull
    private String opinion;
}
