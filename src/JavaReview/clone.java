package JavaReview;

import java.util.Arrays;

public class clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample clone = new CloneExample();
        CloneExample clone1 = clone.clone();
        clone1.getA();
        clone1.getB();
        System.out.println("----------");
        System.out.println("1：" + Arrays.toString(clone.getArray()));
        System.out.println("1：" + Arrays.toString(clone1.getArray()));
        System.out.println("----------");
        clone1.setArray(1, 99);
        System.out.println("----------");
        System.out.println("1：" + Arrays.toString(clone.getArray()));
        System.out.println("1：" + Arrays.toString(clone1.getArray()));
        System.out.println("----------");
        clone1.getA();
        clone1.getB();
        clone.getA();
        clone.getB();
    }
}

class CloneExample implements Cloneable {


    private int a;
    private int b;
    private int[] array = {1, 2, 3};

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        System.out.println(a);
        return a;
    }

    public int getB() {
        System.out.println(b);
        return b;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int index, int value) {
        this.array[index] = value;
    }

}