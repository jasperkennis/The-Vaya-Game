package nl.vaya.mobilegame.layer;

import org.cocos2d.layers.CCLayer;

import android.util.Log;


public class FloorLayer extends CCLayer {
	static final String logTag = "log_tag";
	
	//1 = Land                   __  __
	//2 = Land - Water         /1  \/  \
	//3 = Land - Water         \2       /
	//4 =                      3|_/\__|
	//                         
	//                         
	
	public FloorLayer(){

	}
	
	public void update(float dt){
		//Log.i(logTag, "Update FloorLayer");
	}
}
