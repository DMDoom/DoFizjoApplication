package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.util.List;

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
    // Initial view, by default display latest post
    public String getBlogPage(Model model) {
        model.addAttribute("currentPost", postRepo.findLatestOne());

        return "blog";
    }

    @GetMapping("/{id}")
    public String getBlogPageByPostId(Model model, @PathVariable(value = "id") int id) {
        List<Post> posts = postRepo.findAll();

        if (posts.size() >= id && id >= 1) {
            model.addAttribute("currentPost", postRepo.findById(id));
        } else if (id > posts.size()) {
            return "redirect:/blog/" + (postRepo.findLatestOne().getId());
        } else if (id < 1) {
            return "redirect:/blog/" + 1;
        }

        return "blog";
    }
}
