package JavaCoreLearning1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Chap10 {
    public static void main(String[] args) {
//      事件分派线程
        EventQueue.invokeLater((() -> {
            SimpleFrame sf = new SimpleFrame();
            sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            关闭所有框架装饰
//            sf.setUndecorated(true);
//            获取系统屏幕大小 以dimension存储
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            System.out.printf("%d,%d", screenSize.width, screenSize.height);
            sf.setSize(screenSize.width / 2, screenSize.height / 2);
            sf.setLocation(500, 300);
//            图标
            Image img = new ImageIcon("src/icon.png").getImage();
            sf.setIconImage(img);
            sf.setTitle("temp");
            sf.setVisible(true);
//        通过构造器直接设置size
//        JFrame jf = new JFrame();
//        jf.setSize(1000, 1000);
//        jf.setVisible(true);})
            JFrame Nhwf = new NotHelloWorldFrame();
            Nhwf.setTitle("NotHelloWorld");
            Nhwf.setSize(400, 400);
            Nhwf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Nhwf.setVisible(true);
            
        }));
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class NotHelloWorldFrame extends JFrame {
    
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    public static final int x = 75, y = 100;
    
    //    绘制文字函数 别打错了！！！
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g.drawString("Not a Hello World program", x, y);
        //   绘制2D图形
        Rectangle2D rect = new Rectangle2D.Float(50F, 100F, 200F, 150F);
        g2.setBackground(Color.blue);
        g2.setPaint(Color.RED);
        g2.draw(rect);

    }
    
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}


