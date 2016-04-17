package de.earley;

import com.badlogic.gdx.ApplicationAdapter;
import de.earley.GameStateManager.State;

public class TheWall extends ApplicationAdapter {

	public static final int WIDTH = 800, HEIGHT = WIDTH * 9/16;
	
	GameStateManager manager;

	@Override
	public void create() {
		manager = new GameStateManager();
		manager.addGameState(State.MENU, new Menu());
		manager.addGameState(State.GAME, new Game());
		manager.gotoState(State.GAME);
	}

	@Override
	public void render() {
		manager.render();

	}
}
