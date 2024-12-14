package pks.example.aspect.infrastructure.mapper;

import org.mapstruct.Javadoc;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import pks.example.aspect.core.model.unit.Unit;
import pks.example.aspect.infrastructure.dto.unit.BareUnitDto;

@Mapper
public interface UnitMapper {
	public static UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

	BareUnitDto maptoBareUnit(Unit unit);
	Unit maptoUnit(BareUnitDto unitDto);
}
