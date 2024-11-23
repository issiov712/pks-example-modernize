package pks.example.ddd.pet.infra.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter@Setter @NoArgsConstructor //(access = AccessLevel.PROTECTED)
public class PetEntity {
    @Id @GeneratedValue private Long id;
    private String name;
    private Double age;
    private BigDecimal value;
}
