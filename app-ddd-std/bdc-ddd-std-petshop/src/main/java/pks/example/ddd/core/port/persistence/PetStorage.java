package pks.example.ddd.core.port.persistence;

import java.util.List;
import java.util.Optional;

import pks.example.ddd.core.model.pet.Pet;

public interface PetStorage {
    public void store(Pet pet);
    public Optional<Pet> retrieveById(Long id);
    public List<Pet> retrieveByName(String name);
}
