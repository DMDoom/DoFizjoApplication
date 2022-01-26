package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;

@Controller
@Slf4j
@RequestMapping("/cms/edit")
public class EditController {

    private BlockRepository blockRepo;

    public EditController (BlockRepository blockRepo) {
        this.blockRepo = blockRepo;
    }

    @GetMapping
    public String getEditPage(Model model) {
        return "edit";
    }

}
