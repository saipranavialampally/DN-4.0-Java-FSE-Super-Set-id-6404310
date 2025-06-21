package week1_datastructures_algorithms.Handson7_FinancialForecasting;

public class FinancialForecast {
    public static double futureValue(double pv, double rate, int years) {
        if (years == 0)
            return pv;
        return (1 + rate) * futureValue(pv, rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 20000;
        double growthRate = 0.09; // 9%
        int years = 6;

        double result = futureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f\n", years, result);
    }
}
