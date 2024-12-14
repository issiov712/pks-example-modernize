package pks.example.aspect.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import pks.example.aspect.core.model.unit.Unit;
import pks.example.aspect.infrastructure.dto.unit.BareUnitDto;

public class UnitDtoMapperTest {

	@Test
	void checkMapping() {
		BareUnitDto bu = new BareUnitDto("me",Money.of(10,"USD"));
		Unit du = UnitMapper.INSTANCE.maptoUnit(bu);
		assertEquals(bu.getName(), du.getName());
	}
}
