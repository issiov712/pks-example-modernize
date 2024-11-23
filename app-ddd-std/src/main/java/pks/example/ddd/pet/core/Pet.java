package pks.example.ddd.pet.core;

import org.javamoney.moneta.Money;

import lombok.Data;

@Data
public class Pet {
    Long id;
    String name;
    Double age;
    Money value;
}
