package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.data.PartnerRepository;
import pl.dofizjo.dofizjoapplication.data.PostRepository;

@Slf4j
@Controller
@RequestMapping("/cms")
public class CmsController {

    private PostRepository postRepo;
    private PartnerRepository partnerRepo;
    private BlockRepository blockRepo;

    public CmsController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public String getCmsPage(Model model) {
        return "cms";
    }
}
