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
    public String getBlogPage() {
        return "redirect:/blog/" + postRepo.findLatestOne().getId();
    }

    @GetMapping("/{id}")
    public String getBlogPageByPostId(Model model, @PathVariable(value = "id") int id) {

        Post post = postRepo.findById(id);
        model.addAttribute("currentPost", post);
        model.addAttribute("olderPost", postRepo.findOlder(post.getCreatedAt()));
        model.addAttribute("newerPost", postRepo.findNewer(post.getCreatedAt()));

        return "blog";
    }
}
