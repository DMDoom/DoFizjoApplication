package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public String getOfficeTherapyPage() {
        return "officetherapy";
    }
}