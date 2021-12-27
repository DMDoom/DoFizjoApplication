package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.PostRepository;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private PostRepository postRepo;

    public HomeController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public String getHomePage(Model model) {
        return "home";
    }

}
