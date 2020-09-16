package com.adaptionsoft.games.uglytrivia;

public class Game {

	private static final String THEY_ARE_PLAYER_NUMBER = "They are player number ";
	private static final String WAS_ADDED = " was added";
	private static final String THEY_HAVE_ROLLED_A = "They have rolled a ";
	private static final String IS_THE_CURRENT_PLAYER = " is the current player";
	private static final String IS_NOT_GETTING_OUT_OF_THE_PENALTY_BOX = " is not getting out of the penalty box";
	private static final String IS_GETTING_OUT_OF_THE_PENALTY_BOX = " is getting out of the penalty box";
	private static final String WAS_SENT_TO_THE_PENALTY_BOX = " was sent to the penalty box";
	private static final String QUESTION_WAS_INCORRECTLY_ANSWERED = "Question was incorrectly answered";
	private static final String ANSWER_WAS_CORRENT = "Answer was corrent!!!!";
	private static final String ANSWER_WAS_CORRECT = "Answer was correct!!!!";

	private final Players players;
	private final QuestionHandler questionHandler;

	private boolean isGettingOutOfPenaltyBox;

	public Game() {
		players = Players.getInstance();
		questionHandler = QuestionHandler.getInstance();
		questionHandler.initQuestions();
	}

	public void add(String playerName) {

		Player player = new Player(playerName);
		players.add(player);

		System.out.println(playerName + WAS_ADDED);
		System.out.println(THEY_ARE_PLAYER_NUMBER + players.total());
	}

	public void roll(int roll) {
		printCurrentPlayerInfos(roll);

		if (players.currentPlayer().isInPenaltyBox()) {
			if (isRollMultiplierOfTwo(roll)) {
				playerStaysInPenaltyBox();
				return;
			}
			playerGetOutOfPenaltyBox();
		}

		players.currentPlayer().newLocation(roll);
		questionHandler.getQuestionCategory(players.currentPlayer().getPlace());
		questionHandler.askQuestion(players.currentPlayer().getPlace());
	}

	private boolean isRollMultiplierOfTwo(int roll) {
		return roll % 2 == 0;
	}

	public boolean wasCorrectlyAnswered() {
		boolean result = true;
		if (players.currentPlayer().isInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				System.out.println(ANSWER_WAS_CORRECT);
				result = checkForWinner();
			}
		} else {
			System.out.println(ANSWER_WAS_CORRENT);
			result = checkForWinner();
		}

		players.nextPlayer();
		return result;
	}

	private boolean checkForWinner() {
		players.currentPlayer().incrementCoins();
		return players.currentPlayer().getCoins() != 6;
	}

	public boolean wrongAnswer() {
		printWrongAnswerMessage();
		players.currentPlayer().setInPenaltyBox(true);
		players.nextPlayer();
		return true;
	}

	private void printCurrentPlayerInfos(int roll) {
		System.out.println(players.currentPlayer().getName() + IS_THE_CURRENT_PLAYER);
		System.out.println(THEY_HAVE_ROLLED_A + roll);
	}

	private void playerStaysInPenaltyBox() {
		System.out.println(players.currentPlayer().getName() + IS_NOT_GETTING_OUT_OF_THE_PENALTY_BOX);
		isGettingOutOfPenaltyBox = false;
	}

	private void playerGetOutOfPenaltyBox() {
		isGettingOutOfPenaltyBox = true;
		System.out.println(players.currentPlayer().getName() + IS_GETTING_OUT_OF_THE_PENALTY_BOX);
	}

	private void printWrongAnswerMessage() {
		System.out.println(QUESTION_WAS_INCORRECTLY_ANSWERED);
		System.out.println(players.currentPlayer().getName() + WAS_SENT_TO_THE_PENALTY_BOX);
	}
}
