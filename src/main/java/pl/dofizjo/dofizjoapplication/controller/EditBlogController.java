package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dofizjo.dofizjoapplication.data.CommentRepository;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.model.Comment;
import pl.dofizjo.dofizjoapplication.model.Post;

@Controller
@Slf4j
@RequestMapping("/cms/blog")
public class EditBlogController {

    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public EditBlogController(PostRepository postRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping
    public String getEditBlogPage(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        model.addAttribute("post", new Post());

        model.addAttribute("comment", new Comment());
        model.addAttribute("commentQueue", commentRepo.findAllInQueue());

        return "editblog";
    }

    // Posts
    @PostMapping(value="/update", params="action=add")
    @CacheEvict(value="postCache", allEntries = true)
    public String addPost(@ModelAttribute("post") Post post) {
        postRepo.add(post);

        return "redirect:/cms/blog";
    }

    @PostMapping(value="/update", params="action=update")
    @CacheEvict(value="postCache", allEntries = true)
    public String updatePost(@ModelAttribute("post") Post post) {
        postRepo.overwrite(post);

        return "redirect:/cms/blog";
    }

    @PostMapping(value="/update", params="action=delete")
    @CacheEvict(value="postCache", allEntries = true)
    public String deletePost(@ModelAttribute("post") Post post) {
        postRepo.deleteById(post.getId());

        return "redirect:/cms/blog";
    }

    // Comment queue
    @PostMapping(value="/comment", params="action=accept")
    @CacheEvict(value="postCache", allEntries = true)
    public String acceptComment(@ModelAttribute("comment") Comment comment) {
        commentRepo.acceptComment(comment);

        return "redirect:/cms/blog";
    }

    @PostMapping(value="/comment", params="action=reject")
    @CacheEvict(value="postCache", allEntries = true)
    public String rejectComment(@ModelAttribute("comment") Comment comment) {
        commentRepo.deleteFromQueueById(comment.getId());

        return "redirect:/cms/blog";
    }



}
