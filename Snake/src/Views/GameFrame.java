package Views;

import java.sql.SQLException;

import javax.swing.JFrame;

import Abstract.AbstractGameFrame;
import Model.User;

public class GameFrame extends AbstractGameFrame {
	
	public GameFrame(User u) throws SQLException
	{
		super(u);
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
	public void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		playButton.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2),200,30);
		showHistory.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2)+50,200,30);
		logout.setBounds(((getBounds().width-200)/2+160),((getBounds().height-40)/2)+140,100,40);
		box.setBounds(((getBounds().width-200)/2)+50,((getBounds().height-30)/2-50),150,30);
		sortBy.setBounds(((getBounds().width-200)/2),((getBounds().height-30)/2-50),100,30);
//		borderLayoutPanel.setBounds(10,10,370,50);
	}

	public void addComponentsToContainer()
	{
		container.add(showHistory);
		container.add(playButton);
		container.add(logout);
		container.add(box);
		container.add(sortBy);
		container.add(borderLayoutPanel);
	} 
	
	public void addActionEvent() {
		showHistory.addActionListener(e -> showHistory());
		playButton.addActionListener(e -> play());
		logout.addActionListener(e -> logout());
		box.addActionListener(e -> updateBestPlayers());
	}

	public void updateBestPlayers() {
		String[][] data = getBestPlayers();
		for(int i = 0;i<data.length;i++) {
			jt.setValueAt(data[i][0], i, 0);
			jt.setValueAt(data[i][1], i, 1);
			jt.setValueAt(data[i][2], i, 2);
		}
	}
	
	
}

