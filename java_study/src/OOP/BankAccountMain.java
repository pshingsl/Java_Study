package OOP;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1001", "홍길동");
        BankAccount account2 = new BankAccount("1002", "김철수");

        //입금
        account1.deposit(10000); account1.deposit(5000);
        // 출금
        account1.withdraw(3000);
        //잔액 확인
        System.out.println( "현재 잔액 : " + account1.getBalance() );
        // 계좌 정보
        account1.printAccountInfo();

        //static
        System.out.println( "현재 생성된 계좌 수 : " + BankAccount.getAccountCount() );
    }
}
