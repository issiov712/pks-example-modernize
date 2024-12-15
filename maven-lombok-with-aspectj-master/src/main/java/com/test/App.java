package com.test;

import com.test.dto.TestDto;
import com.test.entity.TestEntity;
import com.test.mapper.TestMapper;

import org.javamoney.moneta.Money;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TestEntity testEntity1 = new TestEntity("initialValue1",Money.of(10,"USD"));
        TestEntity testEntity2 = new TestEntity("initialValue2",Money.of(11,"USD"));
        TestEntity testEntity3 = new TestEntity("initialValue3",Money.of(12,"USD"));

        testEntity1.setField("something");
        System.out.println("value of entity1 field: " + testEntity1.getField());

        testEntity2.setField(null);
        System.out.println("value of entity2 field: " + testEntity2.getField());

        testEntity3.setField("");
        System.out.println("value of entity3 field: " + testEntity3.getField());

		TestDto testDto;
		testDto = TestMapper.INSTANCE.maptoDto(testEntity1);
		System.out.println(testDto.toString());

		testDto = TestMapper.INSTANCE.maptoDto(testEntity2);
		System.out.println(testDto.toString());

		testDto = TestMapper.INSTANCE.maptoDto(testEntity3);
		System.out.println(testDto.toString());

	}
}
