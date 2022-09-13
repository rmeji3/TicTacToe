/*	Program Name:	TicTacToe.java
	Programmer:		Rafael Mejia
	Date:			5/2/22

	This is the Tic Tac Toe game thing.	*/

// import statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe{
	public static void main(String args[]){
		TicTacToe game = new TicTacToe();
		game.display();
	}

	// instance data
	private JFrame rpsFrame;
	private JPanel buttonsPanel;
	private JPanel top;
	private JPanel gamePlayPanel;
	private JPanel gamePanel;

	// labels
	private JLabel[] resultsLabels;
	private JLabel playerLabel = new JLabel("Lets Play Tic-Tac-Toe!!", SwingConstants.CENTER);

	// buttons
	private JButton[] rpsButtons;
	private int[] checkWin = new int[]{2,2,2,2,2,2,2,2,2};

	// images for the buttons
	private ImageIcon[] icons = new ImageIcon[9];

	// String game play return`
	private String resultsString;

	// counting variables
	private int userWins = 0, computerWins = 0, ties = 0;
	private int timesPressed = 0;

	// constructor for the GUI
	public TicTacToe(){
		// create the images for the buttons
		icons[0] = new ImageIcon("x.JPG");
		icons[1] = new ImageIcon("o.JPG");
		// create the buttons
		rpsButtons = new JButton[9];
		// put images on the buttons
		for(int i = 0; i < rpsButtons.length; i++){
			// create the button
			rpsButtons[i] = new JButton("");
			rpsButtons[i].setBackground(Color.white);
			rpsButtons[i].addActionListener(new ButtonListener());
		}

		// build our panels
		// top panel
		resultsLabels = new JLabel[3];
		top = new JPanel();
		top.setLayout(new GridLayout(2, 1));
		top.setBackground(Color.green);
		// results labels
		for(int i = 0; i < resultsLabels.length; i++){
			resultsLabels[i] = new JLabel(" ", SwingConstants.CENTER);
		}
		// add everything to the top panel
		playerLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		top.add(playerLabel);
		top.add(resultsLabels[0]);
		// buttons panel
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(4, 3));
		// add allthe buttons to the buttons panel
		for(int i = 0; i < rpsButtons.length; i++){
			buttonsPanel.add(rpsButtons[i]);
		}

		// game panel
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(top, BorderLayout.NORTH);
		gamePanel.add(buttonsPanel, BorderLayout.CENTER);

		// set up the frame
		rpsFrame = new JFrame("Rock, Paper, Scissors - Rafael Mejia");
		rpsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpsFrame.setPreferredSize(new Dimension(500, 300));

		// add the panel to the frame
		rpsFrame.add(gamePanel);
	}

	// display method
	public void display(){
		rpsFrame.pack();
		rpsFrame.show();
	}

	// resize the button images
	private static Icon reSizeIcon(ImageIcon icon, int newWidth, int newHeight){
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);

		return new ImageIcon(resizedImage);
	}




	// button listener
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// figure out which button has been pressed
			Object source = e.getSource();
			timesPressed++;
			String resultsString = "";

			for(int i = 0; i < rpsButtons.length; i++){
				if((timesPressed % 2) != 0 && source.equals(rpsButtons[i])){
					rpsButtons[i].setIcon(reSizeIcon(icons[0], 200, 200));
					((JButton)source).removeActionListener(this);
					checkWin[i] = 0;
				}else if(((timesPressed % 2) == 0)&& source.equals(rpsButtons[i])){
					rpsButtons[i].setIcon(reSizeIcon(icons[1], 150, 150));
					((JButton)source).removeActionListener(this);
					checkWin[i] = 1;
				}

			}

			if(timesPressed >= 5){
				resultsString = Winner(checkWin);
			}
			if(resultsString.equals("oWin") || resultsString.equals("xWin")){
				rpsButtons[0].setEnabled(false);
				rpsButtons[1].setEnabled(false);
				rpsButtons[2].setEnabled(false);
				rpsButtons[3].setEnabled(false);
				rpsButtons[4].setEnabled(false);
				rpsButtons[5].setEnabled(false);
				rpsButtons[6].setEnabled(false);
				rpsButtons[7].setEnabled(false);
				rpsButtons[8].setEnabled(false);

			}
			System.out.println(resultsString);

			// changing the label to the winner
			if(resultsString.equals("xWin")){
				playerLabel.setText("mid like matu Win!!!!");
			}else if(resultsString.equals("oWin")){
				playerLabel.setText(" fwanny Win!!!!");
			}else if(resultsString.equals("draw")){
				playerLabel.setText("It's A Draw!!");
			}

			// testing

			// count wins, losses, and ties
			if(resultsString.contains("WIN")){
				userWins++;
				resultsLabels[0].setText("" + userWins);
			}else if(resultsString.contains("LOSE")){
				computerWins++;
				resultsLabels[1].setText("" + computerWins);
			}else{
				ties++;
				resultsLabels[2].setText("" + ties);
			}
		}
	}

	// check for win
	private static String Winner(int checkWin[]){
		if(checkWin[0] == checkWin[1] && checkWin[1] == checkWin[2] && checkWin[0] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[3] == checkWin[4] && checkWin[4] == checkWin[5] && checkWin[3] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[6] == checkWin[7] && checkWin[7] == checkWin[8] && checkWin[6] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[0] == checkWin[3] && checkWin[3] == checkWin[6] && checkWin[0] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[1] == checkWin[4] && checkWin[4] == checkWin[7] && checkWin[1] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[2] == checkWin[5] && checkWin[5] == checkWin[8] && checkWin[2] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[0] == checkWin[4] && checkWin[4] == checkWin[8] && checkWin[0] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[2] == checkWin[4] && checkWin[4] == checkWin[6] && checkWin[2] == 0){
				//xWin = true;
				return "xWin";
			}else if(checkWin[0] == checkWin[1] && checkWin[1] == checkWin[2] && checkWin[0] == 1){ // start of O checking
				//oWin = true;
				return "oWin";
			}else if(checkWin[3] == checkWin[4] && checkWin[4] == checkWin[5] && checkWin[3] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[6] == checkWin[7] && checkWin[7] == checkWin[8] && checkWin[6] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[0] == checkWin[3] && checkWin[3] == checkWin[6] && checkWin[0] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[1] == checkWin[4] && checkWin[4] == checkWin[7] && checkWin[1] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[2] == checkWin[5] && checkWin[5] == checkWin[8] && checkWin[2] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[0] == checkWin[4] && checkWin[4] == checkWin[8] && checkWin[0] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[2] == checkWin[4] && checkWin[4] == checkWin[6] && checkWin[2] == 1){
				//oWin = true;
				return "oWin";
			}else if(checkWin[0] != 2 && checkWin[1] != 2 && checkWin[2] != 2 && checkWin[3] != 2 && checkWin[4] != 2 && checkWin[5] != 2 && checkWin[6] != 2 && checkWin[7] != 2 && checkWin[8] != 2){
				return "draw";
			}else{
				return "keepPlaying";
			}
		}
}








