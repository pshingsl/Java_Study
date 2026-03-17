package Collections.LIFOandFIFO;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        // Stack컬렉션 생성 : LIFO
        Stack<Coin> coinStack = new Stack<>();

        // 동전 넣기
        coinStack.push(new Coin(100));
        coinStack.push(new Coin(50));
        coinStack.push(new Coin(500));
        coinStack.push(new Coin(10));

        while (!coinStack.isEmpty()){
            Coin coin = coinStack.pop();
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
        }
    }
}
