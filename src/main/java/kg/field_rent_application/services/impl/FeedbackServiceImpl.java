package kg.field_rent_application.services.impl;

import kg.field_rent_application.dao.FeedbackRepo;
import kg.field_rent_application.models.entities.Feedback;
import kg.field_rent_application.services.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepo feedbackRepo;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepo.save(feedback);
    }

    @Override
    public Feedback getById(Long id) {
        Optional<Feedback> optional = feedbackRepo.findById(id);
        Feedback feedback;
        if (optional.isPresent())
            feedback = optional.get();
        else
            throw new RuntimeException(
                    "Feedback not found for id : " + id);
        return feedback;
    }

    @Override
    public void deleteViaId(Long id) {
        feedbackRepo.deleteById(id);
    }
}
