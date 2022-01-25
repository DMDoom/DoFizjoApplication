package pl.dofizjo.dofizjoapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Method {

    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
