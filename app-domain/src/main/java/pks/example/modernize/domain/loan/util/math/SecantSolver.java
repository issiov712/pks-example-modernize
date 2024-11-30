package pks.example.modernize.domain.loan.util.math;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * Solving {@link SecantFunction}s using the secant method.
 * 
 * @author Peter Shiner
 * @since 0.1
 */
public class SecantSolver {

    Logger log_msg = LoggerFactory.getLogger(SecantSolver.class);

    /**
     * The default epsilon value in stopping the iterations.
     */
    private static Double EPSILON = 0.00001;

    /**
     * The actual epslion values used in stopping the iterations.
     */
    @Getter @Setter private Double epsilon = EPSILON;

    /**
     * A flag to indicate the finding of successful solution within tolerance {@link epsilon}.
     */
    @Getter private Boolean solved;

    /**
     * <p>A list of the points found during the solution iteration.</p>
     * 
     * <p>These are useful for debugging.</p>
     */
    private List<SecantPoint> points;

    /**
     * <p>The secant solution finding method.</p>
     * 
     * <p>This iterates through {@link SecantFunction#calculate(Double)} calls as it home in
     * on the solution using the secant method.</p>
     * 
     * @param function Actually the class that implements {@link SecantFunction} and provides the {@link SecantFunction#calculate(Double)}.
     * @param ax The first guess value <i><b>x<sub>1</sub></b></i> for use initializing the secant method.
     * @param bx The second guess value <i><b>x<sub>2</sub></b></i> for use initializing the secant method.
     * @return The calculated {@link SecantPoint} which is the solution to a root of the equation.
     */
    public SecantPoint solve(SecantFunction function, Double ax, Double bx) {
        points = new ArrayList<SecantPoint>();
        solved = false;
        
        SecantPoint a = new SecantPoint(ax, function.calculate(ax));
        SecantPoint b = new SecantPoint(bx, function.calculate(bx));
        points.add(a);
        points.add(b);

        while (Math.abs(b.fx()) > epsilon || Math.abs(b.x() - a.x()) > epsilon) {
            try {
                Double cx = b.x() - b.fx() * ((a.x() - b.x()) / (a.fx() - b.fx()));
                a = b;
                b = new SecantPoint(cx,function.calculate(cx));
                points.add(b);
            } catch (RuntimeException ex) {
                log_msg.warn(ex.getMessage());
                solved = false;
            }
        }

        solved = true;
        return b;
    }

    /**
     * <p>The secant solution finding method.</p>
     * 
     * <p>This call utilizes initial guess values of <i><b>x<sub>1</sub> = 1.0d</b></i> and <i><b>x<sub>2</sub> = 2.0d</b></i>.</p>
     * 
     * @param function Actually the class that implements {@link SecantFunction} and provides the {@link SecantFunction#calculate(Double)}.
     * @return The calculated {@link SecantPoint} which is the solution to a root of the equation.
     */
    public SecantPoint solve(SecantFunction function) {
        return this.solve(function,1.0d, 2.0d);
    }

    /**
     * The array of values encountered during the secant method solution via the {@link SecantFunction#calculate(Double)} method.
     *
     * @return The list of {@link SecantPoint}s encountered during solution iterations of the secant method.
     */
    public SecantPoint[] getSecantPoints() { return points.toArray(new SecantPoint[0]); }
}