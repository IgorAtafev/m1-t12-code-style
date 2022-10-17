import java.util.Scanner;

public class DepositCalculator {
    private static final int DEPOSIT_WITHOUT_CAPITALIZATION = 1;
    private static final int DEPOSIT_WITH_CAPITALIZATION = 2;

    private double calculateComplexPercent(double amount, double percent, int period) {
        return roundValue(amount * Math.pow((1 + percent / 12), 12 * period), 2);
    }

    private double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundValue(amount + amount * yearRate * period, 2);
    }

    private double roundValue(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    public void calculateDepositPerPeriod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int initialAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int periodDeposit = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int typeDeposit = scanner.nextInt();

        double finalAmount = 0;
        if (typeDeposit == DEPOSIT_WITHOUT_CAPITALIZATION) {
            finalAmount = calculateSimplePercent(initialAmount, 0.06, periodDeposit);
        } else if (typeDeposit == DEPOSIT_WITH_CAPITALIZATION) {
            finalAmount = calculateComplexPercent(initialAmount, 0.06, periodDeposit);
        }

        System.out.println("Результат вклада: " + initialAmount + " за " + periodDeposit + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositPerPeriod();
    }
}