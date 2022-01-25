package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.data.PartnerRepository;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.data.ReviewRepository;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private PostRepository postRepo;
    private PartnerRepository partnerRepo;
    private ReviewRepository reviewRepo;
    private BlockRepository blockRepo;

    public HomeController(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo) {
        this.postRepo = postRepo;
        this.partnerRepo = partnerRepo;
        this.reviewRepo = reviewRepo;
        this.blockRepo = blockRepo;
    }

    @ModelAttribute
    public void loadData(Model model) {
        // Blocks
        model.addAttribute("lokalizacja", blockRepo.findById("lokalizacja"));
        model.addAttribute("zapraszamy", blockRepo.findById("zapraszamy"));
        model.addAttribute("metody", blockRepo.findById("metody"));
        model.addAttribute("mateusz", blockRepo.findById("mateusz"));
        model.addAttribute("karol", blockRepo.findById("karol"));
        model.addAttribute("rafal", blockRepo.findById("rafal"));
        model.addAttribute("oferta", blockRepo.findById("oferta"));
        model.addAttribute("kontakt", blockRepo.findById("kontakt"));

        // Partners
        model.addAttribute("partners", partnerRepo.findAll());

        // Reviews
        model.addAttribute("reviews", reviewRepo.findAll());
    }

    @GetMapping
    public String getHomePage(Model model) {
        return "home";
    }
}
