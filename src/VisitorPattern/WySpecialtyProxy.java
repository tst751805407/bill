package VisitorPattern;


import javax.swing.*;
import java.awt.*;

/*
本实例中的“婺源特产公司”经营许多婺源特产，它是真实主题，提供了显示特产的 display() 方法，
可以用窗体程序实现（点此下载该实例所要显示的图片）。而韶关“天街e角”公司是婺源特产公司特产的代理，

通过调用婺源特产公司的 display() 方法显示代理产品，当然它可以增加一些额外的处理，如包裝或加价等。

客户可通过“天街e角”代理公司间接访问“婺源特产公司”的产品，图 2 所示是公司的结构图。
 */
public class WySpecialtyProxy
{
    public static void main(String[] args)
    {
        SgProxy proxy=new SgProxy();
        proxy.display();
    }
}
//抽象主题：特产
interface Specialty
{
    void display();
}
//真实主题：婺源特产

class WySpecialty extends JFrame implements Specialty
{
    private static final long serialVersionUID=1L;
    public WySpecialty()
    {
        super("韶关代理婺源特产测试");
        this.setLayout(new GridLayout(1,1));
        JLabel l1=new JLabel(new ImageIcon("src/WuyuanSpecialty.jpg"));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void display()
    {
        this.setVisible(true);
    }
}
//代理：韶关代理
class SgProxy implements Specialty
{
    private WySpecialty realSubject=new WySpecialty();
    public void display()
    {
        preRequest();
        realSubject.display();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("韶关代理婺源特产开始。");
    }
    public void postRequest()
    {
        System.out.println("韶关代理婺源特产结束。");
    }
}
