package pks.example.ddd.core.model.pet;

import java.sql.Date;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class PetTest {

    @Test
    void createPet() {
        Pet p = Pet.builder()
                .name("Sabi")
                .age(Double.valueOf(11))
                .birthday(new Date(System.currentTimeMillis()))
                .value(Money.of(101,"USD"))
                .build();
        System.out.println(p.getName());
    }

}
