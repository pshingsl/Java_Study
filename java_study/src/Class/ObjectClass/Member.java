package Class.ObjectClass;

public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Member target){ // Obj가 Member 타입인지 검사 -> 타입 변환 후 target 변수에 대입
            if(id.equals(target.id)){ // id 문자열이 같은지 비교
                return true;
            }
        }
        return false;
    }
}
