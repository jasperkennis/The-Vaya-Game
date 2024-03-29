package nl.vaya.mobilegame;

import nl.vaya.mobilegame.layer.FloorLayer;
import nl.vaya.mobilegame.layer.TileLayer;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class TheVayaGameActivity extends Activity {
	
	protected CCGLSurfaceView _glSurfaceView;
	protected CCScene _scene;
	protected CCLayer _floorLayer;
	protected CCLayer _gameObjectLayer;
	protected CCLayer _skyLayer;
	protected CCLayer _tileLayer;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set screen settings:
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		// Set content:
		_glSurfaceView = new CCGLSurfaceView(this);
		setContentView(_glSurfaceView);
	}

	public void onStart() {
		super.onStart();

		// Initialize the surface that will be drawn on, and
		CCDirector.sharedDirector().attachInView(_glSurfaceView);
		CCDirector.sharedDirector().setDisplayFPS(true);
		CCDirector.sharedDirector().setAnimationInterval(1.0f / 30.0f);

		_scene = CCScene.node();
		
		//Make all layers
		_floorLayer = new FloorLayer();
		_tileLayer = new TileLayer();
		
		//Set all schedules
		//_tileLayer.schedule("update");
		_floorLayer.schedule("update");
		
		_scene.addChild(_floorLayer);
		_scene.addChild(_tileLayer);
		CCDirector.sharedDirector().runWithScene(_scene);
	}
}