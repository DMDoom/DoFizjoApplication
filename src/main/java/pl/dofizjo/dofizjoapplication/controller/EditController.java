package pl.dofizjo.dofizjoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.data.MethodRepository;
import pl.dofizjo.dofizjoapplication.data.PartnerRepository;
import pl.dofizjo.dofizjoapplication.data.ReviewRepository;
import pl.dofizjo.dofizjoapplication.model.Block;
import pl.dofizjo.dofizjoapplication.model.Method;
import pl.dofizjo.dofizjoapplication.model.Partner;
import pl.dofizjo.dofizjoapplication.model.Review;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cms/edit")
public class EditController {

    private BlockRepository blockRepo;
    private MethodRepository methodRepo;
    private PartnerRepository partnerRepo;
    private ReviewRepository reviewRepo;

    @Autowired
    public EditController(BlockRepository blockRepo, MethodRepository methodRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo) {
        this.blockRepo = blockRepo;
        this.methodRepo = methodRepo;
        this.partnerRepo = partnerRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping
    public String getEditPage(Model model) {
        // Send data
        model.addAttribute("blocks", blockRepo.findAll());
        model.addAttribute("methods", methodRepo.findAll());
        model.addAttribute("partners", partnerRepo.findAll());
        model.addAttribute("reviews", reviewRepo.findAll());

        // Receive data
        model.addAttribute("block", new Block());
        model.addAttribute("method", new Method());
        model.addAttribute("partner", new Partner());
        model.addAttribute("review", new Review());

        return "editcontent";
    }

    // Blocks
    @PostMapping("/block")
    public String updateBlock(@ModelAttribute("block") Block block) {
        blockRepo.overwrite(block);
        return "redirect:/cms/edit";
    }


    // Methods
    @PostMapping(value="/method", params="action=update")
    public String updateMethod(@ModelAttribute("method") Method method) {
        methodRepo.overwrite(method);
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/method", params="action=delete")
    public String deleteMethod(@ModelAttribute("method") Method method) {
        methodRepo.deleteById(method.getId());
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/method", params="action=add")
    public String addMethod(@ModelAttribute("method") Method method) {
        methodRepo.add(method);
        return "redirect:/cms/edit";
    }


    // Partners
    @PostMapping(value="/partner", params="action=update")
    public String updatePartner(@ModelAttribute("partner") Partner partner) {
        partnerRepo.overwrite(partner);
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/partner", params="action=delete")
    public String deletePartner(@ModelAttribute("partner") Partner partner) {
        partnerRepo.deleteById(partner.getId());
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/partner", params="action=add")
    public String addPartner(@ModelAttribute("partner") Partner partner) {
        partnerRepo.add(partner);
        return "redirect:/cms/edit";
    }


    // Reviews
    @PostMapping(value="/review", params="action=update")
    public String updateReview(@ModelAttribute("review") Review review) {
        reviewRepo.overwrite(review);
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/review", params="action=delete")
    public String deleteReview(@ModelAttribute("review") Review review) {
        reviewRepo.deleteById(review.getId());
        return "redirect:/cms/edit";
    }

    @PostMapping(value="/review", params="action=add")
    public String addReview(@ModelAttribute("review") Review review) {
        reviewRepo.add(review);
        return "redirect:/cms/edit";
    }
}
