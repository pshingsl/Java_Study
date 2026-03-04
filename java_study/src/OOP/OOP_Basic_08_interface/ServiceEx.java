package OOP.OOP_Basic_08_interface;

import java.security.spec.RSAOtherPrimeInfo;

public class ServiceEx {
    public static void main(String[] args) {
        Service service = new ServiceImpl();

        // 디폴트
        service.defaultMethod1();
        System.out.println();
        service.defaultMethod2();
        System.out.println();

        // 정적 메서드
        Service.staticMethod1();
        System.out.println();
        Service.staticMethod2();
    }
}
