package pks.example.modernize.domain.entry.model;

import org.javamoney.moneta.Money;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true) @SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class EntryItem extends AbstractTimeLineEntryItem {
	private Money amount;
	private String name;

}
