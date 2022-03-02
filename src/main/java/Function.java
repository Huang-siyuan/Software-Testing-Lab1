import lombok.Data;

@Data
public class Function {
    public final static double PI = Math.PI;
    public double calculate_arcos(double x){
        double i = 0, j = PI;
        double result = (i + j) / 2;
        double judge = Math.cos(result) - x;
        double temp;
        while(Math.abs(judge) > 1e-10) {
            result = (i + j) / 2;
            temp = Math.cos(result);
            if(temp - x > 0) {
                i = result;
            } else {
                j = result;
            }
            judge = Math.cos(result) - x;

        }
        return result;
    }
}
