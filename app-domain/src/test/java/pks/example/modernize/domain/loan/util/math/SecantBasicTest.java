package pks.example.modernize.domain.loan.util.math;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.NoArgsConstructor;


public class SecantBasicTest {
    Logger tst_log = LoggerFactory.getLogger(SecantBasicTest.class);

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

        public void testSolver(TestSecantFunction function) {

            setEpsilon(function.useEpsilon());
            SecantPoint solution = solve(function);
            SecantPoint points[] = getSecantPoints();

            tst_log.debug("solving for TestSecantFunction class '{}'", function.getClass().getName());
            
            int i = 0;
            for ( ; i < points.length; i++) {
                tst_log.debug("\tx: {}\tfx: {}",String.format("%12.9f",points[i].x()),String.format("%12.9f",points[i].fx()));
            }

            tst_log.info("solution:  x = '{}', f(x) = '{}' for TestSecantFunction class '{}'",String.format("%12.9f",points[i-1].x()),String.format("%12.9f",points[i-1].fx()),function.getClass().getName());

            assertTrue((function.solutionReference() - solution.x()) < function.useEpsilon());
            assertTrue(points[points.length-1].fx().doubleValue() < function.useEpsilon());
        }
    }

    @Test
    void TestMySimpleSecantFunction() {

        class MySimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return Math.pow(x,3) - 5 * x.doubleValue() + 1; }
            public Double useEpsilon()        { return 0.000001d; }
            public Double solutionReference() { return 2.128419063d; }
        }
        
        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MySimpleSecantFunction());
    }

    @Test
    void TestMyNextSimpleSecantFunction() {

        class MyNextSimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return Math.pow(2,x) - 5 * x.doubleValue() + 2; }
            public Double useEpsilon()        { return 0.000001d; }
            public Double solutionReference() { return 0.732244255d; }
        }
    
        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MyNextSimpleSecantFunction());
    }

    @Test
    void TestMyThirdSimpleSecantFunction() {

        class MyThirdSimpleSecantFunction implements TestSecantFunction {
            public Double calculate(Double x) { return (Math.pow(x,5) + 3) / 5; }
            public Double useEpsilon()        { return 0.000001d; }
            public Double solutionReference() { return -1.24573094d; }
        }

        TestSecantSolver solver = new TestSecantSolver();
        solver.testSolver(new MyThirdSimpleSecantFunction());
    }
}
