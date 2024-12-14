package pks.example.aspect.core.model.unit;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.javamoney.moneta.Money;

@Getter @SuperBuilder @ToString @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Unit extends AbstractUnit {
	@Builder.Default Money value = Money.of(0,"USD");
}
