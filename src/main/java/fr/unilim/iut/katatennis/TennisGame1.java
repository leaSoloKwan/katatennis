package fr.unilim.iut.katatennis;

public class TennisGame1 implements TennisGame {

	private int mScore1 = 0;
	private int mScore2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1Name))
			mScore1 += 1;
		else
			mScore2 += 1;
	}

	public String getScore() {
		String score = "";
		
		
		if (mScore1 == mScore2) {
			score = scoreEgaux();
		} else if (mScore1 >= 4 || mScore2 >= 4) {
			score = scoreSupQuatre();
		} else {
			score = scoreInfQuatre(score);
		}
		return score;
	}

	public String scoreInfQuatre(String score) {
		int tempScore = 0;
		StringBuilder bld=new StringBuilder();
		for (int i = 1; i < 3; i++) {
			if (i == 1)
				tempScore = mScore1;
			else {
				bld.append("-");
				
				tempScore = mScore2;
			}
			switch (tempScore) {
			case 0:
				bld.append("Love");
				
				break;
			case 1:
				bld.append("Fifteen");
				
				break;
			case 2:
				bld.append("Thirty");
				
				break;
			case 3:
				bld.append("Forty");
				
				break;
			default :
				
				break;
			}
			score=bld.toString();
		}
		return score;
	}

	public String scoreSupQuatre() {
		String score;
		int minusResult = mScore1 - mScore2;
		if (minusResult == 1)
			score = "Advantage player1";
		else if (minusResult == -1)
			score = "Advantage player2";
		else if (minusResult >= 2)
			score = "Win for player1";
		else
			score = "Win for player2";
		return score;
	}

	public String scoreEgaux() {
		String score;
		switch (mScore1) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}
		return score;
	}
}