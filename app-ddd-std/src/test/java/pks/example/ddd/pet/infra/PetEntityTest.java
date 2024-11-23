package pks.example.ddd.pet.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pks.example.ddd.pet.core.Pet;
import pks.example.ddd.pet.infra.entity.PetEntity;
import pks.example.ddd.pet.infra.mapper.PetEntityMapper;
import pks.example.ddd.pet.ports.outbound.PetStorage;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PetEntityTest {

    private static Logger log_tst = LoggerFactory.getLogger(PetMappingTest.class);

    // @Configuration
    // static class ContextConfiguration {

    //     // @Bean
    //     // public TestPetStorageService testPetStorageService() {
    //     //     TestPetStorageService testPetStorageService = new PetEntityRepository();
    //     //     return testPetStorageService;
    //     //     };
    //     // }
    // }


    @Autowired
    PetStorage petStorage;

    // @SuppressWarnings("deprecation")
    @Test
    public void validatingSpringJpaRepository() {

        String[] PET_NAMES = { "Sam", "George", "Tom" };

        PetEntity e = new PetEntity();
        e.setAge(Double.valueOf(10d));
        e.setName(PET_NAMES[0]);
        e.setId(Long.valueOf(7l));
        e.setValue(BigDecimal.valueOf(125.45d));

        Pet p = PetEntityMapper.INSTANCE.petEntitytoPet(e);

        assertNotNull(p);
        assertEquals(p.getAge(), e.getAge());
        assertEquals(p.getId(), e.getId());
        assertEquals(p.getName(), e.getName());

        
        e = PetEntityMapper.INSTANCE.petToPetEntity(p); // DEPRECATION

        assertNotNull(p);
        assertEquals(p.getAge(), e.getAge());
        assertEquals(p.getId(), e.getId());
        assertEquals(p.getName(), e.getName());

        log_tst.info("pet.name: '{}', value: '{}'", p.getName(),p.getValue().toString());

        assertEquals(PET_NAMES[0], p.getName());

        p.setId(null);
        petStorage.store(p);

        for (String name : PET_NAMES) {
            p.setName(name);
            petStorage.store(p);
            List<Pet> pets = petStorage.retrieveByName(name);
            for (Pet px : pets) {
                assertEquals(name, px.getName());
            }
        }

        log_tst.info("test complete");
    }

}
