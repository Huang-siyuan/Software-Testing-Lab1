import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.FunctionUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {
    final double EPS = 1.0e-5;
    final double INF = 1.0e8;
    private final Function cal = new Function();
    double x;

    @DisplayName("Test for function")
    @ParameterizedTest
    @ValueSource(doubles = {-1, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1})
    public void check_arccos(double x){
        double actual = cal.calculate_arccos(x);
        double except = Math.acos(x);
        Assertions.assertEquals(actual, except, EPS);
    }

    @DisplayName("Test for exception")
    @ParameterizedTest
    @ValueSource(doubles = {2, -2})
    public void checkIllegalArguments(double x){
        assertThrows(IllegalArgumentException.class, ()->{cal.calculate_arccos(x);});
    }

}
