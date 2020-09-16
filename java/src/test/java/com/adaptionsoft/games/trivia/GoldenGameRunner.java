
package com.adaptionsoft.games.trivia;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GoldenGameRunner {

	private static boolean notAWinner;

	public static void run() {
		
		for (int i = 0; i < 50; i++) {
			Game aGame = new Game();
			
			aGame.add("Chet");
			aGame.add("Pat");
			aGame.add("Sue");
			
			Random rand = new Random(i);
			
			do {
				
				aGame.roll(rand.nextInt(5) + 1);
				
				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
				
				
				
			} while (notAWinner);
			
		}
		
	}
}
