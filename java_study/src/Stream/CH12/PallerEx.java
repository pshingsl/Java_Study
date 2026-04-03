package Stream.CH12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PallerEx {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> score = new ArrayList<>();
        for(int i =0; i<10000000; i++){
            score.add(random.nextInt(101));
        }

        double avg = 0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;

        Stream<Integer> stream = score.stream();
        startTime = System.nanoTime();
        avg = stream.mapToInt(i-> i.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");

        Stream<Integer> parallerStream = score.parallelStream();
        avg = parallerStream.mapToInt(i-> i.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");

    }
}
