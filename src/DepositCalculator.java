import java.util.Scanner;

public class DepositCalculator {
    int accuracy = 2; //Точность округления
    double yearRate = 0.06; //Годовая процентная ставка

    double calculateComplexPercent(double Amount, double yearRate, int depositPeriod) {
        double amountWithProfitRaw = Amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundUp(amountWithProfitRaw, accuracy);
    }

    double calculateSimplePercent(double Amount, double yearRate, int depositPeriod) {
        return roundUp(Amount + Amount * yearRate * depositPeriod, accuracy);
    }

    double roundUp(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateProfit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountWithProfit = 0;
        if (action == 1) {
            amountWithProfit = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            amountWithProfit = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountWithProfit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }
}
