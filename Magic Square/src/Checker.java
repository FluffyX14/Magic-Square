public class Checker {
	//initializing variables
	private int size;
	
	public int[][] check = new int[size][size];
	
	//constructor to take in array and size
	public Checker (int s, int[][] ch) {
		size = s;
		check = ch;
	}
	
	//calculates sum of a column
	public int column (int x) {
		int sum = 0;
		for (int y=0; y<size; y++) {
			sum += check [x][y];
        }
		return sum;
	}
	
	//calculates sum of a row
	public int row (int y) {
		int sum = 0;
		for (int x=0; x<size; x++) {
			sum += check [x][y];
	       }
		return sum;
	}
	
	//calculates sum of diagonal (top left to bottom right)
	public int diagonal1() {
		int sum = 0;
		for (int z=0; z<size; z++) {
			sum += check [z][z];
		}
		return sum;
	}
	
	//calculates sum of diagonal (bottom left to top right)
		public int diagonal2() {
			int sum = 0;
			int y = size;
			for (int x=0; x<size; x++) {
				sum += check[x][y-1-x];
			}
			return sum;
		}
	
	public boolean getIfMagicSquare() {
		boolean magicSquare = false; //variable to determine if magic square or not
		//compares diagonal
		if (diagonal1() == diagonal2()) {
			int falseCounter = 0;
			for (int z=0; z<size; z++) {
				if (column(z) == diagonal1() && row(z) == diagonal1()) {
				}
				else {
					falseCounter++;
				}
			}
			if (falseCounter == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	
	
	
}