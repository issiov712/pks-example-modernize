package pks.example.aspect.core.model.unit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @SuperBuilder @ToString @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AbstractUnit {
	private String name;
}

