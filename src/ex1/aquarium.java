package ex1;
/*
 * ¤ô±Ú½c
* Author: 104021047 ªLùÚ¼Ý
*/
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class aquarium extends JFrame {
	private Container cp;
	private ImagePanel jpn = new ImagePanel();
	private JPanel toolPane = new JPanel(new GridLayout(1, 2, 5, 5));
	private JButton jbtnAddFish = new JButton("Add Fish");
	private JButton jbtnExit = new JButton("Exit");
	private JLabel jlb = new JLabel("aa");
	private int imgW, imgH;
	private int fishIndex = 0;
	private ArrayList<Fish> fishList = new ArrayList<Fish>();
	private ArrayList<Thread> threadList = new ArrayList<Thread>();

	public aquarium() {
		imgW = jpn.getImgWidth();
		imgH = jpn.getImgHeight();
		this.setBounds(350, 100, imgW, imgH + 30);
		jpn.setLayout(null);
		toolPane.add(jbtnAddFish);
		toolPane.add(jbtnExit);
		jlb.setBounds(100, 100, 80, 30);
		jbtnAddFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fishList.add(new Fish(imgH, imgW));
				jpn.add(fishList.get(fishList.size() - 1));
				threadList.add(new Thread(fishList.get(fishList.size() - 1)));
				threadList.get(threadList.size() - 1).start();
			}
		});
		jbtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout(3, 3));
		cp.add(jpn, BorderLayout.CENTER);
		cp.add(toolPane, BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.validate();
	}

	public static void main(String args[]) {
		aquarium mFrm = new aquarium();
		mFrm.setVisible(true);
	}
}

class ImagePanel extends JPanel {
private	int imgH;
private	int imgW;
	private BufferedImage image;

	public ImagePanel() {
		try{
			image= ImageIO.read(new File("1887055.jpg"));
		imgW = image.getWidth();
		imgH = image.getHeight();
	}catch(IOException ex){
		javax.swing.JOptionPane.showMessageDialog(this, "IOException:"+ex.toString());
	}}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		
	}

	public int getImgWidth() {

		return imgW;
	}

	public int getImgHeight() {

		return imgH;

	}
}