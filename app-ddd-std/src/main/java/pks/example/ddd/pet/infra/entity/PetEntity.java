package pks.example.ddd.pet.infra.entity;

import java.math.BigDecimal;
import java.sql.Date;

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
 
/**
 * 
 * @author Peter Shiner
 * @since 0.1
 */
 /*
  * one idea for a domain object is to just use entities with protected access no argument constructors
  */
@Entity @Getter@Setter @ToString @NoArgsConstructor // (access = AccessLevel.PROTECTED)
@Table(name = "PET")
public class PetEntity {

    @Id @GeneratedValue 
    @Column(name = "PKID")
    private Long id;

    @Column(name = "C_NAME")
    private String name;

    @Column(name = "DF_AGE")
    private Double age;

    @Column(name = "BD_VALUE", scale = 2, precision = 22)
    private BigDecimal value;

    @Column(name = "D_BIRTHDAY")
    private Date birthday;
}
