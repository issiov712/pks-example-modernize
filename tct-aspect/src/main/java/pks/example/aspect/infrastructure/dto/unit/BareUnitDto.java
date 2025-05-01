package pks.example.aspect.infrastructure.dto.unit;

import lombok.Data;
import lombok.AllArgsConstructor;

import org.javamoney.moneta.Money;

@Data @AllArgsConstructor
public class BareUnitDto {
	private String name;
	private Money value;
}
