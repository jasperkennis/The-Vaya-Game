package nl.vaya.mobilegame;

import java.util.ArrayList;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

public class TileObject {

	protected ArrayList<CCSprite> _sprites;
	protected int _activeSprite = 0;
	
	protected float _tileHeight = 30;
	protected float _tileWidth = 30;
	
	/**
	 * Accepts an array of sprites and stores them in the array list of sprites
	 * @param sprites
	 * @return void
	 */
	public TileObject(CCSprite[] sprites) {
		
		_sprites = new ArrayList<CCSprite>();
		
		for (CCSprite sprite : sprites){
			addSprite(sprite);
		}
	}
	
	
	
	/**
	 * Accepts a single sprite and stores it in the array list of sprites.
	 * @param sprite
	 * @return void
	 */
	public TileObject(CCSprite sprite) {
		
		_sprites = new ArrayList<CCSprite>();
		
		addSprite(sprite);
	}
	
	
	
	public void addSprite(CCSprite sprite){
		_sprites.add(sprite);
	}
	
	
	public CCSprite getTile(){
		return _sprites.get(_activeSprite);
	}
	
	
	
	/**
	 * Sets the active sprite index according to the currently active sprite and the number of sprites
	 * @return void
	 */
	public void update(){
		// If there is only one sprite, no action is needed
		if(_sprites.size() < 2){
			return;
		}
		
		// If the current active sprite isn't the last one, add up
		if( ( _activeSprite + 1 ) < _sprites.size()){
			_activeSprite++;
			return;
		}
		
		// Otherwise set the index to 0 
		_activeSprite = 0;
	}
	
	public void setTileSize(float w, float h, CGSize winSize){
		_tileWidth = winSize.width/w;
		_tileHeight = winSize.height/h;
		
		for (CCSprite sprite : _sprites){
			sprite.setContentSize(_tileWidth, _tileHeight);
		}
	}
	
	public void setPosition(float x, float y){
		CGPoint position = CGPoint.ccp((x*_tileWidth),(y*_tileHeight));
		for (CCSprite sprite : _sprites){
			sprite.setPosition(position);
		}
	}
}
