package nl.vaya.mobilegame;

import java.util.ArrayList;

import org.cocos2d.nodes.CCSprite;

public class Tile {

	protected ArrayList<CCSprite> _sprites;
	
	
	/**
	 * Accepts an array of sprites and stores them in the array list of sprites
	 * @param sprites
	 */
	public void Tile(CCSprite[] sprites) {
		
		_sprites = new ArrayList<CCSprite>();
		
		for (CCSprite sprite : sprites){
			addSprite(sprite);
		}
	}
	
	/**
	 * Accepts a single sprite and stores it in the array list of sprites.
	 * @param sprite
	 */
	public void Tile(CCSprite sprite) {
		
		_sprites = new ArrayList<CCSprite>();
		
		addSprite(sprite);
	}
	
	
	public void addSprite(CCSprite sprite){
		_sprites.add(sprite);
	}
}