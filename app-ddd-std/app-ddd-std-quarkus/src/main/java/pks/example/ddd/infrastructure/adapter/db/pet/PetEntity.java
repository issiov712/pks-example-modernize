package pks.example.ddd.infrastructure.adapter.db.pet;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import java.sql.Date;

import org.javamoney.moneta.Money;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;  

@Entity
@Cacheable
public class PetEntity extends PanacheEntity {

    @Column(name = "PKID")
    public Long id = null;

    @Column(name = "C_NAME")
    public String name = null;

    @Column(name = "DF_AGE")
    public Double age;

    @Column(name = "BD_VALUE", scale = 2, precision = 22)
    public Money value;

    @Column(name = "D_BIRTHDAY")
    public Date birthday;
}
