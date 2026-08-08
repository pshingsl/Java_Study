package OOP;

public class BankAccount {
    public static final String BANK_NAME = "BANK";

    private static int accountCount = 0;

    private final String accountNumber;
    private final String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        accountCount++;
    }

    public void deposit(int money) {
        if (money <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return;
        }

        balance += money;
    }

    public void withdraw(int money) {
        if (money <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
        }

        if (money > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        balance -= money;
        System.out.println(money + "원이 출급 되었습니다.");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public void printAccountInfo() {
        System.out.println("===== 계좌 정보 =====");
        System.out.println("은행 : " + BANK_NAME);
        System.out.println("계좌번호 : " + accountNumber);
        System.out.println("예금주 : " + owner);
        System.out.println("잔액 : " + balance);
        System.out.println("====================");
    }
}
