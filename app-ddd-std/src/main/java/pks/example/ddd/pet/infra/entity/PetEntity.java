package pks.example.ddd.pet.infra.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter@Setter @ToString @NoArgsConstructor //(access = AccessLevel.PROTECTED)
@Table(name = "PET")
public class PetEntity {

    @Id @GeneratedValue 
    @Column(name = "PKID")
    private Long id;

    @Column(name = "C_NAME")
    private String name;

    @Column(name = "DF_AGE")
    private Double age;

    @Column( name = "BD_VALUE")
    private BigDecimal value;
}
