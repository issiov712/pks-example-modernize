package pks.example.modernize.domain.core.model.entry;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) @SuperBuilder
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTimeLine extends AbstractTimeLine {

}
