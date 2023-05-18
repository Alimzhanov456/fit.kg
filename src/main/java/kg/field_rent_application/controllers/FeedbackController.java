package kg.field_rent_application.controllers;

import kg.field_rent_application.models.entities.Feedback;
import kg.field_rent_application.services.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/add/new_feedback")
    public String addNewFeedback(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "newfeedback";
    }

    @PostMapping("/save/feedback")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.save(feedback);
        return "redirect:/";
    }
}
