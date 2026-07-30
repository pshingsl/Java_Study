package OOP;

public class ConstructorExam {
    public static void main(String[] args) {
        /*
        * 생성자(Constructor)
        *
        * 정의
        * ㄴ 객체가 생성될 때 자동으로 호출되는 특별한 메소드
        * ㄴ 객체를 생성하면서 필요한 초기값을 설정할 때 사용
        *
        * 왜 사용하는가?
        * ㄴ 객체를 생성할 때 필요한 값을 미리 초기화하기 위해 사용
        *
        * 언제 사용하는가?
        *ㄴ 객체 생성 시 초기값 설정
        *ㄴ 필수 데이터를 반드시 받게 만들고 싶을떄
        *ㄴ 객체 생성과 동시에 준비가 끝난 상태를 만들고 싶을 때
        *ㄴ 엔티티, 디티어, 브이오에서 사용
        *
        * 문법
        * public class 클래스명 {
        *   클래스명() {
        *
        *   }
        * }
        *
        * 생성자는 반환형이 없다.
        * 생성자는 이름과 동일하다.
        * 생성자를 하나도 작성하지 않으면 컴파일러가 자동으로 클래스명(){ } 혈태로 만들어준다.
        *
        * this
        *
        * 정의
        * ㄴ 현재 객체 자신을 의미한다.
        *
        * 주의사항ㄹ
        * ㄴ 생성자는 반환형이 없다
        * ㄴ 생성자 이름은 클래스 이름과 동일해야 한다.
        * ㄴ 생성자를 하나 만들면 기본 생성자는 자동 생성되지 않는다.
        * ㄴ 생성자는 객체 생성 시에만 호출된다.
        * */

        Product product = new Product("Note",1000);
        System.out.println("상품: " + product.name + ", 가격: " + product.price);
    }
}

class Product {
    String name;
    int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }
}