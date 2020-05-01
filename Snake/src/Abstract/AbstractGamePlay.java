/**
 * 
 */
package Abstract;

import java.util.Random;

import javax.swing.JPanel;

import Main.Snake;
import Main.Stopwatch;
import Model.GameHistory;
import Model.User;
import Service.GameHistoryService;
import Views.LoginFrame;

/**
 * @author DEll
 *
 */
public class AbstractGamePlay extends JPanel{
	
	GameHistoryService ghs = new GameHistoryService();
	protected Random random = new Random();
	protected Stopwatch stopwatch = new Stopwatch();
	protected int score = 0;
	protected User user;
	protected Snake snake;
	protected int[] enemyxpos = new int[34];
	protected int[] enemyypos = new int[23];
	protected boolean start = false;
	
	protected int xpos = random.nextInt(34);
	protected int ypos = random.nextInt(23);
	
	protected AbstractGamePlay(User user){
		this.user = user;
		generatePossiblePositions();
	}

	protected int dummyVariable = 0;
	protected void addToHistory() {
		if(dummyVariable == 1) {
			stopwatch.stop();
			GameHistory gh = new GameHistory(this.user,score,(int)stopwatch.elapsed());
			ghs.insert(gh);
			AbstractLoginFrame.gameframe.updateBestPlayers();
		}
	}
	
	protected void generateNewPositionForEnemy() {
		int x = random.nextInt(34);
		int y = random.nextInt(23);
		
		boolean samePlace = false;
		
		for(int i = 0;i<snake.getLengthofsnake();i++) {
			if(snake.getSnakexlength(i) == enemyxpos[x] && snake.getSnakeylength(i) == enemyypos[y]) {
				samePlace = true;
				generateNewPositionForEnemy();
			}
		}
		
		if(!samePlace) {
			xpos = x;
			ypos = y;
		}	
	}
	
	protected void setStart() {
		if(dummyVariable == 0) {
			stopwatch.start();
			start = true;
			dummyVariable++;
		}
	}
	
	protected void generatePossiblePositions() {
		for(int i = 0;i<34;i++) {
			enemyxpos[i] = (i+1)*25;
			if(i<23) {
				enemyypos[i] =(i+3)*25;
			}
		}
	}
	
}
