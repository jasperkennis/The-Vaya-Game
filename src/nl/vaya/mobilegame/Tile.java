package nl.vaya.mobilegame;

import java.util.ArrayList;

import org.cocos2d.nodes.CCSprite;

public class Tile {

	protected ArrayList<CCSprite> _sprites;
	protected CCSprite _activeSprite;
	
	
	/**
	 * Accepts an array of sprites and stores them in the array list of sprites
	 * @param sprites
	 */
	public Tile(CCSprite[] sprites) {
		
		_sprites = new ArrayList<CCSprite>();
		
		for (CCSprite sprite : sprites){
			addSprite(sprite);
		}
		
		_activeSprite = _sprites.get(0);
	}
	
	/**
	 * Accepts a single sprite and stores it in the array list of sprites.
	 * @param sprite
	 */
	public Tile(CCSprite sprite) {
		
		_sprites = new ArrayList<CCSprite>();
		
		addSprite(sprite);
		
		_activeSprite = _sprites.get(0);
	}
	
	
	public void addSprite(CCSprite sprite){
		_sprites.add(sprite);
	}
	
	
	public CCSprite getTile(){
		return _activeSprite;
	}
	
	public void update(){
		if(_sprites.size() < 2){
			return;
		}
		
		
	}
}