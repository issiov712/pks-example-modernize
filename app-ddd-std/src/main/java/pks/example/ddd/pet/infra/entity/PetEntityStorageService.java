package pks.example.ddd.pet.infra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pks.example.ddd.pet.core.Pet;
import pks.example.ddd.pet.infra.mapper.PetEntityMapper;
import pks.example.ddd.pet.ports.outbound.PetStorage;

@Service
public class PetEntityStorageService implements PetStorage {

    private static Logger log_msg = LoggerFactory.getLogger(PetEntityStorageService.class);

    @Autowired
    PetEntityRepository petEntityRepository;

    public void store(Pet pet) {

        Optional<PetEntity> ope;

        log_msg.info("entering store():  pet = '{}'",pet.toString());

        if (pet.getId() == null) {
            ope = Optional.of(PetEntityMapper.INSTANCE.petToPetEntity(pet));
        } else {
            ope = petEntityRepository.findById(pet.getId());
            if (ope.isPresent()) {
                PetEntityMapper.INSTANCE.updatePetEntityFromPet(pet, ope.get());
            } else {
                ope = Optional.of(PetEntityMapper.INSTANCE.petToPetEntity(pet));
            }
        }
        log_msg.info("after checking:  petEntity = '{}'",ope.get().toString());

        petEntityRepository.save(ope.get());
        log_msg.info("after save():  petEntity = '{}'",ope.get().toString());

        PetEntityMapper.INSTANCE.updatePetFromPetEntity(ope.get(), pet);     // what about storage attributes, timestamps, owners, versions, etc.
    }

    public Optional<Pet> retrieveById(Long id) {
        log_msg.info("entering retrieveById():  id = {}",id);
        return Optional.empty();
    }

    public List<Pet> retrieveByName(String name) {
        log_msg.info("entering retrieveByName():  name = '{}'",name);
        List<PetEntity> petEntities = petEntityRepository.findByName(name);
        List<Pet> pets = new ArrayList<Pet>();
        for (PetEntity pe : petEntities) {
            log_msg.info("converting petEntity = '{}'",pe.toString());
            Pet p = PetEntityMapper.INSTANCE.petEntitytoPet(pe);
            log_msg.info("returning pet = '{}'",p.toString());
            pets.add(p);
        }
        return pets;
    }
}