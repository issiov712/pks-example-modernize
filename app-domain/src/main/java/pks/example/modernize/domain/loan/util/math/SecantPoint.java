package pks.example.modernize.domain.loan.util.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * <p>A point, ({@link x}, {@link fx}), calculated during the solving of a formula root.</p>
 * 
 * <p>This class is designed to become a record type.</p>
 * 
 * @author Peter Shiner
 * @since 0.1
 */
@Accessors(fluent = true) // , makeFinal = true) // make this act like a record type
@Getter @AllArgsConstructor 
public class SecantPoint {
    private Double x, fx;
}
