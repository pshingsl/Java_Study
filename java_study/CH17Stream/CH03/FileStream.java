package Stream.CH03;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(FileStream.class.getResource("data.txt").toURI());
        Stream<String> stringStream = Files.lines(path, Charset.defaultCharset());
        stringStream.forEach(line -> System.out.println(line));
        stringStream.close();
    }
}
