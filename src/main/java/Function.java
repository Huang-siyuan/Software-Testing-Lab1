import lombok.Data;

@Data
public class Function {
    public final static double PI = Math.PI;

    public double calculate_arccos(double x) {
        // 如果超出定义域则抛出异常
        if (x > 1 || x < -1) {
            throw new IllegalArgumentException("The domain of arccos is [-1,1].");
        } else {
            double i = 0, j = PI;
            double result = (i + j) / 2;
            double judge = Math.cos(result) - x;
            double temp;
            while (Math.abs(judge) > 1e-15) {
                result = (i + j) / 2;
                temp = Math.cos(result);
                if (temp - x > 0) {
                    i = result;
                } else {
                    j = result;
                }
                judge = Math.cos(result) - x;
            }
            return result;
        }

    }

}
