package nl.vaya.mobilegame.layer;

import nl.vaya.mobilegame.TileObject;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGSize;

import android.util.Log;

public class FloorLayer extends CCLayer {
	static final String logTag = "log_tag";
	
	protected int[] _tilePositionArray;
	protected TileObject[] _tileArray;
	
	protected float _numTilesWidth = 12;
	protected float _numTilesHeight = 8;
	
	protected CGSize winSize;
	
	public FloorLayer(){
		winSize = CCDirector.sharedDirector().displaySize();
		_tileArray = new TileObject[15];
		_tilePositionArray = new int[] {
				13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 7, 11, 11, 11, 5, 13, 13, 13, 13, 13, 13, 13,
		        13, 13, 7, 11, 11, 11, 5, 13, 7, 11, 11, 5, 13, 13, 13, 13, 7, 11, 11, 11, 11, 11, 5, 13, 13, 13, 13, 7, 4, 14, 14, 14, 10, 13, 13, 7, 11, 5, 13, 13,
		        13, 13, 12, 14, 14, 14, 2, 11, 4, 14, 14, 10, 13, 13, 13, 7, 4, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13, 12, 14, 14, 14, 14, 2, 11, 11, 4, 14, 10, 13, 13,
		        13, 13, 6, 3, 14, 14, 14, 14, 14, 14, 14, 2, 11, 5, 13, 12, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13, 6, 3, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 4, 14, 14, 14, 14, 14, 14, 2, 5, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 11, 11, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 7, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 8, 13, 13,
		        13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 9, 3, 14, 14, 14, 10, 13, 13, 13, 13,
		        13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 9, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 8, 13, 13, 12, 14, 14, 1, 8, 13, 13, 13, 13,
		        13, 13, 6, 3, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 8, 13, 13, 7, 4, 14, 14, 10, 13, 13, 13, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 1, 8, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 7, 4, 14, 14, 14, 2, 11, 5, 13, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 10, 13, 13, 7, 11, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 7, 4, 14, 14, 14, 14, 14, 14, 2, 5, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 2, 11, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 6, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 8, 13, 13,
		        13, 13, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13,
		        13, 13, 13, 13, 7, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 5, 13, 13, 13,
		        13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13,
		        13, 13, 7, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13,
		        13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 8, 13, 13, 13,
		        13, 13, 6, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 8, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 6, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 5, 13, 6, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 5, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 11, 11, 5, 13, 13,
		        13, 13, 13, 7, 11, 5, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 12, 14, 2, 11, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 13, 6, 9, 3, 14, 14, 14, 14, 14, 1, 9, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 9, 3, 14, 14, 1, 9, 9, 8, 13, 13,
		        13, 13, 13, 13, 13, 12, 14, 14, 14, 14, 1, 8, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 8, 13, 13, 12, 14, 14, 10, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 7, 4, 14, 14, 14, 14, 10, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13, 7, 11, 4, 14, 14, 2, 11, 5, 13, 13, 13,
		        13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 10, 13, 13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 7, 4, 14, 14, 14, 14, 14, 14, 2, 5, 13, 13,
		        13, 13, 13, 13, 12, 14, 14, 14, 14, 14, 2, 11, 11, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 7, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 2, 11, 4, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 12, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 1, 9, 3, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 10, 13, 13,
		        13, 13, 12, 14, 14, 1, 9, 9, 3, 14, 14, 14, 14, 1, 9, 3, 14, 14, 14, 14, 10, 13, 6, 9, 9, 9, 9, 3, 14, 14, 14, 14, 14, 14, 1, 9, 9, 8, 13, 13,
		        13, 13, 12, 14, 14, 10, 13, 13, 6, 9, 3, 14, 14, 10, 13, 6, 9, 9, 9, 3, 10, 13, 13, 13, 13, 13, 13, 12, 14, 14, 14, 1, 9, 9, 8, 13, 13, 13, 13, 13,
		        13, 13, 6, 9, 9, 8, 13, 13, 13, 13, 6, 9, 9, 8, 13, 13, 13, 13, 13, 6, 8, 13, 13, 13, 13, 13, 13, 6, 9, 9, 9, 8, 13, 13, 13, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
		        13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13
		};
		
		_tileArray[1] = new TileObject(CCSprite.sprite("sand.png"));						//Tile object 1
		Log.i(logTag, "1");
		_tileArray[2] = new TileObject(CCSprite.sprite("water.png"));						//Tile object 2
		Log.i(logTag, "2");
		_tileArray[3] = new TileObject(CCSprite.sprite("zandrechtonder.png"));				//Tile object 3
		Log.i(logTag, "3");
		_tileArray[4] = new TileObject(CCSprite.sprite("zandrechtboven.png"));				//Tile object 4
		Log.i(logTag, "4");
		_tileArray[5] = new TileObject(CCSprite.sprite("hoekrechtsonder.png"));				//Tile object 5
		Log.i(logTag, "5");
		_tileArray[6] = new TileObject(CCSprite.sprite("hoeklinksonder.png"));				//Tile object 6
		Log.i(logTag, "6");
		_tileArray[7] = new TileObject(CCSprite.sprite("hoekrechtsboven.png"));				//Tile object 7
		Log.i(logTag, "7");
		_tileArray[8] = new TileObject(CCSprite.sprite("hoeklinksboven.png"));				//Tile object 8
		Log.i(logTag, "8");
		_tileArray[9] = new TileObject(CCSprite.sprite("binnenhoeklinksboven.png"));		//Tile object 9
		Log.i(logTag, "9");
		_tileArray[10] = new TileObject(CCSprite.sprite("binnenhoekrechtsboven.png"));		//Tile object 10
		Log.i(logTag, "10");
		_tileArray[11] = new TileObject(CCSprite.sprite("binnenhoeklinksonder.png"));		//Tile object 11
		Log.i(logTag, "11");
		_tileArray[12] = new TileObject(CCSprite.sprite("binnenhoekrechtsonder.png"));		//Tile object 12
		Log.i(logTag, "12");
		_tileArray[13] = new TileObject(CCSprite.sprite("zandrechtrechts.png"));			//Tile object 13
		Log.i(logTag, "13");
		_tileArray[14] = new TileObject(CCSprite.sprite("zandrechtlinks.png"));				//Tile object 14
		Log.i(logTag, "14");
		for(int i = 0; i< 4; i++){
		//for(int i = 0; i< _tilePositionArray.length; i++){
			float y = (int)(i/40);
			float x = (int)i-(y*40);
			_tileArray[_tilePositionArray[i]].setTileSize(_numTilesWidth, _numTilesHeight, winSize);
			_tileArray[_tilePositionArray[i]].setPosition(x,y);
			this.addChild(_tileArray[_tilePositionArray[i]].getTile());

		}

	}
	
	public void update(float dt){
		//Log.i(logTag, "Update FloorLayer");
	}
}
