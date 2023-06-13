package JavaReview;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // List<Integer> list = new ArrayList<>();
        // Class<? extends List> clazz = list.getClass();
        // Method add = clazz.getDeclaredMethod("add", Object.class);
        // // 但是通过反射添加，是可以的
        // add.invoke(list, "kl");
        //
        // System.out.println(list);
        // ArrayList<Integer> intss = new ArrayList<>();
        // int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        // Arrays.setAll(array, x -> array[x] + 1);
        // intss = (ArrayList<Integer>) Arrays.stream(array).boxed().collect(Collectors.toList());
        // array[2] = -1;
        // System.out.println(Arrays.mismatch(intss.stream().mapToInt(i -> i).toArray(), array));
        // System.out.println(intss);
        // System.out.println(new test().strStr("leetcode", "tc"));
        // char[][] board = new char[3][3];
        // System.out.println(board.length);
        // Arrays.fill(board,new char[]{'1','2','3'});
        // System.out.println(Arrays.deepToString(board));
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
        // dateInter.setValue(new Object()); //编译错误

    }

    public int strStr(String haystack, String needle) {
        return Collections.indexOfSubList(List.of(haystack.toCharArray()), List.of(needle.toCharArray()));
        // return haystack.indexOf(needle);
    }

}

class Pair<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date> {

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        return super.getValue();
    }
}
