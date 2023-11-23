import javax.swing.*;
import BreezySwing.*;

public class Gui extends GBFrame {
	//user chooses size
	JLabel label = addLabel("       Choose Magic Square Size", 1, 3, 1, 1);
	JButton size2 = addButton("2x2", 1, 1, 1, 1);
	JButton size3 = addButton("3x3", 1, 2, 1, 1);
	JButton size4 = addButton("4x4", 1, 3, 1, 1);
	JButton size5 = addButton("5x5", 1, 4, 1, 1);
	JButton size6 = addButton("6x6", 1, 5, 1, 1);
	JButton size7 = addButton("7x7", 1, 6, 1, 1);
	JButton size8 = addButton("8x8", 1, 7, 1, 1);
	JLabel outputLabel = addLabel("Magic Square? / Constant", 9, 1, 1, 1);
	JTextField outputField = addTextField("", 9, 2, 1, 1);
	JButton calculate = addButton("Calculate", 9, 9, 1, 1);
	//initializing variable
	IntegerField [][] array;
	int [][] array2;
	int size;
	boolean error = false;
	
	//hides buttons
	public void buttonClicked(JButton buttonObj) {
		
		
		label.setVisible(false);
		size2.setVisible(false);
		size3.setVisible(false);
		size4.setVisible(false);
		size5.setVisible(false);
		size6.setVisible(false);
		size7.setVisible(false);
		size8.setVisible(false);
		
		//sets size of array
		if (buttonObj == size2) {
			size = 2;
		}
		if (buttonObj == size3) {
			size = 3;
		}
		if (buttonObj == size4) {
			size = 4;
		}
		if (buttonObj == size5) {
			size = 5;
		}
		if (buttonObj == size6) {
			size = 6;
		}
		if (buttonObj == size7) {
			size = 7;
		}
		if (buttonObj == size8) {
			size = 8;
		}
		
		if (buttonObj == calculate) {
			//copies array from integer field to integer
			for (int x=0; x<size; x++) {
				for (int y=0; y<size; y++) {
					//error checking
					if (array[x][y].isValidNumber() && array[x][y].getNumber() >= 0) {
						array2[x][y] = array[x][y].getNumber();
						//initializes Checker class
						Checker Check = new Checker (size, array2);
						//outputs if yes or no
						if (Check.getIfMagicSquare() == true) {
							outputField.setText("It is a magic square with a constant of " + Check.diagonal1());
						}
						else {
							outputField.setText("It is not a magic square");
						}
					}
					//outputs if error
					else {
						messageBox("There is an invalid input");
						error = true;
					}
				}
			}
			if (error == true) {
				outputField.setText(null);
			}
			}
		
		if (buttonObj != calculate) {
			//initializes arrays
			array = new IntegerField[size][size];
			array2 = new int[size][size];
			
			//creates grid of input boxes
			for (int x=0; x<size; x++) {
				for (int y=0; y<size; y++) {
					array[x][y] = addIntegerField(0, x+1, y+1, 1, 1);
				}
			}
		}
	}
		

	
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Magic Square");
		frm.setSize(900, 500);
		frm.setVisible(true);
	}

}
