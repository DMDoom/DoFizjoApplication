package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public HomeController(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo) {
        this.postRepo = postRepo;
        this.partnerRepo = partnerRepo;
        this.reviewRepo = reviewRepo;
    }

    @ModelAttribute
    public void loadData(Model model) {
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
