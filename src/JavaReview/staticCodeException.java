package JavaReview;

public class staticCodeException {
    static class MyConstants {
        //故意制造一个运行时异常
        static final Integer CODE = (1 / 0);
    }

    public static void main(String[] args) {
        try {
            System.out.println("第一次调用");
            System.out.println(MyConstants.CODE);
        } catch (Throwable e) {//抛出的是Error，用Exception catch不住，所以用Throwable
            System.out.println("第一次调用报错\n" + e);
            System.out.println("第一次调用报错原因\n" + e.getCause());
        }

        try {
            System.out.println("第二次调用");
            System.out.println(MyConstants.CODE);
        } catch (Throwable e) {
            System.out.println("第二次调用报错\n" + e);
            System.out.println("第二次调用报错原因\n" + e.getCause());
        }

        try {
            System.out.println("第三次调用");
            System.out.println(MyConstants.CODE);
        } catch (Throwable e) {
            System.out.println("第三次调用报错\n" + e);
            System.out.println("第三次调用报错原因\n" + e.getCause());
        }
    }
}
