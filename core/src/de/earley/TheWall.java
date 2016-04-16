package de.earley;

import com.badlogic.gdx.ApplicationAdapter;
import de.earley.GameStateManager.State;

public class TheWall extends ApplicationAdapter {

	GameStateManager manager;

	@Override
	public void create() {
		manager = new GameStateManager();
		manager.addGameState(State.MENU, new Menu());
		manager.gotoState(State.MENU);
	}

	@Override
	public void render() {
		manager.render();

	}
}
