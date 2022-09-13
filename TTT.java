import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	public class TTT{
		// create the application and get it running
		public static void main(String args[]){

		}
    private JFrame window = new JFrame("Tic-Tac-Toe");
 	private JButton[] numberButtons;

    private JPanel numberPadPanel;
public TTT(){
numberButtons = new JButton[12];
			for(int i = 0; i < numberButtons.length; i++){
				if(i < 10) // numbers 0 - 9
					numberButtons[i] = new JButton("" + i);
				else if(i == 10) // decimal point
					numberButtons[i] = new JButton(".");
				else // +/- button
					numberButtons[i] = new JButton("+/-");

				// add listener to the button (later)
				numberButtons[i].addActionListener(new ButtonListener());
				// change font on buttons (later)
}}			}

