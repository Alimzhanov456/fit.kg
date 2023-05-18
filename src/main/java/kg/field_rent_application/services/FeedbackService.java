package kg.field_rent_application.services;

import kg.field_rent_application.models.entities.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    void save(Feedback feedback);
    Feedback getById(Long id);
    void deleteViaId(Long id);
}
