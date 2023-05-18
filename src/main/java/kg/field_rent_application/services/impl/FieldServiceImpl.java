package kg.field_rent_application.services.impl;

import kg.field_rent_application.dao.FieldRepo;
import kg.field_rent_application.models.entities.Field;
import kg.field_rent_application.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class FieldServiceImpl implements FieldService {
    private final FieldRepo fieldRepo;

    @Override
    public List<Field> getAllFields() {
        return fieldRepo.findAll();
    }

    @Override
    public void save(Field field) {
        fieldRepo.save(field);
    }

    @Override
    public Field getById(Long id) {
        Optional<Field> optional = fieldRepo.findById(id);
        Field field;
        if (optional.isPresent())
            field = optional.get();
        else
            throw new RuntimeException(
                    "Field not found for id : " + id);
        return field;
    }

    @Override
    public void deleteViaId(Long id) {
        fieldRepo.deleteById(id);
    }
}
