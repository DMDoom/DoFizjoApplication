package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.PostRepository;

@Slf4j
@Controller
@RequestMapping("/blog")
public class BlogController {

    private PostRepository postRepo;

    @Autowired
    public BlogController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public String getBlogPage(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "blog";
    }
}
