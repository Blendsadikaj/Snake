/**
 * 
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author DEll
 */
public class Snake implements ActionListener {
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private int lengthofsnake = 3;
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private JPanel panel;
	private Timer timer = new Timer(100,this);
	private ImageIcon leftmouth;
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	public Snake(Gameplay panel) {
		timer.start();
		this.panel = panel;
	}
	
	
	/**
	 * actionPerformed method is used to specify the
	 * positions of the body of snake
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(isRight()) {
			for(int r = getLengthofsnake()-1; r>=0;r--) {
				setSnakeylength(r+1, getSnakeylength(r));
			}
			for(int r =getLengthofsnake()-1; r>=0; r--) {
				if(r == 0) {
					setSnakexlength(r, getSnakexlength(r) + 25);
				}else {
					setSnakexlength(r, getSnakexlength(r-1));
				}
				if(getSnakexlength(r) > 850) {
					setSnakexlength(r, 25);
				}
			}
				panel.repaint();
		}
		if(isLeft()) {
			
			for(int r = getLengthofsnake()-1; r>=0;r--) {
				setSnakeylength(r+1, getSnakeylength(r));
			}
			for(int r = getLengthofsnake()-1; r>=0; r--) {
				if(r == 0) {
					setSnakexlength(r, getSnakexlength(r) - 25);
				}else {
					setSnakexlength(r, getSnakexlength(r-1));
				}
				if(getSnakexlength(r) < 25) {
					setSnakexlength(r, 850);
				}
			}
				panel.repaint();
		}
		if(isDown()) {
			
			for(int r = getLengthofsnake()-1; r>=0;r--) {
				setSnakexlength(r+1, getSnakexlength(r));
			}
			for(int r = getLengthofsnake()-1; r>=0; r--) {
				if(r == 0) {
					setSnakeylength(r, getSnakeylength(r)+25);
				}else {
					setSnakeylength(r, getSnakeylength(r-1));
				}
				if(getSnakeylength(r) > 625) {
					setSnakeylength(r, 75);
				}
			}
				panel.repaint();			
		}
		if(isUp()) {
			for(int r = getLengthofsnake()-1; r>=0;r--) {
				setSnakexlength(r+1, getSnakexlength(r));
			}
			for(int r = getLengthofsnake()-1; r>=0; r--) {
				if(r == 0) {
					setSnakeylength(r, getSnakeylength(r)-25);
				}else {
					setSnakeylength(r, getSnakeylength(r-1));
				}
				if(getSnakeylength(r) < 75) {
					setSnakeylength(r, 625);
				}
			}
				panel.repaint();
		}
		
	}
	
	/**
	 * @return the snakexlength
	 */
	public int getSnakexlength(int position) {
		return snakexlength[position];
	}
	/**
	 * @param snakexlength the snakexlength to set
	 */
	public void setSnakexlength(int position, int value) {
		this.snakexlength[position] = value;
	}
	/**
	 * @return the snakeylength
	 */
	public int getSnakeylength(int position) {
		return snakeylength[position];
	}
	/**
	 * @param snakeylength the snakeylength to set
	 */
	public void setSnakeylength(int position, int value) {
		this.snakeylength[position] = value;
	}
	/**
	 * @return the left
	 */
	public boolean isLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public boolean isRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(boolean right) {
		this.right = right;
	}
	/**
	 * @return the up
	 */
	public boolean isUp() {
		return up;
	}
	/**
	 * @param up the up to set
	 */
	public void setUp(boolean up) {
		this.up = up;
	}
	/**
	 * @return the down
	 */
	public boolean isDown() {
		return down;
	}
	/**
	 * @param down the down to set
	 */
	public void setDown(boolean down) {
		this.down = down;
	}
	/**
	 * @return the lengthofsnake
	 */
	public int getLengthofsnake() {
		return lengthofsnake;
	}
	/**
	 * @param lengthofsnake the lengthofsnake to set
	 */
	public void setLengthofsnake(int lengthofsnake) {
		this.lengthofsnake = lengthofsnake;
	}
	/**
	 * @return the leftmouth
	 */
	public ImageIcon getLeftmouth() {
		return leftmouth;
	}
	/**
	 * @param leftmouth the leftmouth to set
	 */
	public void setLeftmouth(ImageIcon leftmouth) {
		this.leftmouth = leftmouth;
	}
	/**
	 * @return the rightmouth
	 */
	public ImageIcon getRightmouth() {
		return rightmouth;
	}
	/**
	 * @param rightmouth the rightmouth to set
	 */
	public void setRightmouth(ImageIcon rightmouth) {
		this.rightmouth = rightmouth;
	}
	/**
	 * @return the upmouth
	 */
	public ImageIcon getUpmouth() {
		return upmouth;
	}
	/**
	 * @param upmouth the upmouth to set
	 */
	public void setUpmouth(ImageIcon upmouth) {
		this.upmouth = upmouth;
	}
	/**
	 * @return the downmouth
	 */
	public ImageIcon getDownmouth() {
		return downmouth;
	}
	/**
	 * @param downmouth the downmouth to set
	 */
	public void setDownmouth(ImageIcon downmouth) {
		this.downmouth = downmouth;
	}
}
