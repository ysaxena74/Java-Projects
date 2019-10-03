//Eclipse Work

import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener
{
	Frame f;
	Button b1,b2,b3,b4,b5;
	TextField t1,t2,t3;
	String ch;
	String s1,s2;
	float a,b,c;
	Calculator()
	{
		f=new Frame("Calculator");
		f.setBackground(Color.blue);
		b1=new Button("+");
		b2=new Button("-");
		b3=new Button("*");
		b4=new Button("/");
		b5=new Button("=");
		t1=new TextField();
		t2=new TextField();
		t3=new TextField();
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400,400);
		t1.setBounds(5,40,390,30);
		b1.setBounds(5,80,40,40);
		b2.setBounds(55,80,40,40);
		b3.setBounds(105,80,40,40);
		b4.setBounds(155,80,40,40);
		t2.setBounds(5,140,390,40);
		b5.setBounds(180,200,40,40);
		t3.setBounds(5,260,390,40);
		b1.setBackground(Color.red);
		b2.setBackground(Color.red);
		b3.setBackground(Color.red);
		b4.setBackground(Color.red);
		b5.setBackground(Color.green);
		f.add(t1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(t2);
		f.add(b5);
		f.add(t3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				f.dispose();
			}
		});
	}
	public static void main(String ar[])
	{
		Calculator C=new Calculator();
	}
	public void actionPerformed(ActionEvent e)
	{
		int k;
		Button bt=(Button)e.getSource();
		if(bt==b1 ||bt==b2 ||bt==b3 || bt==b4)
			ch=bt.getLabel();
		else
		{
			k=0;
			try
			{
			s1=t1.getText();
			a=Float.parseFloat(s1);
			s2=t2.getText();
			b=Float.parseFloat(s2);
			if(ch.equals("+"))
				c=a+b;
			else if(ch.equals("-"))
				c=a-b;
			else if(ch.equals("*"))
				c=a*b;
			else if(ch.equals("/"))
				c=a/b;
			else
			{
				t3.setText("Input Not Found");
				k=1;
			}
			if(k==0)
				t3.setText(""+c);
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
	}
}