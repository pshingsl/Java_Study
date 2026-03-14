package Collections.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
        //  ArrayList 선언방법
        // List<E> list = new ArrayList<E>();
        // List<E> list = new ArrayList<>();
        // List list = new ArrayLis();
        List<Board> list = new ArrayList<Board>();

        // 객체 추가
        list.add(new Board("프로그래밍", "자바", "글쓴이1"));
        list.add(new Board("프로그래밍", "C", "글쓴이2"));
        list.add(new Board("프로그래밍", "파이썬", "글쓴이3"));
        list.add(new Board("프로그래밍", "스프링", "글쓴이4"));
        list.add(new Board("프로그래밍", "MySQL", "글쓴이5"));

        // 저장된 객체수 얻기
        int size = list.size();
        System.out.println("총 저장된 객체 수: " + size);
        System.out.println();

        // 특정 인덱스의 객체 가져오기
        Board board = list.get(3);
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
        System.out.println();

        //  모든 객체 가져오기
        for(int i = 0; i<list.size(); i++){
            Board b = list.get(i);
            // System.out.println(b); 지금 저장된 객체의 주소를 출력
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

        // 객체 삭제
        list.remove(2);
        list.remove(2);

        // 향상된 for문 사용
        for(Board b : list){
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
    }
}
