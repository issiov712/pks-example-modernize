package pks.example.modernize.domain.loan.util.math;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.NoArgsConstructor;
import pks.example.modernize.domain.loan.util.math.SecantFunction;
import pks.example.modernize.domain.loan.util.math.SecantPoint;
import pks.example.modernize.domain.loan.util.math.SecantSolver;


public class SecantBasicTest {
    Logger log_tst = LoggerFactory.getLogger(SecantBasicTest.class);

    interface TestSecantFunction extends SecantFunction {
        public Double useEpsilon();
        public Double solutionReference();
    }

    /**
     * 
     */
    @NoArgsConstructor
    class TestSecantSolver extends SecantSolver {
        SecantFunction function;

        public void testSolver(TestSecantFunction function, Double ax, Double bx) {

            setEpsilon(function.useEpsilon());
            SecantPoint solution = solve(function,ax,bx);
            SecantPoint points[] = getSecantPoints();

            log_tst.debug("solving for TestSecantFunction class '{}'", function.getClass().getName());
            
            for (SecantPoint p : points) {
                log_tst.debug("\tx: {}\tfx: {}",String.format("%12.9f",p.x()),String.format("%12.9f",p.fx()));
            }

            log_tst.info("solution:  x = '{}', f(x) = '{}' for TestSecantFunction class '{}'",String.format("%12.9f",solution.x()),String.format("%12.9f",solution.fx()),function.getClass().getName());

            assertFalse((function.solutionReference() - solution.x()) > function.useEpsilon());
            assertFalse(points[points.length-1].fx().doubleValue() > function.useEpsilon());
        }

        public void testSolver(TestSecantFunction function) {
            testSolver(function,-1.0d,3.0d);
        }
    }

    @Test
    void TestMySimpleSecantFunction() {

        class MySimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return Math.pow(x,3) - 5 * x.doubleValue() + 1; }
            public Double useEpsilon()        { return 0.00001d; }
            public Double solutionReference() { return 0.201639676d; }
        }
        
        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MySimpleSecantFunction());
        assertTrue(solver.isSolved());
    }

    @Test
    void TestMyNextSimpleSecantFunction() {

        class MyNextSimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return Math.pow(2,x) - 5 * x.doubleValue() + 2; }
            public Double useEpsilon()        { return 0.00001d; }
            public Double solutionReference() { return 0.732244255d; }
        }
    
        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MyNextSimpleSecantFunction(),4.0d,8.0d);
        assertTrue(solver.isSolved());
    }

    @Test
    void TestMyThirdSimpleSecantFunction() {

        class MyThirdSimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return (Math.pow(x,5) + 3) / 5; }
            public Double useEpsilon()        { return 0.00001d; }
            public Double solutionReference() { return -1.24573094d; }
        }

        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MyThirdSimpleSecantFunction());
        assertTrue(solver.isSolved());
    }
}
