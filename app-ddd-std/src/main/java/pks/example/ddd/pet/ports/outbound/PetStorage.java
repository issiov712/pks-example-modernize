package pks.example.ddd.pet.ports.outbound;

import java.util.List;
import java.util.Optional;

import pks.example.ddd.pet.core.Pet;

public interface PetStorage {
    public void store(Pet pet);
    public Optional<Pet> retrieveById(Long id);
    public List<Pet> retrieveByName(String name);
}
