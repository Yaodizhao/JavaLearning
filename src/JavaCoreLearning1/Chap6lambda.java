package JavaCoreLearning1;

import JavaCoreLearning1.package1.People;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap6lambda {
    public static void main(String[] args) {
//        Timer t = new Timer("Timer");
//        t.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("ydz");
//            }
//        }, 1000, 1000);
        
        ArrayList<String> names = new ArrayList<>();
        names.add("aa");
        names.add("bb");
        for (String name: names) {
            System.out.println(name);
        }
        Stream<People> stream = names.stream().map(People::new);
        List<People> people = stream.collect(Collectors.toList());
        System.out.println(people.get(0).getName());
        // Person[] people0 = stream.toArray(Person[]::new);
        
        repeat(5, (int x) -> x + 10);
        repeat1(10,()-> System.out.println(211));
    }
    
    public static void repeat(int n, IntFunction action) {
        for (int i = 0; i < n; i++)
            System.out.println(action.apply(1));
            // 如果intfunction改成intconsumer
            // System.out.println(action.accept(i));
    }
    
    public static void repeat1(int n, Runnable action) {
        for (int i = 0; i < n; i++)
            action.run();
    }
}
    
    

