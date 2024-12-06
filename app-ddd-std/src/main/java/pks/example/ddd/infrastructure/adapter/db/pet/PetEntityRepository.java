package pks.example.ddd.infrastructure.adapter.db.pet;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.lang.NonNull;

public interface PetEntityRepository extends JpaRepository<PetEntity, Long> {
    
    // @NonNull public PetEntity save(@NonNull PetEntity petEntity);

    // @NonNull public Optional<PetEntity> findById(@NonNull Long id);

    List<PetEntity> findByName(String name);
}