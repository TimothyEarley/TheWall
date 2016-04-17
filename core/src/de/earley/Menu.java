package de.earley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.earley.GameStateManager.State;

public class Menu extends GameState {

	private OrthographicCamera cam;
	private SpriteBatch sb;

	private BitmapFont titlefont;
	private BitmapFont font;

	private int currentItem;
	private String[] menuItems;

	private final String title = "The Trump";
	

	public void create() {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 200, 200);
		sb = new SpriteBatch();
		titlefont = new BitmapFont();
		font = new BitmapFont();

		titlefont.setColor(Color.WHITE);

		menuItems = new String[] { "Play", "Quit"

		};

	}

	public void render() {
		cam.update();
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
	
		titlefont.draw(sb, title, 75, 160);

		for (int i = 0; i < menuItems.length; i++) {
			if (currentItem == i)
				font.setColor(Color.RED);
			else
				font.setColor(Color.WHITE);
			font.draw(sb, menuItems[i], 75, 130 - 30 * i);
		}
		sb.end();

		handleInput();

	}

	public void handleInput() {

		if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			currentItem--;
			if (currentItem < 0)
				currentItem = menuItems.length - 1;
		}
		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			currentItem++;
			if (currentItem >= menuItems.length) {
				currentItem = 0;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			select();
		}

	}

	private void select() {
		if(currentItem == 0){
			manager.addGameState(State.GAME, new Game());
			manager.gotoState(State.GAME);
		}
		if(currentItem == 1){
			Gdx.app.exit();
		}
	}

}
