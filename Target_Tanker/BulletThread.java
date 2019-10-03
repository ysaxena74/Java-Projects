import javax.swing.JOptionPane;

public class BulletThread extends Thread {
public void run()
{
	int a=MyGame.b3.getX();
	try
	{
		String p=MyGame.l2.getText();
		String p1=MyGame.l.getText();
		int c=Integer.parseInt(p1);
		int pp=Integer.parseInt(p);
		while(a>0)
		{
			if(a==0)
				a=350;
			a=a-10;
			MyGame.b3.setBounds(205,a,10,10);
			int x1,x2,y1,y2;
			x1=MyGame.b2.getX();
			x2=MyGame.b3.getX();
			y1=MyGame.b2.getY();
			y2=MyGame.b3.getY();
			
			
			if((x2>=x1&&x2<=x1+100)&&(y2>=y1&&y2<=y1+30)&&(c!=0))
			{
				pp=pp+1;
				MyGame.l2.setText(""+pp);
				break;
			}	
			Thread.sleep(10);
		}
		if(c==0)
		{
		if(pp>=30)
			JOptionPane.showMessageDialog(MyGame.f,"Game Over...You Won");
		else
			JOptionPane.showMessageDialog(MyGame.f,"Game Over...You Lose");
		}
	}
	catch(Exception e)
	{System.out.println(e.getMessage());
}
}
}
