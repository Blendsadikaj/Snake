package Views;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Abstract.AbstractGameFrame;
import Model.User;

public class GameFrame extends AbstractGameFrame {
	
	/**
	 * @param User u
	 * Game frame's game frame
	 */	
	public GameFrame(User u) throws SQLException
	{
		super(u);
		setMedal();
		setTitle("Game Frame");
		setVisible(true);
		setBounds(10,10,370,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//Calling methods inside constructor.
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}
	
	/**
	 * Sets location and size of the buttons
	 */
	private void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		playButton.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2)+50,200,30);
		showHistory.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2)+100,200,30);
		logout.setBounds(((getBounds().width-200)/2+180),((getBounds().height-40)/2)+150,90,30);
		box.setBounds(((getBounds().width-200)/2)+50,((getBounds().height-30)/2-50),150,30);
		sortBy.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2-50),100,30);
		medals.setBounds(((getBounds().width-200)/2)+90,((getBounds().height-30)/2),200,30);
	}

	/**
	 * Adds the components to pane
	 */
	public void addComponentsToContainer()
	{
		container.add(medals);
		container.add(showHistory);
		container.add(playButton);
		container.add(logout);
		container.add(box);
		container.add(sortBy);
		container.add(borderLayoutPanel);
		
	}
	
	/**
	 * Sets medal if the user is on top 3
	 * of best players
	 */
	private void setMedal() {
		System.out.println("asd");
		for(int i = 0;i<getBestPlayers().length;i++) {
			System.out.println(i);
			if(getBestPlayers()[i][0].equals(loggedUser.getUsername())) {
				switch(i) {
					case 0:
						medals.setIcon(new ImageIcon("gold-medal.png"));
						System.out.println("adssd");
						break;
					case 1:
						medals.setIcon(new ImageIcon("second-place.png"));
						break;
					case 2:
						medals.setIcon(new ImageIcon("third-place.png"));
						break;
				}
			}
		}
	}
	
	/**
	 * Adds the events taken on buttons
	 */
	private void addActionEvent() {
		showHistory.addActionListener(e -> showHistory());
		playButton.addActionListener(e -> play());
		logout.addActionListener(e -> logout());
		box.addActionListener(e -> updateBestPlayers());
	}

	/**
	 * Updates the best players when a game is finished
	 */
	public void updateBestPlayers() {
		String[][] data = getBestPlayers();
		for(int i = 0;i<data.length;i++) {
			jt.setValueAt(data[i][0], i, 0);
			jt.setValueAt(data[i][1], i, 1);
			jt.setValueAt(data[i][2], i, 2);
		}
	}
	
	
}

