import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class Server_GUI implements ActionListener
{
Socket s;
Frame f;
Button b;
TextField t;
List l;
Server_GUI()
{
f=new Frame("Server");
t=new TextField();
b=new Button("SEND");
b.addActionListener(this);
l=new List();
f.add(t,BorderLayout.NORTH);
f.add(l);
f.add(b,BorderLayout.SOUTH);
f.setSize(400,400);
f.setVisible(true);
try
{
ServerSocket ss=new ServerSocket(localhost,2000);
s=ss.accept();
while(true)
{
ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
String str=ois.readObject().toString();
l.add("Friend:-"+str);
}
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
public static void main(String ar[])
{
Server_GUI s=new Server_GUI();
}
public void actionPerformed(ActionEvent e)
{
try
{
ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
String str=t.getText();
l.add("Me:-"+str);
oos.writeObject(str);
}
catch(Exception e1)
{
System.out.println(e1.getMessage());
}
}
}