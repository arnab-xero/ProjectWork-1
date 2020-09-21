package TheMain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.Timer;



public class Main extends JFrame implements KeyListener{

	Container c = new Container();
	int BoundX = 1316, BoundY = 738;
	Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	Toolkit tools = getToolkit();
	Image curImg = tools.getImage("cur.png");
	Image curImg2 = tools.getImage("cur2.png");
	
	int X_Val = 20;
	int Y_Val = 0;
	int Const = 5;
	int side = 0;
	int time = 180;
	int key = -1;
	
	ImageIcon plr = new ImageIcon("player.png");
	ImageIcon plr2 = new ImageIcon("player2.png");
	
	JLabel player = new JLabel();
	JLabel timelabel = new JLabel();
	JLabel lv1e1 = new JLabel();
	
	Font tm = new Font("Calibre", Font.BOLD, 20);
	
	Main(){
		setBounds(0, 0, BoundX, BoundY);
		setVisible(true);
		setTitle("Arnab's Game");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setCursor(tools.createCustomCursor(curImg, new Point(0, 0), "customCursor"));
		
		initPaint();
	}
	
	public void initPaint() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		
		
		MainMenu();
	}
	
	public void MainMenu() {
		c.removeAll();
		
		JButton cont = new JButton();
		cont.setBounds(202, 315, 478, 70);
		cont.setContentAreaFilled(false);
		cont.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		cont.setFocusable(false);
		c.add(cont);	
		cont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level1();
				//CallContinue();
			}
		});	
		
		JButton newgame = new JButton();
		newgame.setBounds(202, 399, 478, 70);
		newgame.setContentAreaFilled(false);
		newgame.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		newgame.setFocusable(false);
		c.add(newgame);	
		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cnfrm = JOptionPane.showConfirmDialog(null, "======================================="
						+ "\n= Are You Sure Want To Start A New Game?      ="
						+ "\n= All Your Previous Progress Will Be Deleted!    ="
						+ "\n=======================================", "Warning!", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(cnfrm==JOptionPane.YES_OPTION)
					Level1();
					//CallNewGame();
				else CallContinue();
			}
		});	
		
		JButton levels = new JButton();
		levels.setBounds(202, 482, 478, 70);
		levels.setContentAreaFilled(false);
		levels.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		levels.setFocusable(false);
		c.add(levels);	
		levels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CallLevels();
			}
		});	
		
		JButton exit = new JButton();
		exit.setBounds(202, 566, 478, 70);
		exit.setContentAreaFilled(false);
		exit.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		exit.setFocusable(false);
		c.add(exit);	
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cnfrm = JOptionPane.showConfirmDialog(null, "Are You Really Want To Exit?", 
						"Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(cnfrm==JOptionPane.YES_OPTION) {
					System.exit(0);
				}		
			}
		});	
		
		ImageIcon bc = new ImageIcon("MainMenu1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		
		repaint();
	}
	
	public void CallContinue() {
		
	}
	public void CallNewGame() {
		
	}
	public void CallLevels() {
		c.removeAll();
		
		JButton lv1 = new JButton();
		lv1.setBounds(20, 235, 300, 255);
		lv1.setContentAreaFilled(false);
		lv1.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		lv1.setFocusable(false);
		c.add(lv1);	
		lv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Level1();
			}
		});	
		JButton lv2 = new JButton();
		lv2.setBounds(370, 350, 300, 235);
		lv2.setContentAreaFilled(false);
		lv2.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		lv2.setFocusable(false);
		c.add(lv2);	
		lv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});	
		JButton lv3 = new JButton();
		lv3.setBounds(680, 480, 300, 215);
		lv3.setContentAreaFilled(false);
		lv3.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		lv3.setFocusable(false);
		c.add(lv3);	
		lv3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});	
		JButton lv4 = new JButton();
		lv4.setBounds(300, 30, 600, 200);
		lv4.setContentAreaFilled(false);
		lv4.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		lv4.setFocusable(false);
		c.add(lv4);	
		lv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		
		JButton back = new JButton();
		back.setBounds(10, 2, 75, 45);
		back.setContentAreaFilled(false);
		back.setCursor(tools.createCustomCursor(curImg2, new Point(0, 0), "customCursor"));
		back.setFocusable(false);
		c.add(back);	
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});
		
		ImageIcon bc = new ImageIcon("Levels1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		repaint();
	}
	
	public void Level1() {
		c.removeAll();
		
		player.setIcon(plr);
		player.setBounds(Y_Val, X_Val, 100, 120);
		c.add(player);
		timelabel.setText("NULL");
		timelabel.setBounds(1200, 104, 200, 100);
		timelabel.setFont(tm);
		timelabel.setVisible(true);
		c.add(timelabel);
		
		Timer t = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				time--;
				if(time>=0)
					timelabel.setText(""+(time / 60)+":"+(time % 60));
			}
		});
		t.start();
		
		ImageIcon bc = new ImageIcon("level1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
	    }
	    
	public void keyPressed(KeyEvent e) {

		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_A) {
			key = 1;
			side = 0;
			
			if(Y_Val<=0) {
				Y_Val =  Y_Val+Const;
			}	
		}
		else if(keycode == KeyEvent.VK_D) {
			key = 2;
			side = 1;
			
			if(Y_Val>=1020) {
				Y_Val = Y_Val-Const;
			}
		}
		else if(keycode == KeyEvent.VK_W) {
			key = 3;
			if(X_Val<=10) {
				X_Val = X_Val+Const;
			}
		}
		else if(keycode == KeyEvent.VK_S) {
			key = 4;
			if(X_Val>=530) {
				X_Val = X_Val-Const;
			}
		}
		System.out.println("Y = "+Y_Val+"-----X = "+X_Val);
		RefreshLv1();
	}

	public void keyReleased(KeyEvent e) {
	    }
	
	public void PhysicLv1() {
		if(key==1) {
			Y_Val = Y_Val-Const;
		}
		else if(key==2) {
			Y_Val = Y_Val+Const;
		}
		else if(key==3) {
			X_Val = X_Val-Const;
		}
		else if(key==4) {
			X_Val = X_Val+Const;
		}
		else {
			
		}
	}
	
	public void RefreshLv1() {
		c.removeAll();
		PhysicLv1();
		
		if(side==1)
			player.setIcon(plr);
		else player.setIcon(plr2);
		
		player.setBounds(Y_Val, X_Val, 100, 120);
		
		c.add(player);
		c.add(timelabel);
		
		ImageIcon bc = new ImageIcon("level1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();
	}
	
	public static void main(String[] args) {
		Main frm = new Main();
		
		System.out.print("Hello World");
	}	
}
