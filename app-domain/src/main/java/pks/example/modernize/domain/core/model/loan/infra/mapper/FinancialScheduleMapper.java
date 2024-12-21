package pks.example.modernize.domain.core.model.loan.infra.mapper;

import org.mapstruct.Javadoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import pks.example.modernize.domain.core.model.loan.core.FinancialSchedule;
import pks.example.modernize.domain.core.model.loan.infra.entity.FinancialScheduleEntity;


/**
 * The interface that defines the MapStruct implementation of a class to map {@link pks.example.ddd.pet.core.Pet} to/from {@link pks.example.ddd.pet.infra.entity.PetEntity}
 * 
 * @author Peter Shiner
 * @since 0.1
 */
@Mapper(uses = FinancialUnitMapper.class)
@Javadoc(
    """
    {@link pks.example.ddd.pet.core.Pet} to/from {@link pks.example.ddd.pet.infra.entity.PetEntity}

    @author Peter Shiner
    @since 0.1
    """
)
public interface FinancialScheduleMapper {

    public static FinancialScheduleMapper INSTANCE = Mappers.getMapper(FinancialScheduleMapper.class);
    
    /**
     * Converts an existing {@link pks.example.ddd.pet.core.Pet} to new instance of {@link pks.example.ddd.pet.infra.entity.PetEntity}
     * 
     * @param pet
     * @return
     * 
     * deprecated Use {@link pks.example.FinancialScheduleEntityMapper.pet.infra.mapper.PetEntityMapper#updatePetEntityFromPet(Pet, PetEntity)} instead as you should always look for the entity before creating a new one.
     */
    // @Deprecated
    FinancialScheduleEntity FinancialScheduleToFinancialScheduleEntity(FinancialSchedule FinancialSchedule);

    /**
     * Creates a new {@link pks.example.ddd.pet.core.Pet} from the corresponding entity.
     * 
     * @param petEntity
     * @return
     */
    FinancialSchedule FinancialScheduleEntitytoFinancialSchedule(FinancialScheduleEntity FinancialScheduleEntity);

    void updateFinancialScheduleFromFinancialScheduleEntity(FinancialScheduleEntity FinancialScheduleEntity, @MappingTarget FinancialSchedule FinancialSchedule);
    void updateFinancialScheduleEntityFromFinancialSchedule(FinancialSchedule FinancialSchedule, @MappingTarget FinancialScheduleEntity FinancialScheduleEntity);

    // /**
    //  * <p>Simple coversion between equivilent types not covered by MapStruct by default.</p>
    //  * 
    //  * <p>Assumption is that money is always in "USD."</p>
    //  * 
    //  * <p>Note that null values are silently converted to zero ('0').</p>
    //  * 
    //  * @param money The money amount as a Money type.
    //  * @return The amount of money in a database friendly BigDecimal type.
    //  */
    // default BigDecimal map(Money money) { return money == null ? Money.of(Double.valueOf(0.00), "USD").getNumberStripped() : money.getNumberStripped(); }

    // /**
    //  * <p>Simple coversion between equivilent types not covered by MapStruct by default.</p>
    //  * 
    //  * <p>Assumption is that money is always in "USD."</p>
    //  * 
    //  * <p>Note that null values are silently converted to zero ('0').</p>
    //  * 
    //  * @param bigDecimal The amount of money in a database friendly BigDecimal type.
    //  * @return The money amount as a Money type.
    //  */
    // default Money map(BigDecimal bigDecimal) { return bigDecimal == null ? Money.of(0.00,"USD") : Money.of(bigDecimal, "USD"); }
}
