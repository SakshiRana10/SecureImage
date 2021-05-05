

package imageencryption;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Imageop extends JFrame implements ActionListener{
    JButton btn,btn1;
    JTextField tf;
Imageop(){
setTitle("--Encrypt Your Image at Once--");
setBounds(400,150,450,400);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Panel created//
JPanel p1 = new JPanel();
p1.setLayout(null);
p1.setBounds(0,0,450,400);
p1.setBackground(new Color(131,193,223));
add(p1);

JLabel l = new JLabel("--Welcome--");
l.setBounds(140,30,200,25);
l.setFont(new Font("San_serif",Font.BOLD,25));
p1.add(l);

JLabel l1 = new JLabel("Select Your Image and Encrypt it in no Time");
l1.setBounds(20,70,400,25);
l1.setFont(new Font("San_serif",Font.PLAIN,20));
p1.add(l1);

JLabel l2 = new JLabel("Enter Your Key");
l2.setBounds(30,150,120,25);
l2.setForeground(Color.white);
l2.setFont(new Font("San_serif",Font.BOLD,15));
p1.add(l2);

 tf = new JTextField();
tf.setBounds(150,150,230,25);
tf.setBorder(BorderFactory.createEmptyBorder());
p1.add(tf);

 btn = new JButton("Select for Encryption");
btn.setBounds(30,230,170,35);
btn.setBackground(Color.BLACK);
btn.setForeground(Color.WHITE);
btn.setFont(new Font("San_serif",Font.BOLD,15));
btn.setBorder(BorderFactory.createEmptyBorder());
btn.addActionListener(this);
p1.add(btn);

 btn1 = new JButton("Select for Decryption");
btn1.setBounds(230,230,170,35);
btn1.setBackground(Color.BLACK);
btn1.setForeground(Color.WHITE);
btn1.setFont(new Font("San_serif",Font.BOLD,15));
btn1.setBorder(BorderFactory.createEmptyBorder());
btn1.addActionListener(this);
p1.add(btn1);


setVisible(true);
    }
public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource() == btn){
   String text =  tf.getText();
   int temp = Integer.parseInt(text);
   encrypt(temp);
 }
   if(ae.getSource() == btn1){
   String text1 =  tf.getText();
   int temp1 = Integer.parseInt(text1);
   dencrypt(temp1);
   }
 
}
public static void dencrypt(int key)
{
 JFileChooser fc = new JFileChooser();
 fc.showOpenDialog(null);
 File file = fc.getSelectedFile();
 //file input stream reader
 try
 {
    FileInputStream fis1 = new FileInputStream(file);
    byte[] data=new byte[fis1.available()];
    fis1.read(data);
    int i =0;
    for(byte b:data)
    {
     data[i]=(byte)(b^key);
     i++;
    }
   FileOutputStream fos = new FileOutputStream(file);
   fos.write(data);
   fos.close();
   fis1.close();
   JOptionPane.showMessageDialog(null,"Your Image is Decrypted!");

  }catch(Exception e){}
}
public static void encrypt(int key)
{
 JFileChooser fc = new JFileChooser();
 fc.showOpenDialog(null);
 File file = fc.getSelectedFile();
 //file input stream reader
 try
 {
    FileInputStream fis = new FileInputStream(file);
    byte[] data=new byte[fis.available()];
    fis.read(data);
    int i =0;
    for(byte b:data)
    {
     data[i]=(byte)(b^key);
     i++;
    }
   FileOutputStream fos = new FileOutputStream(file);
   fos.write(data);
   fos.close();
   fis.close();
   JOptionPane.showMessageDialog(null,"Your Image is Encrypted!");

 }catch(Exception e){}
}
  public static void main(String[] args){
new  Imageop();



  }

}