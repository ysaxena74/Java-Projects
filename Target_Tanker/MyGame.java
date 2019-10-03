import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyGame implements ActionListener
{
static Frame f;
static Button b1,b2,b3;
static Label l,l2;



MyGame()
{
f=new Frame("Pocket Tank");
f.addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
	{
		f.dispose();
	}
});
f.setBackground(Color.YELLOW);
b1=new Button("Tank");
b1.setBackground(Color.BLUE);
b2=new Button("Target");
b2.setBackground(Color.GREEN);
b3=new Button();
b3.setBackground(Color.RED);
l=new Label();
l2=new Label(""+0);
b1.addActionListener(this);
f.setLayout(null);
b1.setBounds(190,360,40,40);
b2.setBounds(5,10,100,30);
b3.setBounds(205,350,10,10);
l.setBounds(5,370,100,30);
l2.setBounds(300,370,100,30);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(l);
f.add(l2);
f.setVisible(true);
f.setSize(400,400);
TimerThread t1=new TimerThread();
t1.start();
TargetThread t2=new TargetThread();
t2.start();

}
public static void main(String ar[])
{
MyGame mg=new MyGame();
}
public void actionPerformed(ActionEvent e)
{
	BulletThread t3=new BulletThread();
	t3.start();
	//ScoreThread t4=new ScoreThread();
	//t4.start();
}
}