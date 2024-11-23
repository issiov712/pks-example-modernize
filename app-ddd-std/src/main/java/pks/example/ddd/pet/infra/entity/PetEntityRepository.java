package pks.example.ddd.pet.infra.entity;

import java.util.Optional;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import pks.example.ddd.pet.core.Pet;
import pks.example.ddd.pet.infra.mapper.PetEntityMapper;
import pks.example.ddd.pet.ports.outbound.PetStorage;

import java.util.ArrayList;
import java.util.List;

public interface PetEntityRepository extends Repository<PetEntity, Long>, PetStorage {
    
    PetEntity save(PetEntity petEntity);

    default public void store(Pet pet) {
        // TODO: Need to lookup the Pet first in case it already exits....  id != null || findByNatualKey() ??
        PetEntity petEntity = PetEntityMapper.INSTANCE.petToPetEntity(pet);
        this.save(petEntity);
    }

    Optional<PetEntity> findById(Long id);

    default public Optional<Pet> retreiveById(Long id) {
        return null;
    }

    List<PetEntity> findByName(String name);

    default public List<Pet> retrieveByName(String name) {
        return new ArrayList<Pet>();
    }
