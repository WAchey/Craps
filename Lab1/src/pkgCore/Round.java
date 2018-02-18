package pkgCore;

import java.util.Arrays;

public class Round {

	private final int ComeOutScore;
	private eGameResult eGameResult; //The enumerations could have been used incorrectly (This value is not used).
	private int rollCount = 1; //Replaced the linked list with a count for simplicity.
	private int craps[] = {2, 3, 12};
	private int natural[] = {7, 11};

	public Round() {
		Roll comeOut = new Roll();
		Roll newRoll;
		int currentRoll = 0;
		ComeOutScore = comeOut.getScore();

		while(!roundOver(currentRoll)) {
			rollCount++; //Counts the number of rolls
			newRoll = new Roll();
			currentRoll = newRoll.getScore();
		}
		
		//Sets eGameResult
		if(currentRoll == 0) { //The round ended with the come out roll
			switch(ComeOutScore) {
			case 2:
			case 3:
			case 12:
				eGameResult = pkgCore.eGameResult.CRAPS;
				break;
			case 7:
			case 11:
				eGameResult = pkgCore.eGameResult.NATURAL;
				break;
			}
		} else { //The round did not end with the come out roll
			if(currentRoll == 7) {
				eGameResult = pkgCore.eGameResult.SEVEN_OUT;
			} else {
				eGameResult = pkgCore.eGameResult.POINT;
			}
			
		}
	}

	public int RollCount() {
		return rollCount;
	}
	
	public boolean roundOver(int roll) {
		boolean isOver = false;
		if(Arrays.binarySearch(craps, ComeOutScore) + 
				Arrays.binarySearch(natural, ComeOutScore) != -2) 
			isOver = true;
		if(roll == ComeOutScore || roll == 7)
			isOver = true;
		return isOver;
	}

}
