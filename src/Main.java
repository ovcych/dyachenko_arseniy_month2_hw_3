public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);
        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Сумма успешно снята. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Попытка снятия суммы больше, чем остаток на счете.");
                System.out.println("Сумма, доступная для снятия: " + e.getRemainingAmount());
                account.deposit(e.getRemainingAmount()); // Снимаем только доступную сумму
                System.out.println("Сумма успешно снята. Остаток на счете: " + account.getAmount());
                break;
            }
        }
    }
}
