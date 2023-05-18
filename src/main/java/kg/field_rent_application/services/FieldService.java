package kg.field_rent_application.services;

import kg.field_rent_application.models.entities.Field;

import java.util.List;

public interface FieldService {
    List<Field> getAllFields();
    void save(Field field);
    Field getById(Long id);
    void deleteViaId(Long id);
}
