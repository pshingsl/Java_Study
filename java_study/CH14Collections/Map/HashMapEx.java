package Collections.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("허수", 50);
        map.put("허미", 20);
        map.put("허디", 90);
        map.put("허수", 100); // 키가 같기 때문에 제일 마지막에 저장한 값만 저장 ->
        System.out.println("총 Entry 수: " + map.size()); // 중복으로 인한 3으로 출력
        System.out.println();

        // 키로 값 얻기
        String key = "허디";
        int val = map.get(key);
        System.out.println(key + ": " + val);
        System.out.println();

        // 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet(); // Set에서 String으로 정의한 이유는 위 HashMap에 키의 타입을 String으로 저장했기 때문이다.
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k); // 지금은 위에 저장한 Map의 모든 키의 값을 저장함
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator(); // 엔트리를 반복하기 위해 반복자를 얻음
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey(); // 해당 Map의 키 값 저장
            Integer v = entry.getValue(); // 해당 Map의 값 저장
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("허미");
        System.out.println("총 Entry 수: " + map.size());
    }
}
