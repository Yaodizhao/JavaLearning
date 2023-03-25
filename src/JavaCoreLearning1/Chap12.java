package JavaCoreLearning1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

//本程序演示 一个球弹跳的动画
public class Chap12 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

//里面有球和按钮的frame
class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
    
    //构造函数
    public BounceFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Bounce");
        
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall()
        );
        addButton(buttonPanel, "Close", event -> System.exit(0)
        );
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    //  添加button到容器
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
    
    //添加一个跳动的球到panel，并且让他跳动1000次
    //如果一个方法用synchronized关键字声明，那么对象的锁将保护整个方法。也就是说，要调用该方法，线程必须获得内部的对象锁。
    //用synchronized关键字声明 将只有一个球在动
    public synchronized void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
            
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
    
}
//

//一个可以移动的球，还可以在四边形边缘跳动
class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
    
    //移动球到下一个位置，碰到边缘就反向
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = - dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = - dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = - dy;
        }
        if (y + YSIZE > bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = - dy;
        }
        
    }
    
    //得到球的shape作为它的当前的位置
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
    
}

class BallComponent extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    
    // 添加一个球到组件component
    public void add(Ball b) {
        balls.add(b);
    }
    
    public void paintComponent(Graphics g) {
        //擦除背景  注释掉或者不注释掉super.paintComponent()，将会改变界面重绘过程
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Ball b: balls) {
            g2.fill(b.getShape());
        }
    }
    
}
