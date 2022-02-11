package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.*;
import pl.dofizjo.dofizjoapplication.model.Method;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private PostRepository postRepo;
    private PartnerRepository partnerRepo;
    private ReviewRepository reviewRepo;
    private BlockRepository blockRepo;
    private MethodRepository methodRepo;

    public HomeController(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo) {
        this.postRepo = postRepo;
        this.partnerRepo = partnerRepo;
        this.reviewRepo = reviewRepo;
        this.blockRepo = blockRepo;
        this.methodRepo = methodRepo;
    }

    @ModelAttribute
    public void loadData(Model model) {
        // Blocks
        model.addAttribute("zapraszamy", blockRepo.findById("zapraszamy"));
        model.addAttribute("metody", blockRepo.findById("metody"));
        model.addAttribute("mateusz", blockRepo.findById("mateusz"));
        model.addAttribute("karol", blockRepo.findById("karol"));
        model.addAttribute("rafal", blockRepo.findById("rafal"));
        model.addAttribute("oferta", blockRepo.findById("oferta"));
        model.addAttribute("kontakt", blockRepo.findById("kontakt"));
        model.addAttribute("lokalizacja", blockRepo.findById("lokalizacja"));

        // Partners
        model.addAttribute("partners", partnerRepo.findAll());

        // Reviews
        model.addAttribute("reviews", reviewRepo.findAll());

        // Methods
        List<Method> methods = methodRepo.findAll();
        model.addAttribute("methodsLeft", new ArrayList<>(methods.subList(0, 3)));
        model.addAttribute("methodsRight", new ArrayList<>(methods.subList(3, methods.size())));
    }

    @GetMapping
    public String getHomePage(Model model) {
        return "home";
    }
}
