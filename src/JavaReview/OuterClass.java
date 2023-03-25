package JavaReview;

public class OuterClass {
    class InnerClass {
    }
    
    static class StaticInnerClass {
    }
    
    public static void main(String[] args) {
        // 静态内部类不能访问外部类的非静态的变量和方法。
        // InnerClass innerClass = new InnerClass();
        // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
