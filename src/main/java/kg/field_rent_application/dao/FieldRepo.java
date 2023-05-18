package kg.field_rent_application.dao;

import kg.field_rent_application.models.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepo extends JpaRepository<Field, Long> {
}
