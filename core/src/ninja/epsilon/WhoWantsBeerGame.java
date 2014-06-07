
package ninja.epsilon;

import java.util.ArrayList;
import java.util.List;

import ninja.epsilon.drinkers.BarCounter;
import ninja.epsilon.drinkers.Drinkers;
import ninja.epsilon.physics.BarPhysics;
import ninja.epsilon.physics.Physics;
import ninja.epsilon.physics.Physics.InputCallback;
import ninja.epsilon.renderers.DashboardRenderer;
import ninja.epsilon.renderers.DrinkersRenderer;
import ninja.epsilon.renderers.Renderer;
import ninja.epsilon.score.Score;
import ninja.epsilon.score.Scorer;
import ninja.epsilon.swipereader.InputReader;
import ninja.epsilon.swipereader.SwipeReader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class WhoWantsBeerGame extends ApplicationAdapter {
	private Drinkers drinkers;
	private Physics physics;
	private List<Renderer> renderers;
	private Scorer scorer;
	private InputReader inputReader;
	
	private Renderer drinkersRenderer;
	private Renderer dashboardRenderer;
	
	@Override
	public void create () {
		renderers = new ArrayList<Renderer>();
		physics = new BarPhysics();
		drinkers = new BarCounter();
		inputReader = new SwipeReader((InputCallback) physics);
		scorer = new Score();

		//Create and add renderers
		drinkersRenderer= new DrinkersRenderer(drinkers);
		dashboardRenderer = new DashboardRenderer(scorer);
		renderers.add(drinkersRenderer);
		renderers.add(dashboardRenderer);

		
		for (Renderer renderer : renderers) {
			renderer.create();
		}
		
		// Register swipe reader
//		Gdx.input.setInputProcessor(inputReader);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		long t = System.currentTimeMillis();
//		long swipe = inputReader.input(t);
//		physics.update(t, swipe);
		drinkers.update(t, GameLevel.EASY);
		for (Renderer renderer : renderers) {
			renderer.render();
		}
	}
	
	@Override
	public void dispose() {
		for (Renderer renderer : renderers) {
			renderer.dispose();
		}
	}
}


