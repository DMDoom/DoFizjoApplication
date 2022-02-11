package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/blog")
public class BlogController {

    private PostRepository postRepo;
    private BlockRepository blockRepo;

    public BlogController(PostRepository postRepo, BlockRepository blockRepo) {
        this.postRepo = postRepo;
        this.blockRepo = blockRepo;
    }

    @GetMapping
    public String getBlogPage(Model model) {
        return "redirect:/blog/" + postRepo.findLatestOne().getId();
    }

    @GetMapping("/{id}")
    public String getBlogPageByPostId(Model model, @PathVariable(value = "id") int id) {
        // Blocks
        model.addAttribute("kontakt", blockRepo.findById("kontakt"));
        model.addAttribute("lokalizacja", blockRepo.findById("lokalizacja"));

        // Post
        Post post = postRepo.findById(id);
        model.addAttribute("currentPost", post);
        model.addAttribute("olderPost", postRepo.findOlder(post.getCreatedAt()));
        model.addAttribute("newerPost", postRepo.findNewer(post.getCreatedAt()));

        return "blog";
    }
}
