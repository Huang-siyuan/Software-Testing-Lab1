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
    private final Function cal = new Function();

    // 设定这个单元测试的名称
    @DisplayName("Test for function")
    // 进行参数化测试
    @ParameterizedTest
    // 参数源（将会一个个输入方法进行测试）
    @ValueSource(doubles = {-1, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1})
    public void check_arccos(double x){
        // actual是实际的结果
        double actual = cal.calculate_arccos(x);
        // expected是期望的结果，直接调用
        double except = Math.acos(x);
        // 断言，判断两者的差值是否小于EPS，正确则通过，否则测试失败
        Assertions.assertEquals(actual, except, EPS);
    }

    @DisplayName("Test for exception")
    @ParameterizedTest
    @ValueSource(doubles = {2, -2})
    public void checkIllegalArguments(double x){
        // 断言，判断是否抛出异常
        assertThrows(IllegalArgumentException.class, ()->{cal.calculate_arccos(x);});
    }

}
