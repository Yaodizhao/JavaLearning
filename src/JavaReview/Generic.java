package JavaReview;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Generic {
    public <T> T fun(Class<T> t) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(Arrays.toString(t.getDeclaredConstructors()));
        return t.getDeclaredConstructor(int.class).newInstance(123);

    }

    public static String tryCatchReturn() {
        try {
            int i = 1 / 10;
            System.out.println(66);
            return "OK";
        } catch (Exception e) {
            System.out.println(67);
            return "ERROR";
        } finally {
            System.out.println("tryCatchReturn");
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        Generic generic = new Generic();
//        Integer fun = generic.fun(Integer.class);
//        System.out.println(fun);
//        List<?>[] list15 = new ArrayList<?>[10];
//        List<Integer> list = new ArrayList<>();

        ArrayWithTypeToken<Integer> arrayToken = new ArrayWithTypeToken<>(Integer.class, 10);
        arrayToken.put(2, 1);
        Integer[] array = arrayToken.create();
        array[0] = 1;
        System.out.println(Arrays.toString(array));

//        String s = tryCatchReturn();
//        System.out.println(s);
        ServiceLoader<Integer> serviceLoader = ServiceLoader.load(Integer.class);
        Iterator<Integer> iterator = serviceLoader.iterator();


    }
}

class ArrayWithTypeToken<T> {
    private T[] array;

    public ArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] create() {
        return array;
    }
}