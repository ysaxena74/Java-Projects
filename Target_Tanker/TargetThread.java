class TargetThread extends Thread
{
public void run()
{
	try
	{
	while(true)
	{
		int a=MyGame.b2.getX();
		if(a>=400)
			a=0;
		a=a+10;
		MyGame.b2.setBounds(a,10,100,30);
		Thread.sleep(50);
	}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
