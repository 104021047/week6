package hw1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * 計時器
* Author: 104021047 林恒毅
*/
public class MainFrame extends JFrame{
public MainFrame(){
	initComp();
}
	
	private Container cp;
	private Timer t1;
	private JButton btnGo = new JButton("Go");
	private JButton btnStop = new JButton("Stop");
	private JButton btnRecord = new JButton("Record");
	private JButton btnExit = new JButton("Exit");
	private JTextArea jta = new JTextArea(" ");
	private JScrollPane jsp= new JScrollPane(jta);
	private ImageIcon[] imgs = new ImageIcon[10];
	private JLabel jlb6 = new JLabel();
	private JLabel jlb5 = new JLabel();
	private JPanel jpn = new JPanel();
	private JLabel jlb3 = new JLabel();
	private JLabel jlb4 = new JLabel();
	private JLabel d = new JLabel("  :");
	private JLabel d1 = new JLabel("  :");
	private JLabel jlb2 = new JLabel();
	private JLabel jlb = new JLabel();
	private int x =0;
	private int y =0;
	private int z =0;
	private int count =0;
	private int h1,h2,m1,m2,s1,s2;
	private void initComp() {
	this.setBounds(50,50,1000,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	cp = this.getContentPane();
	cp.setLayout(new BorderLayout(5,5));
	t1 = new Timer(1000,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			x++;
			if(y/60>0){
				z++;
				jlb6.setIcon(imgs[z/10]);
				h1=z/10;
				jlb6.repaint();
				jlb5.setIcon(imgs[z%10]);
				jlb5.repaint();
				h2=z%10;
				y=y-60;
			}
			if(x/60>0){
				y++;
				jlb4.setIcon(imgs[y/10]);
				m1=y/10;
				jlb4.repaint();
				jlb3.setIcon(imgs[y%10]);
				m1=y%10;
				jlb3.repaint();
				x=x-60;
			}
			jlb2.setIcon(imgs[x/10]);
			s1=x/10;
			jlb2.repaint();
			
			jlb.setIcon(imgs[x%10]);
			s2=x%10;
			jlb.repaint();
				
		}
	});
	imgs[0]=new ImageIcon("0.png");
	imgs[1]=new ImageIcon("1.png");
	imgs[2]=new ImageIcon("2.png");
	imgs[3]=new ImageIcon("3.png");
	imgs[4]=new ImageIcon("4.png");
	imgs[5]=new ImageIcon("5.png");
	imgs[6]=new ImageIcon("6.png");
	imgs[7]=new ImageIcon("7.png");
	imgs[8]=new ImageIcon("8.png");
	imgs[9]=new ImageIcon("9.png");
	jlb6.setIcon(imgs[0]);
	jlb5.setIcon(imgs[0]);
	jlb4.setIcon(imgs[0]);
	jlb3.setIcon(imgs[0]);
	jlb2.setIcon(imgs[0]);
	jlb.setIcon(imgs[0]);
d.setFont(new Font("新細明體",Font.PLAIN,48));
d1.setFont(new Font("新細明體",Font.PLAIN,48));
	jpn.setLayout(new GridLayout(1,0));
	jpn.add(jlb6);
	jpn.add(jlb5);
	jpn.add(jlb4);
	jpn.add(jlb3);
	jpn.add(d1);
	jpn.add(jlb4);
	jpn.add(jlb3);

	jpn.add(d);
	jpn.add(jlb2);
	jpn.add(jlb);
	jpn.add(btnGo);
	jpn.add(btnRecord);
	jpn.add(btnStop);
	jpn.add(btnExit);
	cp.add(jpn, BorderLayout.NORTH);
	cp.add(jsp, BorderLayout.CENTER);
	btnGo.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			t1.start();
		}
	});
	btnStop.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			t1.stop();
		}
	});
	btnRecord.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count++;
	jta.append("record"+"("+count+")"+h1+h2+":"+m1+m2+":"+s1+s2+"\n");
		}
	});
	btnExit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mFrm = new MainFrame();
		mFrm.setVisible(true);
	}

}

