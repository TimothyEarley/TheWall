package de.earley;

import java.util.HashMap;
import java.util.Map;

public class GameStateManager {

	public enum State {
		MENU, GAME
	}

	Map<State, GameState> states = new HashMap<>();

	GameState current;

	public void addGameState(State state, GameState gamestate) {
		states.put(state, gamestate);
		gamestate.manager = this;
		gamestate.create();
	}

	public void gotoState(State state) {
		if (current != null)
			current.onExit();
		current = states.get(state);
		current.onEnter();
	}

	public void render() {
		current.render();

	}

}
