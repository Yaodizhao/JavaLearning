package JavaReview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8_17 {
    public static void main(String[] args) throws IOException {
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.OCTOBER, 17);
        System.out.println(date.getWeekYear());
        System.out.println(date.getWeeksInWeekYear());
        LocalDateTime d1 = LocalDateTime.of(2013, 12, 31, 23, 59);
        System.out.println(d1.getHour());
        
        Path start = Paths.get("E:/Riot Games/");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".dll"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("\n"));
            System.out.println("Found: " + joined);
        }
        /*
         或者使用walk
         try (Stream<Path> stream = Files.walk(start, maxDepth)) {
             String joined = stream
                 .map(String::valueOf)
                 .filter(path -> path.endsWith(".js"))
                 .sorted()
                 .collect(Collectors.joining("; "));
             System.out.println("walk(): " + joined);
         }
        */
        
        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        // List<Integer> randomBetween0And99 = intStream.limit(100).mapToObj(Integer::valueOf).collect(Collectors.toList());
        List<Integer> randomBetween0And99 = intStream.limit(100).boxed().collect(Collectors.toList());
        System.out.println(randomBetween0And99);
        
        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
        List<Double> gaussianStreamList = gaussianStream.limit(100).boxed().toList();
        System.out.println(gaussianStreamList);
        
    }
    
    
}
