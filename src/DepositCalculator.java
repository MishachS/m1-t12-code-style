import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);

        return randomValue(pay, 2);
    }
    double calculateSimplePercent(double doubleAmount,double yearRate, int depositPeriod) {
        return randomValue(doubleAmount + doubleAmount * yearRate * depositPeriod, 2);
    }
    double randomValue(double value,int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }
    void doCalculate( ) {
        int period;
        int action ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double totalSum = 0;

        if (action == 1) {
            totalSum = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            totalSum = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalSum);
    }
    public static void main(String[] args) {
        new DepositCalculator().doCalculate();
    }
}

