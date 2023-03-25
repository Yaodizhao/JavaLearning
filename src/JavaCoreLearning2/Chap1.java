package JavaCoreLearning2;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Chap1 {
    
    public static void main(String[] args) throws IOException {
        String contents = Files.readString(Paths.get("src/JavaCoreLearning1/alice30.txt"));
        List<String> words = List.of(contents.split("\\PL+"));
        // long count = words.stream().filter(w -> w.length() > 12).count();
        // 并行过滤
        long count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
        
        Stream<String> echos = Stream.generate(() -> "echo");
        System.out.println(echos.limit(11).collect(Collectors.toList()));
        
        Stream<BigInteger> ints = Stream.iterate(BigInteger.ZERO, n -> n.compareTo(BigInteger.valueOf(1000)) < 0, n -> n.add(BigInteger.ONE));
        System.out.println(ints.collect(Collectors.toList()));
        
        Iterable<Path> it = FileSystems.getDefault().getRootDirectories();
        System.out.println(it.toString());
        Stream<Path> rootDirectiories = StreamSupport.stream(it.spliterator(), false);
        System.out.println(rootDirectiories.collect(Collectors.toList()));
        
        IntStream st = Arrays.stream(new int[]{1, 2, 3, 4}, 0, 3);
        System.out.println(Arrays.toString(st.toArray()));
        
        List<String> dic = List.of(new String[]{"aa", "bb", "CC"});
        // 升大写
        Stream<String> longwords = dic.stream().map(String::toUpperCase);
        // 首字母
        Stream<String> firstletters = dic.stream().map(s -> s.substring(0, 1));
        System.out.println(longwords.collect(Collectors.toList()));
        System.out.println(firstletters.collect(Collectors.toList()));
        
        Stream<String> re = words.stream().flatMap(w -> codePoints(w));
        // System.out.println(re.collect(Collectors.toList()));
        
        //限制前100 和跳过前100
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        Stream<Double> skip = randoms.skip(100);
        //取为真和取不为真
        Stream<String> take = Stream.of(contents).takeWhile("0123456789"::contains);
        Stream<String> drop = Stream.of(contents).dropWhile(s -> s.trim().length() == 0);
        System.out.println(take.collect(Collectors.toList()));
        // System.out.println("\u23BF任晶晶\u23CB");
        // 连接
        Stream<String> combined = Stream.concat(codePoints(("hello")), codePoints("world"));
        System.out.println(combined.collect(Collectors.toList()));
        
        Object powers = Stream.iterate(1, p -> p * 2).peek(System.out::println).limit(20).toArray();
        
        String sb = "ssa";
        String result = Optional.of(sb).orElse("");
        System.out.println(result);
        
        Optional<List<String>> optionalStringList = Optional.of(Arrays.asList("1", "2", "3"));
        optionalStringList.ifPresent(list -> list.forEach(System.out::println));
        System.out.println(optionalStringList);
        
        Stream<String> combined1 = Stream.concat(codePoints(("hello")), codePoints("world"));
        System.out.println(combined1.collect(Collectors.joining()));
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(i + 1);
        }
        Integer sum = values.stream().reduce(1, (x, y) -> x * y);
        System.out.println(sum);
        
        int[] a = new int[]{1, 2, 3, 45};
        IntStream st1 = IntStream.of(1, 1, 2, 3, 45);
        // 另一种初始化
        // IntStream st1 = Arrays.stream(a, 0, 4);
        System.out.println(Arrays.toString(st1.toArray()));
        
        Map<Integer, Long> sw = new HashMap<>();
        sw.put(1, 1233L);
        System.out.println(sw.get(1));
        
        Map<Integer, Long> sw2 = words.parallelStream().filter(s -> s.length() < 12).collect(groupingBy(String::length, counting()));
        for (Long value: sw2.values()) {
            System.out.println(value);
        }
        
        
    }
    
    public static Stream<String> codePoints(String s) {
        var result = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }
        return result.stream();
    }
    
}
