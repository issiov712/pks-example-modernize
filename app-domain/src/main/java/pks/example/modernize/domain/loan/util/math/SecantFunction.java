package pks.example.modernize.domain.loan.util.math;

/**
 * Provides a {@link #calculate(Double)} method for function f(x) in which the secant method will be used to find a root.
 * 
 * @author Peter Shiner
 * @since 0.1
 */
public interface SecantFunction {
    /**
     * Calculate a value f(x) for the given value x in hopes of finding a root ( f(x) == 0 ).
     * 
     * @param x The next value to try.
     * @return The value calculated for f(x).
     */
    public Double calculate(Double x);
}
