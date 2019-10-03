import javax.swing.JFrame;
import javax.swing.JOptionPane;

class TimerThread extends Thread
{
	JFrame j=new JFrame();
public void run()
{
try
{
for(int i=60;i>=0;i--)
{
MyGame.l.setText(""+i);
Thread.sleep(1000);
}
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
}
}
