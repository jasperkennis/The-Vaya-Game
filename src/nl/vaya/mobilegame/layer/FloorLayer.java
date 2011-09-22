package nl.vaya.mobilegame.layer;

import nl.vaya.mobilegame.TileObject;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGSize;

public class FloorLayer extends CCLayer {
	static final String logTag = "log_tag";
	
	protected int[] _tilePositionArray;
	protected String[] _tileArray;
	
	protected float _numTilesWidth = 8; //15
	protected float _numTilesHeight = 5; //10
	
	protected CGSize winSize;
	
	public FloorLayer(){
		winSize = CCDirector.sharedDirector().displaySize();
		_tileArray = new String[15];
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
		
		_tileArray[14] = "sand.png";
		_tileArray[13] = "water.png";
		_tileArray[11] = "zandrechtonder.png";
		_tileArray[9] = "zandrechtboven.png";
		_tileArray[7] = "hoekrechtsonder.png";
		_tileArray[5] = "hoeklinksonder.png";
		_tileArray[6] = "hoekrechtsboven.png";
		_tileArray[8] = "hoeklinksboven.png";
		_tileArray[1] = "binnenhoeklinksboven.png";
		_tileArray[3] = "binnenhoekrechtsboven.png";
		_tileArray[2] = "binnenhoeklinksonder.png";
		_tileArray[4] = "binnenhoekrechtsonder.png";
		_tileArray[12] = "zandrechtrechts.png";
		_tileArray[10] = "zandrechtlinks.png";
		
		for(int i = 0; i< 400; i++){
		//for(int i = 0; i< _tilePositionArray.length; i++){
			float y = (int)(i/40);
			float x = (int)i-(y*40);
			CCSprite s = new CCSprite(_tileArray[_tilePositionArray[i]]);
			TileObject tile = new TileObject(s);
			
			tile.setTileSize(_numTilesWidth, _numTilesHeight, winSize);
			tile.setPosition(x,y);
			this.addChild(tile.getTile());

		}

	}
	
	public void update(float dt){
		//Log.i(logTag, "Update FloorLayer");
	}
}
