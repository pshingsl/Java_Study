package Class.ObjectClass;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    /*
    *  Object의 hashCode() 메소드를 재정의
    * 학생의 번호와 이름 해시코드를 합한 새로운 해시코드를 리턴하도록 함
    * 즉, 번호와 이름이 같다면 동일한 해시코드 생성
    * */
    @Override
    public int hashCode() {
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    /*
     *  Object의 eqausl() 메소드를 재정의
     * Student 객체인지를 확인 후 학생 번화 이름이 같은지 비교
     * 같으면 참 다르면 거짓
     * */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student target){
            if(no == target.getNo() && name.equals(target.getName())){
                return true;
            }
        }
        return false;
    }
}
