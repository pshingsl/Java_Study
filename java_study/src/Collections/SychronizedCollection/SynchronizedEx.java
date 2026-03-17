package Collections.SychronizedCollection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedEx {
    public static void main(String[] args) {
        // 동기화 맴 생성
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        // 작업 스레드 생성
        Thread threadA = new Thread(){
            @Override
            public void run(){
                for(int i =1; i<=1000; i++){
                    map.put("내용"+i, i);
                }
            }
        };

        // 작업 스레드 생성
        Thread threadB = new Thread(){
            @Override
            public void run(){
                for(int i =1001; i<=2000; i++){
                    map.put("내용"+i, i);
                }
            }
        };

        // 실행
        threadA.start();
        threadB.start();

        try{
            threadA.join();
            threadB.join();
        }catch (Exception e){

        }

        // 저장된 총 객체수 업기
        int size = map.size();
        System.out.println("총 객체 수: " + size);
    }
}
