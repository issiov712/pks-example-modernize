package com.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.test.dto.TestDto;
import com.test.entity.TestEntity;

@Mapper
public interface TestMapper {
	public static TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

	TestDto maptoDto(TestEntity entity);
	TestEntity maptoEntity(TestDto dto);
}

