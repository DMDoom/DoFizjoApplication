package pl.dofizjo.dofizjoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;

@Controller
@RequestMapping("/wiecej")
public class AboutController {

    @Autowired
    private BlockRepository blockRepo;

    @GetMapping
    public String getAboutPage(Model model) {
        model.addAttribute("kontakt", blockRepo.findById("kontakt"));
        model.addAttribute("lokalizacja", blockRepo.findById("lokalizacja"));

        model.addAttribute("mateusz", blockRepo.findById("mateusz"));
        model.addAttribute("karol", blockRepo.findById("karol"));
        model.addAttribute("rafal", blockRepo.findById("rafal"));
        return "about";
    }

}
