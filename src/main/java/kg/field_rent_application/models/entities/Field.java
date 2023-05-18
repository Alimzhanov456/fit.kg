package kg.field_rent_application.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String landlordName;
    String landlordPhoneNumber;
    String landlordEmail;
    String fieldName;
    double pricePerHour;
    String address;
}
