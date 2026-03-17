package Collections.LIFOandFIFO;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        //Queue 컬렉션 생성
        Queue<Message> queue = new LinkedList<>();

        // 메시지 넣기
        queue.offer(new Message("sendMail", "Ho"));
        queue.offer(new Message("sendSMS", "Hoo"));
        queue.offer(new Message("sendInsta", "Hon"));

        while (!queue.isEmpty()) {
            Message message = queue.poll(); // 비어있지 않다면 반복
            switch (message.name) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS를 보냅니다.");
                    break;
                case "sendInsta":
                    System.out.println(message.to + "님에게 인스타를 보냅니다.");
                    break;
            }
        }
    }
}
