package pks.example.ddd.infrastructure.adapter.db.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pks.example.ddd.core.model.pet.Pet;
import pks.example.ddd.infrastructure.adapter.db.map.PetEntityMapper;
import pks.example.ddd.infrastructure.adapter.db.pet.PetEntity;
import pks.example.ddd.infrastructure.adapter.db.pet.PetEntityTest;

public class PetMappingTest {

    Logger log_tst = LoggerFactory.getLogger(PetEntityTest.class);

    @Test
    public void shouldMapPetDomainObject() {
        PetEntity e = new PetEntity();
        e.setAge(Double.valueOf(10d));
        e.setName("Sam");
        e.setId(Long.valueOf(7l));
        e.setValue(BigDecimal.valueOf(125.45d));

        Pet p = PetEntityMapper.INSTANCE.petEntitytoPet(e);

        assertNotNull(p);
        assertEquals(p.getAge(), e.getAge());
        assertEquals(p.getId(), e.getId());
        assertEquals(p.getName(), e.getName());

        e = PetEntityMapper.INSTANCE.petToPetEntity(p);

        assertNotNull(p);
        assertEquals(p.getAge(), e.getAge());
        assertEquals(p.getId(), e.getId());
        assertEquals(p.getName(), e.getName());

        log_tst.info("pet.name: '{}', value: '{}'", p.getName(),p.getValue().toString());
        log_tst.info("test complete");
    }

}
