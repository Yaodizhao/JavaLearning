package JavaCoreLearning1;

import JavaCoreLearning1.package1.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Arrays.asList;

public class Chap9 {
    public static void main(String[] args) {
        Queue<Employee> eline = new CircularArrayQueue<>(100);
        eline.add(new Employee("aa", 11, 11, 11, 1));
        System.out.println(eline);
        AbstractCollection<Integer> mc = new ArrayList<>();
        mc.add(1);
        System.out.println(mc.contains(1));

//         链表
        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        ListIterator<String> iter = staff.listIterator();
        iter.next();// 将越过链表中的第一元素，并在第二个元素之前添加Juliet
        iter.add("Juliet");
//         amy juliet bob carl
        for (String s: staff) {
            System.out.println(s);
        }
//         创建staff的视图
        List aslist = asList(staff);
        System.out.println("视图");
        for (Object o: aslist) {
            System.out.println(o);
        }
//         切片
        List group = staff.subList(0, 3);
        System.out.println("切片");
        for (Object o: group) {
            System.out.println(o);
        }
//         散列
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(new File("src/JavaCoreLearning1/alice30.txt"))) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterator<String> iters = words.iterator();
        for (int i = 1; i <= 20 && iters.hasNext(); i++)
            System.out.println(iters.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");

//         散列映射
        Map<String, Employee> staffmap = new HashMap<>();// HashMap implements Map
        Employee harry = new Employee("Harry Hacker");
        staffmap.put("987-98-9996", harry);
        staffmap.put("144-25-5464", new Employee("Amy Lee"));
        staffmap.put("567-24-2546", new Employee("Harry Hacker"));
        staffmap.put("157-62-7935", new Employee("Cary Cooper"));
        staffmap.put("456-62-5527", new Employee("Francesca Cruz"));
        // 根据键值获取
        String id = "987-98-9996";
        Employee e = staffmap.get(id);
        
        // 访问所有映射条目
        staffmap.forEach((k, v) ->
                System.out.println("key=" + k + "value:" + v));
        // 将创建一个包含100个字符串的List,每个串都被设置为DEFAULT
        List<String> settings = Collections.nCopies(100, "DEFAULT");
//        for (String s: settings) {
//            System.out.println(s);
//        }
        System.out.println(max(staff));
    }
    
    //  迭代计算最大
    public static <T extends Comparable> T max(Collection<T> c) {
        Iterator<T> iter = c.iterator();
        T largest = iter.next();
        while (iter.hasNext()) {
            T next = iter.next();
            if (largest.compareTo(next) < 0)
                largest = next;
        }
        return largest;
    }
}


interface Queue<E> {
    // 如果需要一个循环 数组队列，就可以使用 ArrayDeque 类。如果需要一个链表队列， 就直接使用 LinkedList类， 这个类实现了 JavaCoreLearning.Queue 接口。
    void add(E element);
    
    E remove();
    
    int size();
}

class CircularArrayQueue<E> implements Queue<E> {
    private int head, tail;
    private E[] elements;
    
    CircularArrayQueue(int capacity) {
        this.head = 0;
        this.tail = 0;
    }
    
    @Override
    public void add(E element) {
    }
    
    @Override
    public E remove() {
        return null;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
}

