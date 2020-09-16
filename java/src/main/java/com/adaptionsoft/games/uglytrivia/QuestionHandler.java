package com.adaptionsoft.games.uglytrivia;

import static com.adaptionsoft.games.uglytrivia.Category.*;
import static com.adaptionsoft.games.uglytrivia.TriviaConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class QuestionHandler {
	private static final String THE_CATEGORY_IS = "The category is ";
	private static final String ROCK_QUESTION = "Rock Question ";
	private static final String SPORTS_QUESTION = "Sports Question ";
	private static final String SCIENCE_QUESTION = "Science Question ";
	private static final String POP_QUESTION = "Pop Question ";
	
	private final List<String> popQuestions = new ArrayList<String>();
	private final List<String> scienceQuestions = new ArrayList<String>();
	private final List<String> sportsQuestions = new ArrayList<String>();
	private final List<String> rockQuestions = new ArrayList<String>();
	
	private final Map<Category, List<String>> questionsByCategory = buildQuestionByCategory();
	
	private QuestionHandler() {}
	
	public static QuestionHandler getInstance() {
		return new QuestionHandler();
	}
	
	public void initQuestions() {
		for (int i = 0; i < 50; i++) {
			popQuestions.add(POP_QUESTION + i);
			scienceQuestions.add((SCIENCE_QUESTION + i));
			sportsQuestions.add((SPORTS_QUESTION + i));
			rockQuestions.add((ROCK_QUESTION + i));
		}
	}
	
	private void askQuestion(int place) {
		System.out.println(questionsByCategory.get(Category.valueOf(currentCategory(place))).remove(0));
	}

	private void getQuestionCategory(int place) {
		System.out.println(THE_CATEGORY_IS + currentCategory(place));
	}
	
	public void askQuestionByCategory(int place) {
		getQuestionCategory(place);
		askQuestion(place);
	}
	
	private String currentCategory(int place) {
		if (POP_PLACES.contains(place))
			return Pop.name();
		if (SCIENCES_PLACES.contains(place))
			return Science.name();
		if (SPORT_PLACES.contains(place))
			return Sports.name();
		return Rock.name();
	}

	private Map<Category, List<String>> buildQuestionByCategory() {
		Map<Category, List<String>> questionByCategory = Maps.newHashMap();
		questionByCategory.put(Pop, popQuestions);
		questionByCategory.put(Science, scienceQuestions);
		questionByCategory.put(Sports, sportsQuestions);
		questionByCategory.put(Rock, rockQuestions);
		return questionByCategory;
	}
}
