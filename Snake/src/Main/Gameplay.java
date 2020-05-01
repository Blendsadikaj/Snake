package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import Abstract.AbstractGamePlay;
import Model.User;

/**
 * 
 */

/**
 * @author DEll
 *
 */
public class Gameplay extends AbstractGamePlay implements KeyListener {
	
	private boolean lost = false;	
	private ImageIcon snakeImage;
	private ImageIcon enemyImage;
	private ImageIcon titleImage;
	private User user;
	
	public Gameplay(User user) {
		super(user);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		snake = new Snake(this);
		this.user = user;
	}
	
	@Override
	public void paint(Graphics g) {
		
		if(!start) {
			snake.setSnakexlength(2,50);
			snake.setSnakexlength(1, 75);
			snake.setSnakexlength(0, 100);
			
			snake.setSnakeylength(2, 100);
			snake.setSnakeylength(1, 100);
			snake.setSnakeylength(0, 100);
		}
		
		//title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//border
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//background
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		//draw score
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Time: " + (int)stopwatch.getTime(),780,50);
		
		//draw the length
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Scores: " + score,780,30);
		
		//draw the length
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Username: " + user.getUsername(),50,30);
		
		//draw the length
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Highest Score: " + user.getHighestScore(),50,50);
		
		snake.setRightmouth(new ImageIcon("rightmouth.png"));
		snake.getRightmouth().paintIcon(this, g, snake.getSnakexlength(0), snake.getSnakeylength(0));
		
		for(int i = 0;i<snake.getLengthofsnake();i++) {
			if(i==0 && snake.isRight() ){
				snake.setRightmouth(new ImageIcon("rightmouth.png"));
				snake.getRightmouth().paintIcon(this, g, snake.getSnakexlength(i), snake.getSnakeylength(i));
			}
			if(i==0 && snake.isLeft() ){
				snake.setLeftmouth(new ImageIcon("leftmouth.png"));
				snake.getLeftmouth().paintIcon(this, g, snake.getSnakexlength(i), snake.getSnakeylength(i));
			}
			if(i==0 && snake.isUp()){
				snake.setUpmouth(new ImageIcon("upmouth.png"));
				snake.getUpmouth().paintIcon(this, g, snake.getSnakexlength(i), snake.getSnakeylength(i));
			}
			if(i==0 && snake.isDown()){
				snake.setDownmouth(new ImageIcon("downmouth.png"));
				snake.getDownmouth().paintIcon(this, g, snake.getSnakexlength(i), snake.getSnakeylength(i));
			}
			if(i!=0) {
				snakeImage = new ImageIcon("snakeImage.png");
				snakeImage.paintIcon(this, g, snake.getSnakexlength(i), snake.getSnakeylength(i));
			}
		}
		
		enemyImage = new ImageIcon("enemy.png");
		
		if((enemyxpos[xpos]==snake.getSnakexlength(0)) && enemyypos[ypos] == snake.getSnakeylength(0)) {
			snake.setLengthofsnake(snake.getLengthofsnake()+1);
			generateNewPositionForEnemy();
			score++;
		}
		
		enemyImage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
		for(int i = 1;i<snake.getLengthofsnake();i++) {
			if(snake.getSnakexlength(i) == snake.getSnakexlength(0) && snake.getSnakeylength(i)== snake.getSnakeylength(0)) {
				snake.setLeft(false);
				snake.setRight(false);
				snake.setUp(false);
				snake.setDown(false);
				lost = true;
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("Game Over",300,300);
				
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("Space to RESTART",300,340);
				addToHistory();
				dummyVariable = 0;
				start = false;
			}			
		}		
		g.dispose();
	}	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && lost) {
			score = 0;
			snake.setLengthofsnake(3);
			lost = false;
			repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !lost ) {
			if(!snake.isLeft()) {
				snake.setRight(true);
			}else {
				snake.setRight(false);
				snake.setLeft(true);
			}
			snake.setUp(false);
			snake.setDown(false);
			setStart();
			//repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && !lost && start) {
			if(!snake.isRight()) {
				snake.setLeft(true);
			}else {
				snake.setLeft(false);
				snake.setRight(true);
			}
			snake.setUp(false);
			snake.setDown(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP && !lost ) {
			if(!snake.isDown()) {
				snake.setUp(true);
			}else {
				snake.setUp(false);
				snake.setDown(true);
			}
			snake.setLeft(false);
			snake.setRight(false);
			setStart();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && !lost) {
			if(!snake.isUp()) {
				snake.setDown(true);
			}else {
				snake.setDown(false);
				snake.setUp(true);
			}
			snake.setLeft(false);
			snake.setRight(false);
			setStart();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
