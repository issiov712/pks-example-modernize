package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.javamoney.moneta.Money;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TestEntity {
    private String field;
	@Builder.Default private Money value = Money.of(0,"USD");
}
