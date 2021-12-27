package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// Partner, composed of img src, h2 name, and p description
public class Partner {

    private int id;

    @NotNull
    private String img;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
