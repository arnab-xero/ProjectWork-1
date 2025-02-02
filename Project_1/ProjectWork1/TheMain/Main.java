package TheMain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import javax.swing.*;
import javax.swing.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = new Container();
	int BoundX = 1316, BoundY = 738;
	Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	Toolkit tools = getToolkit();
	Image curImg = tools.getImage("cur.png");
	Image curImg2 = tools.getImage("cur2.png");
	
	int highscore = 0;
	int X_Val = 20;
	int Y_Val = 0;
	int Const = 5;
	int side = 0;
	int time = 180;
	int time2 = 99999;
	int key = -1;
	int life = 3;
	int blued = 0;
	int greend = 0;
	int redd = 0;
	int LastLevel = 1;
	int score = 0;
	int levelselect = -1;
	
	boolean pressing = false;
	boolean enemy1killed = false, enemy2killed = false, enemy3killed = false, enemy4killed = false, enemy5killed = false;
	boolean d1 = false, d2 = false, d3 = false;
	
	///////////////////////Level2stuff/////////////////////////////////
	int timel2 = 180;
	int time2l2 = 99999;
	int scorelv2 = 0;
	boolean e1k = false, e2k = false, e3k = false, e4k = false;
	boolean dm1 = false, dm2 = false, dm3 = false;
	boolean es1k = false, es2k = false, es3k = false;
	
	JLabel en1l2 = new JLabel();
	JLabel en2l2 = new JLabel();
	JLabel en3l2 = new JLabel();
	JLabel en4l2 = new JLabel();
	JLabel dm1l2 = new JLabel();
	JLabel dm2l2 = new JLabel();
	JLabel dm3l2 = new JLabel();
	JLabel herol2 = new JLabel();
	JLabel es1 = new JLabel();
	JLabel es2 = new JLabel();
	JLabel es3 = new JLabel();
	///////////////////////////////////////////////////////////////////
	ImageIcon ex1l2 = new ImageIcon("exit1l2.png");
	ImageIcon ex2l2 = new ImageIcon("exit2l2.png");
	ImageIcon plr = new ImageIcon("playerr.png");
	ImageIcon plr2 = new ImageIcon("playerl.png");
	ImageIcon plrlp = new ImageIcon("playerlp.png");
	ImageIcon plrrp = new ImageIcon("playerrp.png");
	ImageIcon enemy = new ImageIcon("enemyl.png");
	ImageIcon enemyr = new ImageIcon("enemyr.png");
	ImageIcon enemy1fk = new ImageIcon("enemy1fk.png");
	ImageIcon enemy1hk = new ImageIcon("enemy1hk.png");
	ImageIcon enemy2live = new ImageIcon("enemy2.png");
	ImageIcon enemy2fk = new ImageIcon("enemy2fk.png");
	ImageIcon enemy1al  = new ImageIcon("enemy1al.png");
	ImageIcon red = new ImageIcon("redo.png");
	ImageIcon green = new ImageIcon("greeno.png");
	ImageIcon blue = new ImageIcon("blueo.png");
	ImageIcon redr = new ImageIcon("redr.png");
	ImageIcon greenr = new ImageIcon("greenr.png");
	ImageIcon bluer = new ImageIcon("bluer.png");
	ImageIcon exit1 = new ImageIcon("exit1.png");
	ImageIcon exit2 = new ImageIcon("exit2.png");
	ImageIcon plrcla = new ImageIcon("playercla.png");
	ImageIcon plrc1 = new ImageIcon("playerc1.png");
	ImageIcon plrc2 = new ImageIcon("playerc2.png");
	ImageIcon plrcra = new ImageIcon("playercra.png");
	ImageIcon plrwr = new ImageIcon("playerwr.png");
	ImageIcon plrwl = new ImageIcon("playerwl.png");
	ImageIcon enemy1ar = new ImageIcon("enemy1ar.png");
	
	JLabel scc = new JLabel();
	JLabel exit = new JLabel();
	JLabel diamond1 = new JLabel();
	JLabel diamond2 = new JLabel();
	JLabel diamond3 = new JLabel();
	JLabel player = new JLabel();
	JLabel timelabel = new JLabel();
	JLabel timelabel2 = new JLabel();
	JLabel lv1e1 = new JLabel();
	JLabel enemy1 = new JLabel();
	JLabel lifelabel = new JLabel();
	JLabel enemy2 = new JLabel();
	JLabel enemy3 = new JLabel();
	JLabel enemy4 = new JLabel();
	JLabel enemy5 = new JLabel();
	JLabel dimond1got = new JLabel();
	JLabel dimond2got = new JLabel();
	JLabel dimond3got = new JLabel();
	JLabel exitlv2 = new JLabel();
	
	
	Font tm = new Font("Calibre", Font.BOLD, 20);
	Font lf = new Font("Calibre", Font.BOLD, 50);
	Font scf = new Font("Calibre", Font.BOLD, 30);
	
	
	
	Main(){
		setBounds(0, 0, BoundX, BoundY);
		setVisible(true);
		setTitle("Arnab's Game");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setCursor(tools.createCustomCursor(curImg, new Point(0, 0), "customCursor"));
		
		initPaint();
		try {
			readHighScore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeHighScore() {

		String text = Integer.toString(score);
		
		try (PrintStream out = new PrintStream(new FileOutputStream("highscore.txt"))) {
			out.print(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readHighScore() throws Exception {
		
		File file = new File("highscore.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st = br.readLine();
		
		highscore = Integer.parseInt(st);
		
		System.out.println(""+highscore);
		
		br.close();
	}
 
	public void initPaint() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		
		
		MainMenu();
		
//////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////

		String snd = "level1music.wav";

		try 
		{	
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}   

//////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
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
				levelselect = 1;
				CallContinue();
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
				
				if(cnfrm==JOptionPane.YES_OPTION) {
					levelselect = 1;
					Level1();
				}
					
				else MainMenu();
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
	
	public void EnemyMusic() {
		
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		String snd = "enemymusic.wav";
		
		try 
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}   
		
		
		//////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////
	}
	
public void DimondMusic() {
		
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		String snd = "dimondmusic.wav";
		
		try 
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}   
		
		
		//////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////
	}

public void DeathMusic() {
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	String snd = "death.wav";
	
	try 
	{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace( );
	}   
	
	
	//////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
}

public void WinMusic() {
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	String snd = "winmusic.wav";
	
	try 
	{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace( );
	}   
	
	
	//////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
}

public void LostMusic() {
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	String snd = "lose.wav";
	
	try 
	{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace( );
	}   
	
	
	//////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
}


	public void timerstartstop(int n) {
		
		Timer t = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				time--;
				RefreshLv1Timer();
				
				if(time>=0)
					timelabel.setText(""+(time / 60)+":"+(time % 60));
			}
		});
		if(n==0) {
			t.stop();
		}
		else t.start();
		
		Timer t2 = new Timer(200, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				time2--;
				RefreshLv1Timer();
			}
		});
		if(n==0) {
			t2.stop();
		}
		else t2.start();
	}
	
	public void CallContinue() {
		if(LastLevel==1) {
			CallNewGame();
		}
		else if(LastLevel==2) {
			Level2();
		}
		else if(LastLevel==3) {
			Level3();
		}
		else if(LastLevel==4) {
			
		}
	}
	public void Level3() {
		c.removeAll();
		
		levelselect = 1;
		
		ImageIcon vis = new ImageIcon("visit.png");
		
		JButton Visit = new JButton();
		Visit.setBounds(600, 300, 90, 80);
		Visit.setIcon(vis);
		c.add(Visit);
		Visit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/arnab-xero"));
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		JButton quit = new JButton();
		quit.setFocusable(false);
		quit.setBounds(280, 540, 200, 60);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});	
		c.add(quit);
		
		ImageIcon bc = new ImageIcon("coming.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();
	}
	public void CallNewGame() {
		life = 3;
		time = 180;
		score = 0;
		Level1();
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
				levelselect = 1;
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
				Level2();
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
					Level3();
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
					Level3();
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
	public void TimerLv2(int n) {

		Timer tl2 = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				timel2--;
				RefreshLv1Timer();
				
				if(timel2>=0)
					timelabel2.setText(""+(timel2 / 60)+":"+(timel2 % 60));
			}
		});
		if(n==0) {
			tl2.stop();
		}
		else tl2.start();
		
		
		Timer t2l2 = new Timer(200, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				time2l2--;
				RefreshLv2Timer();
			}
		});
		if(n==0) {
			t2l2.stop();
		}
		else t2l2.start();
	}
	public void Level2() {
		c.removeAll();
		
		levelselect = 2;
		pressing = false;
		e1k = false;
		e2k = false;
		e3k = false;
		e4k = false;
		dm1 = false;
		dm2 = false;
		dm3 = false;
		time = 180;
		X_Val = 20;
		Y_Val = 0;
		//time2 = 99999;
		life = 3;
		score = 0;
		scorelv2 = 0;
		scc.setText("0000");
		lifelabel.setText(""+life);
		lifelabel.setBounds(1230, 213, 200, 100);
		lifelabel.setFont(lf);
		c.add(lifelabel);
		
		
		timelabel2.setText("NULL");
		timelabel2.setBounds(1200, 104, 200, 100);
		timelabel2.setFont(tm);
		timelabel2.setVisible(true);
		c.add(timelabel2);
		
		TimerLv2(1);
		
		ImageIcon bc = new ImageIcon("level2.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		repaint();
		
	}
	public void CallLv2Failed() {
		c.removeAll();
		
		LostMusic();
		
		TimerLv2(0);
		
		levelselect = -1;
		
		if(highscore<scorelv2) {
			writeHighScore();
		}
		
		System.out.println(""+scorelv2);
		
		JButton quit = new JButton();
		quit.setFocusable(false);
		quit.setBounds(280, 540, 200, 60);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});	
		c.add(quit);
		
		/*JButton next = new JButton();
		next.setFocusable(false);
		next.setBounds(740, 540, 200, 60);
		next.setText("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelselect = 3;
				Level3();
			}
		});	
		c.add(next);*/
		
		JLabel hscore = new JLabel();
		hscore.setText(""+highscore);
		hscore.setBounds(1050, 110, 120, 120);
		hscore.setFont(scf);
		c.add(hscore);
		
		JLabel lifebonus = new JLabel();
		lifebonus.setText("0000");
		lifebonus.setBounds(630, 225, 400, 100);
		lifebonus.setFont(scf);
		c.add(lifebonus);
		
		JLabel enemyscore = new JLabel();
		enemyscore.setBounds(630, 345, 400, 100);
		enemyscore.setText("0000");
		enemyscore.setFont(scf);
		c.add(enemyscore);
		
		JLabel dscore = new JLabel();
		dscore.setBounds(630, 290, 400, 100);
		dscore.setText("0000");
		dscore.setFont(scf);
		c.add(dscore);
		
		JLabel scorelabel = new JLabel();
		scorelabel.setBounds(630, 410, 400, 100);
		scorelabel.setText("0000");
		scorelabel.setFont(scf);
		c.add(scorelabel);
		
		ImageIcon bc = new ImageIcon("faillv2.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();	
	}
	public void CallLv2Win() {
		c.removeAll();
		
		WinMusic();
		
		TimerLv2(0);
		
		levelselect = -1;
		
		if(highscore<scorelv2) {
			writeHighScore();
		}
		
		System.out.println(""+scorelv2);
		
		JLabel hscore = new JLabel();
		hscore.setText(""+highscore);
		hscore.setBounds(1050, 110, 120, 120);
		hscore.setFont(scf);
		c.add(hscore);
		
		JButton quit = new JButton();
		quit.setFocusable(false);
		quit.setBounds(280, 540, 200, 60);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});	
		c.add(quit);
		
		JButton next = new JButton();
		next.setFocusable(false);
		next.setBounds(740, 540, 200, 60);
		next.setText("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelselect = 3;
				Level3();
			}
		});	
		c.add(next);
		
		JLabel lifebonus = new JLabel();
		lifebonus.setText(""+life+"x1000 = "+(life*1000));
		lifebonus.setBounds(630, 225, 400, 100);
		lifebonus.setFont(scf);
		c.add(lifebonus);
		
		JLabel enemyscore = new JLabel();
		enemyscore.setBounds(630, 345, 400, 100);
		enemyscore.setText("4x1000 = 4000");
		enemyscore.setFont(scf);
		c.add(enemyscore);
		
		JLabel dscore = new JLabel();
		dscore.setBounds(630, 290, 400, 100);
		dscore.setText(""+((scorelv2-5000)/1000)+"x1000 = "+((scorelv2-4000)));
		dscore.setFont(scf);
		c.add(dscore);
		
		int scorel = (life*1000)+scorelv2;
		JLabel scorelabel = new JLabel();
		scorelabel.setBounds(630, 410, 400, 100);
		scorelabel.setText("                 "+scorel);
		scorelabel.setFont(scf);
		c.add(scorelabel);
		
		ImageIcon bc = new ImageIcon("winlv2.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();	
	}
	
	public void SetPlayerClimblv2() {
		if(time2l2%2==0) {
			player.setIcon(plrc1);
		}
		else {
			player.setIcon(plrc2);
		}
	}
	
	public void SetPlayerWalklv2() {
		if(time2l2%2==0) {
			if(side==1) {
				player.setIcon(plr);
			}
			else {
				player.setIcon(plr2);
			}
		}
		else {
			if(side==1) {
				player.setIcon(plrwr);
			}
			else {
				player.setIcon(plrwl);
			}
		}
	}
	public void RefreshLv2Timer() {
		
		if(time2l2%2==0) {
			dm1l2.setIcon(greenr);
			dm2l2.setIcon(red);
			dm3l2.setIcon(bluer);
			
			/*en1l2.setBounds(280, 150, 120, 120);
			en2l2.setBounds(300, 527, 120, 120);
			en3l2.setBounds(750, 45, 120, 120);
			en4l2.setBounds(710, 527, 120, 120);*/
			
			if(e1k==false) {
				if(Y_Val>=220 && Y_Val<=345 && X_Val>=135 && X_Val<225) {
					en1l2.setBounds(240, 150, 120, 120);
					en1l2.setIcon(enemy1al);
				}
				else {
					en1l2.setIcon(enemyr);
				}
			}
			else {
				en1l2.setIcon(enemy1fk);
			}
			if(e2k==false) {
				if(Y_Val>=240 && Y_Val<=360 && X_Val>=490 && X_Val<540) {
					en2l2.setBounds(260, 527, 120, 120);
					en2l2.setIcon(enemy1al);
				}
				else {
					en2l2.setIcon(enemyr);
				}
			}
			else {
				en2l2.setIcon(enemy1fk);
			}
			if(e3k==false) {
				if(Y_Val>=680 && Y_Val<=775 && X_Val>=30 && X_Val<=110) {
					en3l2.setBounds(710, 45, 120, 120);
					en3l2.setIcon(enemy1al);
				}
				else {
					en3l2.setIcon(enemyr);
				}
			}
			else {
				en3l2.setIcon(enemy1fk);
			}
			if(e4k==false) {
				if(Y_Val>=645 && Y_Val<=775 && X_Val>=505 && X_Val<540) {
					en4l2.setBounds(670, 527, 120, 120);
					en4l2.setIcon(enemy1al);
				}
				else {
					en4l2.setIcon(enemyr);
				}
			}
			else {
				en4l2.setIcon(enemy1fk);
			}
		}
		///////////////////////////////////
		else {
			dm1l2.setIcon(green);
			dm2l2.setIcon(redr);
			dm3l2.setIcon(blue);
			if(e1k==false) {
				en1l2.setBounds(280, 150, 120, 120);
				en1l2.setIcon(enemy);
			}
			else {
				en1l2.setIcon(enemy1fk);
			}
			if(e2k==false) {
				en2l2.setBounds(300, 527, 120, 120);
				en2l2.setIcon(enemy);
			}
			else {
				en2l2.setIcon(enemy1fk);
			}
			if(e3k==false) {
				en3l2.setBounds(750, 45, 120, 120);
				en3l2.setIcon(enemy);
			}
			else {
				en3l2.setIcon(enemy1fk);
			}
			if(e4k==false) {
				en4l2.setBounds(710, 527, 120, 120);
				en4l2.setIcon(enemy);
			}
			else {
				en4l2.setIcon(enemy1fk);
			}	
		}
	}
	public void PhysicsLv2() {
		if(key==1) {
			Y_Val = Y_Val-Const;
			
			if(X_Val>85 && Y_Val<540) {
				if(Y_Val<135) {
					Y_Val = Y_Val+Const;
				}
			}
			if(X_Val>=0 && X_Val<=490) {
				if(Y_Val<590 && Y_Val>465) {
					Y_Val = Y_Val+Const;
				}
			}
			if(X_Val>=45 && X_Val<=270) {
				if(Y_Val<890 && Y_Val>790) {
					Y_Val = Y_Val+Const;
				}
			}
			
		}
		else if(key==2) {
			Y_Val = Y_Val+Const;
			if(X_Val>=0 && X_Val<=130) {
				if(Y_Val>240 && Y_Val<=515) {
					Y_Val = Y_Val-Const;
				}
			}
			if(X_Val>=0 && X_Val<=150) {
				if(Y_Val>375 && Y_Val<=515) {
					Y_Val = Y_Val-Const;
				}
			}
			if(X_Val>150 && X_Val<490) {
				if(Y_Val>235 && Y_Val<515) {
					Y_Val = Y_Val-Const;
				}
			}
			if(X_Val>50 && X_Val<495) {
				if(Y_Val>680 && Y_Val<785) {
					Y_Val = Y_Val-Const;
				}
			}
			if(X_Val>=495 && X_Val<540) {
				if(Y_Val>820 && Y_Val<950) {
					Y_Val = Y_Val-Const;
				}
			}
			
		}
		else if(key==3) {
			X_Val = X_Val-Const;
			
			if(Y_Val>=250 && Y_Val<=515) {
				if(X_Val<=130) {
					X_Val = X_Val+Const;
				}
			}
			if(Y_Val>=235 && Y_Val<=585) {
				if(X_Val<490 && X_Val>280) {
					X_Val = X_Val+Const;
				}
			}
			if(Y_Val>=680 && Y_Val<=820) {
				if(X_Val<=495 && X_Val>=350) {
					X_Val = X_Val+Const;
				}
			}
		
		}
		else if(key==4) {
			X_Val = X_Val+Const;
			
			if(Y_Val>=0 && Y_Val<=130) {
				if(X_Val>85) {
					X_Val = X_Val - Const;
				}
			}
			if(Y_Val>=240 && Y_Val<=515) {
				if(X_Val>150 && X_Val<360) {
					X_Val = X_Val-Const;
				}
			}
			if(Y_Val>685 && Y_Val<890) {
				if(X_Val>45 && X_Val<220) {
					X_Val = X_Val-Const;
				}
			}
			if(Y_Val>=890 && Y_Val<=1025) {
				if(X_Val>=270 && X_Val<=400) {
					X_Val = X_Val-Const;
				}
			}
			
		}
	}
	public void RefreshLv2() {		
		c.removeAll();
		PhysicsLv2();
		
		if(dm1==true && dm2==true && dm3==true && life>=0 && timel2>=0 && X_Val>=200 && X_Val<=265 && Y_Val>=990 && Y_Val<=1030) {
			CallLv2Win();
		}
		else if(life<0 || timel2<0) {
			CallLv2Failed();
		}
		player.setIcon(plr);
		player.setBounds(Y_Val, X_Val, 100, 120);
		
		if(dm1==true && dm2==true && dm3==true) {
			exitlv2.setIcon(ex2l2);
		}
		else {
			exitlv2.setIcon(ex1l2);
		}
		
		exitlv2.setBounds(1020, 280, 80, 80);
		c.add(exitlv2);
		
		/////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		
		if(Y_Val>=105 && Y_Val<=215 && X_Val>=70 && X_Val<95 && es1k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			es1k = true;
		}
		if(Y_Val>115 && Y_Val<210 && X_Val>=0 && X_Val<120 && es1k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(Y_Val>=420 && Y_Val<=540 && X_Val>510 && X_Val<=600 && es2k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			es2k = true;
		}
		if(Y_Val>435 && Y_Val<535 && X_Val>=470 && X_Val<600 && es2k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(Y_Val>=870 && Y_Val<=1030 && X_Val>=0 && X_Val<=60 && es3k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			es3k = true;
		}
		if(Y_Val>875 && Y_Val<1030 && X_Val>=0 && X_Val<60 && es3k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		////////////////////////////////////////////////////////////////////////////////////////
		if(es1k==false) {
			es1.setIcon(enemy2live);
		}
		else {
			es1.setIcon(enemy2fk);
		}
		if(es2k==false) {
			es2.setIcon(enemy2live);
		}
		else {
			es2.setIcon(enemy2fk);
		}
		if(es3k==false) {
			es3.setIcon(enemy2live);
		}
		else {
			es3.setIcon(enemy2fk);
		}
		
		es1.setBounds(170, 60, 120, 120);
		es2.setBounds(480, 500, 120, 120);
		es3.setBounds(930, 30, 120, 120);
		
		c.add(es1);
		c.add(es2);
		c.add(es3);
		
		/////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
	
		if(Y_Val>=220 && Y_Val<=345 && X_Val>=135 && X_Val<225 && e1k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			e1k = true;
		}
		if(Y_Val>230 && Y_Val<335 && X_Val>=135 && X_Val<225 && e1k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(Y_Val>=240 && Y_Val<=360 && X_Val>=490 && X_Val<540 && e2k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			e2k = true;
		}
		if(Y_Val>=250 && Y_Val<=350 && X_Val>=490 && X_Val<540 && e2k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(Y_Val>=680 && Y_Val<=775 && X_Val>=30 && X_Val<=110 && e3k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			e3k = true;
		}
		if(Y_Val>=690 && Y_Val<=785 && X_Val>=30 && X_Val<=110 && e3k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(Y_Val>=645 && Y_Val<=775 && X_Val>=505 && X_Val<540 && e4k==false && pressing==true) {
			EnemyMusic();
			scorelv2 = scorelv2+1000;
			e4k = true;
		}
		if(Y_Val>=655 && Y_Val<=765  && X_Val>=505 && X_Val<540 && e4k==false && pressing==false) {
			DeathMusic();
			life = life-1;
			X_Val = 20;
			Y_Val = 0;
		}
		
		if(key<5) {
			if(side==0) {
				if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
					SetPlayerWalklv2();
				}
				else {
					SetPlayerClimblv2();
				}
			}
			else if(side==1) {
				if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
					SetPlayerWalklv2();
				}
				else {
					SetPlayerClimblv2();
				}
			}
		}
		else if(key==5) {
			if(side==0) {
				if(pressing==true) {
					if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
						player.setIcon(plrlp);
					}
					else {
						player.setIcon(plrcla);
					}
				}
				else if(pressing==false) {
					if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
						SetPlayerWalklv2();
					}
					else {
						SetPlayerClimblv2();
					}
				}
			}
			else if(side==1) {
				if(pressing==true) {
					if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
						player.setIcon(plrrp);
					}
					else {
						player.setIcon(plrcra);
					}
				}
				else if(pressing==false) {
					if((X_Val>=80 && X_Val<=85 && Y_Val>=0 && Y_Val<=90) || (Y_Val>=280 && Y_Val<=375 && X_Val>=145 && X_Val<=150) || (Y_Val>=135 && Y_Val<=820 && X_Val>=525 && X_Val<=530) || (Y_Val>=710 && Y_Val<=845 && X_Val>=40 && X_Val<=45) || (Y_Val>=890 && Y_Val<=1020 && X_Val>=260 && X_Val<=265)) {
						SetPlayerWalklv2();
					}
					else {
						SetPlayerClimblv2();
					}
				}
			}
		}			
		
		c.add(player);
		
		en1l2.setBounds(280, 150, 120, 120);
		en2l2.setBounds(300, 527, 120, 120);
		en3l2.setBounds(750, 45, 120, 120);
		en4l2.setBounds(710, 527, 120, 120);
		dm1l2.setBounds(365, 170, 120, 120);
		dm2l2.setBounds(800, 545, 120, 120);
		dm3l2.setBounds(900, 280, 120, 120);
		if(dm1==true) {
			dimond1got.setText("1");
		}
		else {
			dimond1got.setText("0");
		}
		if(dm2==true) {
			dimond2got.setText("1");
		}
		else {
			dimond2got.setText("0");
		}
		if(dm3==true) {
			dimond3got.setText("1");
		}
		else {
			dimond3got.setText("0");
		}
		
		dimond1got.setFont(lf);
		dimond2got.setFont(lf);
		dimond3got.setFont(lf);
		dimond3got.setBounds(1235, 365, 50, 50);
		dimond2got.setBounds(1235, 485, 50, 50);
		dimond1got.setBounds(1235, 605, 50, 50);
		
		if(Y_Val>=325  && Y_Val<=380  && X_Val>=130  && X_Val<=155 && dm1==false) {
			DimondMusic();
			scorelv2 = scorelv2+1000;
			dm1 = true;
		}
		if(Y_Val>=755  && Y_Val<=825  && X_Val>=500  && X_Val<=540 && dm2==false) {
			DimondMusic();
			scorelv2 = scorelv2+1000;
			dm2 = true;
		}
		if(Y_Val>=890  && Y_Val<=950  && X_Val>=215  && X_Val<=270 && dm3==false) {
			DimondMusic();
			scorelv2 = scorelv2+1000;
			dm3 = true;
		}
		if(dm1==false) {
			c.add(dm1l2);
		}
		else {
			c.remove(dm1l2);
		}
		if(dm2==false) {
			c.add(dm2l2);
		}
		else {
			c.remove(dm2l2);
		}
		if(dm3==false) {
			c.add(dm3l2);
		}
		else {
			c.remove(dm3l2);
		}
		
		scc.setBounds(1160, 55, 300, 70);
		scc.setFont(scf);
		scc.setText(""+scorelv2);
		
		lifelabel.setText(""+life);
		
		c.add(lifelabel);		
		c.add(scc);
		c.add(dimond1got);
		c.add(dimond2got);
		c.add(dimond3got);
		c.add(en1l2);
		c.add(en2l2);
		c.add(en3l2);
		c.add(en4l2);
		c.add(timelabel2);
		
		ImageIcon bc = new ImageIcon("level2.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		repaint();
	}

	public void Level1() {
			c.removeAll();
			
			levelselect = 1;
			pressing = false;
			enemy1killed = false;
			enemy2killed = false;
			enemy3killed = false;
			enemy4killed = false;
			enemy5killed = false;
			d1 = false;
			d2 = false;
			d3 = false;
			life = 3;
			score = 0;
			time = 180;
			X_Val = 20;
			Y_Val = 0;
			
			time = 180;
			time2 = 99999;
			timerstartstop(1);
			player.setIcon(plr);
			player.setBounds(Y_Val, X_Val, 100, 120);
			c.add(player);
			timelabel.setText("NULL");
			timelabel.setBounds(1200, 104, 200, 100);
			timelabel.setFont(tm);
			timelabel.setVisible(true);
			c.add(timelabel);
			lifelabel.setText(""+life);
			lifelabel.setBounds(1230, 213, 200, 100);
			lifelabel.setFont(lf);
			c.add(lifelabel);
			
			/*time2 = 9999;
			
			Timer t2 = new Timer(200, new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					time2--;
					RefreshLv1Timer();
				}
			});
			t2.start();
			
			Timer t = new Timer(1000, new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					time--;
					RefreshLv1Timer();
					
					if(time>=0)
						timelabel.setText(""+(time / 60)+":"+(time % 60));
				}
			});
			t.start();*/
			
			ImageIcon bc = new ImageIcon("level1.png");
			JLabel mm = new JLabel();
			mm.setBounds(0, 0, 1300, 700);
			mm.setIcon(bc);
			mm.setVisible(true);
			c.add(mm);
			repaint();
			
			RefreshLv1();		
	}
	
	public void keyTyped(KeyEvent e) {
	    }
	    
	public void keyPressed(KeyEvent e) {

		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
			key = 1;
			side = 0;
			
			if(Y_Val<=0) {
				Y_Val =  Y_Val+Const;
			}	
		}
		else if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
			key = 2;
			side = 1;
			
			if(Y_Val>=1020) {
				Y_Val = Y_Val-Const;
			}
		}
		else if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP)  {
			key = 3;
			if(X_Val<=10) {
				X_Val = X_Val+Const;
			}
		}
		else if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
			key = 4;
			if(X_Val>=530) {
				X_Val = X_Val-Const;
			}
		}
		else if(keycode == KeyEvent.VK_Q || keycode == KeyEvent.VK_SPACE) {
			key = 5;
			pressing = true;
			System.out.println("Q = "+key);
			
			/////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////
			String snd = "punchmusic.wav";
			
			try 
			{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(snd).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch(Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace( );
			}   
			
			
			//////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////
		}
		System.out.println("Y = "+Y_Val+"-----X = "+X_Val);
		if(levelselect==1) {
			RefreshLv1();
		}
		else if(levelselect==2) {
			RefreshLv2();
		}
	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_Q || keycode == KeyEvent.VK_SPACE) {
			key = 5;
			pressing = false;
			if(levelselect==1) {
				RefreshLv1();
			}
			else if(levelselect==2) {
				RefreshLv2();
			}
		}
	}
	
	public void CallLv1Failed() {
		c.removeAll();
		
		LostMusic();

		TimerLv2(0);
		
		levelselect = -1;
		
		if(highscore<scorelv2) {
			writeHighScore();
		}
		
		System.out.println(""+scorelv2);
		
		JButton quit = new JButton();
		quit.setFocusable(false);
		quit.setBounds(280, 540, 200, 60);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});	
		c.add(quit);
		
		/*JButton next = new JButton();
		next.setFocusable(false);
		next.setBounds(740, 540, 200, 60);
		next.setText("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelselect = 3;
				Level3();
			}
		});	
		c.add(next);*/
		
		JLabel hscore = new JLabel();
		hscore.setText(""+highscore);
		hscore.setBounds(1050, 110, 120, 120);
		hscore.setFont(scf);
		c.add(hscore);
		
		JLabel lifebonus = new JLabel();
		lifebonus.setText("0000");
		lifebonus.setBounds(630, 225, 400, 100);
		lifebonus.setFont(scf);
		c.add(lifebonus);
		
		JLabel enemyscore = new JLabel();
		enemyscore.setBounds(630, 345, 400, 100);
		enemyscore.setText("0000");
		enemyscore.setFont(scf);
		c.add(enemyscore);
		
		JLabel dscore = new JLabel();
		dscore.setBounds(630, 290, 400, 100);
		dscore.setText("0000");
		dscore.setFont(scf);
		c.add(dscore);
		
		JLabel scorelabel = new JLabel();
		scorelabel.setBounds(630, 410, 400, 100);
		scorelabel.setText("0000");
		scorelabel.setFont(scf);
		c.add(scorelabel);
		
		ImageIcon bc = new ImageIcon("faillv1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();	
	}
	public void CallLv1Win() {
		c.removeAll();
		
		WinMusic();

		timerstartstop(0);
		
		levelselect = -1;
		
		if(highscore<score) {
			writeHighScore();
		}
		
		System.out.println(""+score);
		
		JLabel hscore = new JLabel();
		System.out.println("New High Score Written = "+highscore);
		hscore.setText(""+highscore);
		hscore.setBounds(1050, 110, 120, 120);
		hscore.setFont(scf);
		c.add(hscore);
		
		JButton quit = new JButton();
		quit.setFocusable(false);
		quit.setBounds(280, 540, 200, 60);
		quit.setText("QUIT");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu();
			}
		});	
		c.add(quit);
		
		JButton next = new JButton();
		next.setFocusable(false);
		next.setBounds(740, 540, 200, 60);
		next.setText("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelselect = 2;
				Level2();
			}
		});	
		c.add(next);
		
		JLabel lifebonus = new JLabel();
		lifebonus.setText(""+life+"x1000 = "+(life*1000));
		lifebonus.setBounds(630, 225, 400, 100);
		lifebonus.setFont(scf);
		c.add(lifebonus);
		
		JLabel enemyscore = new JLabel();
		enemyscore.setBounds(630, 345, 400, 100);
		enemyscore.setText("5x1000 = 5000");
		enemyscore.setFont(scf);
		c.add(enemyscore);
		
		JLabel dscore = new JLabel();
		dscore.setBounds(630, 290, 400, 100);
		dscore.setText(""+((score-5000)/1000)+"x1000 = "+((score-5000)));
		dscore.setFont(scf);
		c.add(dscore);
		
		int scorel = (life*1000)+score;
		JLabel scorelabel = new JLabel();
		scorelabel.setBounds(630, 410, 400, 100);
		scorelabel.setText("                 "+scorel);
		scorelabel.setFont(scf);
		c.add(scorelabel);
		
		ImageIcon bc = new ImageIcon("winlv1.png");
		JLabel mm = new JLabel();
		mm.setBounds(0, 0, 1300, 700);
		mm.setIcon(bc);
		mm.setVisible(true);
		c.add(mm);
		
		repaint();	
		
	}
	public void PhysicLv1() {
		if(key==1) {
			Y_Val = Y_Val-Const;
			
			if(X_Val>25 && X_Val<250) {
				if(Y_Val<815) {
					Y_Val = Y_Val+Const;
				}
			}
		}
		else if(key==2) {
			Y_Val = Y_Val+Const;
			
			if(X_Val>155 && X_Val<=495) {
				if(Y_Val>950) {
					Y_Val = Y_Val-Const;
				}
			}
			if(X_Val>275 && X_Val<490) {
				if(Y_Val>140 && Y_Val<950) {
					Y_Val = Y_Val-Const;
				}
			}
		}
		else if(key==3) {
			X_Val = X_Val-Const;
			
			if(Y_Val>=0 && Y_Val<815) {
				if(X_Val>25 && X_Val<250) {
					X_Val = X_Val+Const;
				}
			}
			if(Y_Val>140 && Y_Val<=1020) {
				if(X_Val<500 && X_Val>270) {
					X_Val = X_Val+Const;
				}
			}
		}
		else if(key==4) {
			X_Val = X_Val+Const;
			
			if(Y_Val>950) {
				if(X_Val>155) {
					if(X_Val<500) {
						X_Val = X_Val-Const;
					}
				}
			}
			if(Y_Val>=0 && Y_Val<815) {
				if(X_Val>25 && X_Val<250) {
					X_Val = X_Val-Const;
				}
			}
			if(Y_Val>140 && Y_Val<=950) {
				if(X_Val>270 && X_Val<495) {
					X_Val = X_Val-Const;
				}
			}
		}
	}
	
	public void RefreshLv1Timer() {
		
		enemy1.setBounds(470, 25, 120, 120);
		enemy3.setBounds(720, 270, 120, 120);
		enemy5.setBounds(160, 525, 120, 120);
		
		if(enemy2killed==false) {
			enemy2.setIcon(enemy2live);
		}
		else {
			enemy2.setIcon(enemy2fk);
		}
		
		if(enemy3killed==true) {
			enemy3.setBounds(720, 290, 120, 120);
		}
		
		if(enemy4killed==false) {
			enemy4.setIcon(enemy2live);
		}
		else {
			enemy4.setIcon(enemy2fk);
		}
		
		if(time2%2==0) {
			if(enemy5killed==false) {
				if(Y_Val>=90 && Y_Val<190 && X_Val>=460 && X_Val<=540) {
					enemy5.setBounds(120, 525, 120, 120);
					enemy5.setIcon(enemy1al);
				}
				else{
					enemy5.setIcon(enemyr);
				}
			}
			else {
				enemy5.setIcon(enemy1fk);
			}
		}
		else {
			if(enemy5killed==false) {		
				enemy5.setIcon(enemy);
			}
			else {
				enemy5.setIcon(enemy1fk);
			}
		}
		
		if(time2%2==0) {
			if(enemy3killed==false) {
				if(Y_Val<800 && X_Val>=240 && X_Val<=280) {
					enemy3.setIcon(enemy1ar);
				}
				else{
					enemy3.setIcon(enemy);
				}
			}
			else {
				enemy3.setIcon(enemy1fk);
			}
		}
		else {
			if(enemy3killed==false) {		
				enemy3.setIcon(enemyr);
			}
			else {
				enemy3.setIcon(enemy1fk);
			}
		}
		
		if(time2%2==0) {
			diamond1.setIcon(green);
			diamond2.setIcon(redr);
			diamond3.setIcon(blue);
			
			if(enemy1killed==false) {
				if(Y_Val>380 && Y_Val<550) {
					enemy1.setBounds(430, 25, 120, 120);
					enemy1.setIcon(enemy1al);
				}
				else {
					enemy1.setIcon(enemyr);
				}
			}
			else {
				enemy1.setBounds(470, 45, 120, 120);
				enemy1.setIcon(enemy1fk);
			}
		}
		else {			
			diamond1.setIcon(greenr);
			diamond2.setIcon(red);
			diamond3.setIcon(bluer);
			
			if(enemy1killed==false) {
				if(Y_Val>380 && Y_Val<550) {
					enemy1.setIcon(enemy);
				}
				else {
					enemy1.setIcon(enemy);
				}
			}
			else {
				enemy1.setBounds(470, 45, 120, 120);
				enemy1.setIcon(enemy1fk);
			}	
		}
	}
	public void SetPlayerClimb() {
		if(time2%2==0) {
			player.setIcon(plrc1);
		}
		else {
			player.setIcon(plrc2);
		}
	}
	
	public void SetPlayerWalk() {
		if(time2%2==0) {
			if(side==1) {
				player.setIcon(plr);
			}
			else {
				player.setIcon(plr2);
			}
		}
		else {
			if(side==1) {
				player.setIcon(plrwr);
			}
			else {
				player.setIcon(plrwl);
			}
		}
	}
	
	public void RefreshLv1() {
		c.removeAll();
		
		if(life>=0 && time>0 && Y_Val>1000 && X_Val>500 && score>=7000) {
			CallLv1Win();
		}
		else if((life<0 || time<0) && score<8000) {
			CallLv1Failed();
		}
		
		PhysicLv1();
		if(d1==true && d2==true && d3==true) {
			exit.setIcon(exit1);
		}
		else {
			exit.setIcon(exit2);
		}
		
		exit.setBounds(770, 500, 400, 150);
		c.add(exit);
		
		if(key<5) {
			if(side==0) {
				if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
					SetPlayerWalk();
				}
				else {
					SetPlayerClimb();
				}
			}
			else if(side==1) {
				if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
					SetPlayerWalk();
				}
				else {
					SetPlayerClimb();
				}
			}
		}
		else if(key==5) {
			if(side==0) {
				if(pressing==true) {
					if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
						player.setIcon(plrlp);
					}
					else {
						player.setIcon(plrcla);
					}
				}
				else if(pressing==false) {
					if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
						SetPlayerWalk();
					}
					else {
						SetPlayerClimb();
					}
				}
			}
			else if(side==1) {
				if(pressing==true) {
					if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
						player.setIcon(plrrp);
					}
					else {
						player.setIcon(plrcra);
					}
				}
				else if(pressing==false) {
					if((X_Val>=20 && X_Val<=25 && Y_Val>=0 && Y_Val<=760) || (Y_Val>=980 && Y_Val<=1030 && X_Val>=150 && X_Val<=155) || (Y_Val>=180 && Y_Val<=960 && X_Val>=265 && X_Val<=270) || (Y_Val>=0 && Y_Val<=1020 && X_Val>=525 && X_Val<=540)) {
						SetPlayerWalk();
					}
					else {
						SetPlayerClimb();
					}
				}
			}
		}

		if(d1==true) {
			dimond1got.setText("1");
		}
		else {
			dimond1got.setText("0");
		}
		if(d2==true) {
			dimond2got.setText("1");
		}
		else {
			dimond2got.setText("0");
		}
		if(d3==true) {
			dimond3got.setText("1");
		}
		else {
			dimond3got.setText("0");
		}
		
		dimond1got.setFont(lf);
		dimond2got.setFont(lf);
		dimond3got.setFont(lf);
		dimond3got.setBounds(1235, 365, 50, 50);
		dimond2got.setBounds(1235, 485, 50, 50);
		dimond1got.setBounds(1235, 605, 50, 50);
		
		scc.setBounds(1160, 55, 300, 70);
		scc.setFont(scf);
		
		enemy2.setBounds(820, 20, 80, 80);
		enemy4.setBounds(400, 270, 80, 80);
		
		diamond1.setBounds(1020, 170, 120, 120);
		diamond2.setBounds(220, 280, 120, 120);
		diamond3.setBounds(530, 550, 120, 120);
		
		if(Y_Val>975 && Y_Val<=1025 && X_Val>110 && X_Val<=160 && d1==false) {
			DimondMusic();
			d1 = true;
			score = score+1000;
		}
		if(Y_Val<280 && Y_Val>175 && X_Val>245 && X_Val<275 && d2==false) {
			DimondMusic();
			d2 = true;
			score = score+1000;
		}
		if(Y_Val>485 && Y_Val<590 && X_Val>490 && X_Val<600 && d3==false) {
			DimondMusic();
			d3 = true;
			score = score+1000;
		}
		scc.setText(""+score);
		
		if(d1==false) c.add(diamond1);
		else c.remove(diamond1);
		if(d2==false) c.add(diamond2);
		else c.remove(diamond2);
		if(d3==false) c.add(diamond3);
		else c.remove(diamond3);

		player.setBounds(Y_Val, X_Val, 100, 120);
		
		if(Y_Val>=410 && enemy1killed==false && pressing==true) {
			EnemyMusic();
			enemy1killed = true;
			score = score+1000;
			scc.setText(""+score);
		}
		
		if(Y_Val>420 && enemy1killed==false && pressing==false) {
			DeathMusic();
			life = life-1;
			lifelabel.setText(""+life);
			Y_Val = 5;
			X_Val = 20;
		}
		
		if(Y_Val>=760 && enemy2killed==false && pressing==true) {
			EnemyMusic();
			enemy2.setIcon(enemy2fk);
			enemy2killed = true;
			score = score+1000;
			scc.setText(""+score);
		}
		if(Y_Val>770 && enemy2killed==false && pressing==false) {
			DeathMusic();
			life = life-1;
			lifelabel.setText(""+life);
			Y_Val = 5;
			X_Val = 20;
		}
		
		
		if(Y_Val>420 && Y_Val<460 &&  X_Val>=240 && X_Val<=280 && enemy4killed==false && pressing==false) {
			DeathMusic();
			life = life-1;
			lifelabel.setText(""+life);
			Y_Val = 5;
			X_Val = 20;
		}
		if(Y_Val>=420 && Y_Val<470 && X_Val>=240 && X_Val<=280 && enemy4killed==false && pressing==true) {
			EnemyMusic();
			enemy4.setIcon(enemy2fk);
			enemy4killed = true;
			score = score+1000;
			scc.setText(""+score);
		}	
		
		if(enemy3killed==false && Y_Val>=680 && Y_Val<=790 && X_Val>=240 && X_Val<=280 && pressing==true) {
			EnemyMusic();
			enemy3killed = true;
			score = score+1000;
			scc.setText(""+score);
		}
		if(enemy3killed==false && X_Val>=240 && X_Val<=280 && Y_Val>690 && Y_Val<780) {
			DeathMusic();
			life = life-1;
			lifelabel.setText(""+life);
			Y_Val = 5;
			X_Val = 20;
		}
		
		if(enemy5killed==false && Y_Val>=90 && Y_Val<190 && X_Val>=460 && X_Val<=540 && pressing==true) {
			EnemyMusic();
			enemy5killed = true;
			score = score+1000;
			scc.setText(""+score);
		}
		if(enemy5killed==false && Y_Val>100 && Y_Val<190 && X_Val>=460 && X_Val<=540) {
			DeathMusic();
			life = life-1;
			lifelabel.setText(""+life);
			Y_Val = 5;
			X_Val = 20;
		}
		
		c.add(dimond1got);
		c.add(dimond2got);
		c.add(dimond3got);
		c.add(enemy5);
		c.add(enemy4);
		c.add(enemy3);
		c.add(enemy2);
		c.add(scc);
		c.add(enemy1);
		c.add(lifelabel);
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
		new Main();
		
		System.out.print("Hello World");
	}	
}
