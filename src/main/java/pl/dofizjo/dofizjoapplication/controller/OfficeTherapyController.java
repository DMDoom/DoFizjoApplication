package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;

@Controller
@Slf4j
@RequestMapping("/office")
public class OfficeTherapyController {

    private BlockRepository blockRepo;

    public OfficeTherapyController(BlockRepository blockRepo) {
        this.blockRepo = blockRepo;
    }

    @GetMapping
    public String getOfficeTherapyPage(Model model) {
        // Blocks
        model.addAttribute("kontakt", blockRepo.findById("kontakt"));
        model.addAttribute("lokalizacja", blockRepo.findById("lokalizacja"));
        model.addAttribute("dlafirm1", blockRepo.findById("dlafirm1"));
        model.addAttribute("dlafirm2", blockRepo.findById("dlafirm2"));
        model.addAttribute("dlafirm3", blockRepo.findById("dlafirm3"));
        model.addAttribute("dlafirm4", blockRepo.findById("dlafirm4"));
        model.addAttribute("dlafirm5", blockRepo.findById("dlafirm5"));

        return "officetherapy";
    }
}
