package TheMain;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main extends JFrame implements KeyListener{
	
	int x = 0, y = 0;
	Container c = new Container();
	int BoundX = 1300, BoundY = 700;
	int change = 5;
	
	ImageIcon plr = new ImageIcon("H:\\Project Work 1\\Project_1\\ProjectWork1\\TheMain\\Player.png");
	private JLabel player = new JLabel();
	ImageIcon Bc = new ImageIcon("H:\\Project Work 1\\Project_1\\ProjectWork1\\TheMain\\MainMenu.png");
	private JLabel background = new JLabel();
	
	Main(){
		setBounds(0, 0, BoundX, BoundY);
		setVisible(true);
		setTitle("Arnab's Game");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		
		//setLocationRelativeTo(null);
		
		initPaint();
	}
	
	public void initPaint() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.red);
		
		player.setBounds(0, 0, 100, 200);
		player.setIcon(plr);
		player.setVisible(true);
		c.add(player);
		
		background.setBounds(0, 0, 1300, 700);
		background.setIcon(Bc);
		background.setVisible(true);
		c.add(background);
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
	    }
	    
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A) {
			if(x>0)
				x = x-change;
				
		}
		else if(key == KeyEvent.VK_D) {
			if(x<(BoundX-115))
			x = x+change;
		}
		else if(key == KeyEvent.VK_W) {
			if(y>0)
			y = y-change;
		}
		else if(key == KeyEvent.VK_S) {
			if(y<(BoundY-240))
			y = y+change;
		}
		Refresh();
	}

	public void keyReleased(KeyEvent e) {
	    }


	public void Refresh() {
		
		player.setBounds(x, y, 100, 200);
		repaint();
	}
	
	public static void main(String[] args) {
		Main frm = new Main();
		
		System.out.print("Hello World");
	}	
}
