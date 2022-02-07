package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.model.Post;

@Controller
@Slf4j
@RequestMapping("/cms/blog")
public class EditBlogController {

    private PostRepository postRepo;

    public EditBlogController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public String getEditBlogPage(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        model.addAttribute("post", new Post());

        return "editblog";
    }

    @PostMapping(value="/update", params="action=add")
    public String addPost(@ModelAttribute("post") Post post) {
        postRepo.add(post);

        return "redirect:/cms/blog";
    }

    @PostMapping(value="/update", params="action=update")
    public String updatePost(@ModelAttribute("post") Post post) {
        postRepo.overwrite(post);

        return "redirect:/cms/blog";
    }

    @PostMapping(value="/update", params="action=delete")
    public String deletePost(@ModelAttribute("post") Post post) {
        postRepo.deleteById(post.getId());

        return "redirect:/cms/blog";
    }

}
