package Exception;

public class AccountEx {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        try {
            account.withdraw(10400);
        } catch (InsufficientException e) {
            // 예외 왜 발생하는지 알기 위해서 메시지 변수 선언
            String message = e.getMessage();
            System.out.println(message);
        }

        System.out.println("예금액: " + account.getBalance());
    }
}
