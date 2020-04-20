package breakingballs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class BreakingBalls extends JPanel implements KeyListener, ActionListener{

	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8; // velocidade do jogo 
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	public BreakingBalls() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
	}
	
	 // prenchimento do jogo com pinturas e cores 
	public void paint(Graphics g) {
		
		// add background to the game
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
	
		// drawing map
		map.draw((Graphics2D)g);
		
		
		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692 , 3 );
		g.fillRect(691, 0, 3, 592);
		
		
		// the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball 
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY , 20, 20);
	
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();

		// verifica e incrementa velocidade a bola
		if(play) {
			// verificação de interseção da bola com o player
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				// quando a bola entra em contato com o player
				// volta com valor negativo
				ballYdir = -ballYdir;
				// Verificar quando a bola atinge o player no eixo X
			}
			
			for(int i = 0; i< map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
		    if(ballposX < 0) {
		    	ballXdir = -ballXdir;
		    }
		    if(ballposY < 0) {
		    	ballYdir = -ballYdir;
		    }
		    if(ballposX > 670) {
		    	ballXdir = -ballXdir;
		    }
		}
		
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			// right side 
		if(e.getKeyCode() == KeyEvent.VK_D) {
			// verificando se o player nao irá passar da tela no eixo x para a direita
			if(playerX >= 590) {
				playerX = 590;
			
			}else {
				// incrementa velocidade ao player 
				moveRight();
			}
		}
		
			// left side
		if(e.getKeyCode() == KeyEvent.VK_A) {
			
			// verificando se o player nao irá passar da tela no eixo x para a esquerda 
				
			if(playerX <=5) {
					playerX = 5;
				
				}else {
					// incrementa velocidade ao player 
					moveLeft();
			}
		}
	}
	
	
	// incrementação de up and down não é necessaria ja que o player se move da esquerda a direita
	
	public void moveRight() {
		play = true;
		playerX += 20;
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 20;
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	
}
