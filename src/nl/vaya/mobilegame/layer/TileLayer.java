package nl.vaya.mobilegame.layer;

import java.util.ArrayList;
import java.util.Iterator;

import org.cocos2d.layers.CCLayer;

import android.util.Log;

public class TileLayer extends CCLayer {

	protected ArrayList<String> _tiles;
	
	public TileLayer(){
		_tiles = new ArrayList<String>();
		int i = 0;
		while (i < (40 * 40)) {
			_tiles.add("a");
			i++;
		}
	}
	
	public void update(float dt){
		for(String tile:_tiles){
			Log.i("datathroug", tile);
		}
	}
}
