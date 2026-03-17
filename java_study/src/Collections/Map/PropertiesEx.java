package Collections.Map;

import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) throws Exception{
        // Properties 객체 생성
        Properties properties = new Properties();

        properties.load(PropertiesEx.class.getResourceAsStream("database.properties"));

        // 주어진 키에 대한 값 읽기
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");

        // 갑 출력
        System.out.println("url:" + url);
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}
