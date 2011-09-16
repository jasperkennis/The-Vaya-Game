package nl.vaya.mobilegame.objects;

import org.cocos2d.nodes.CCSprite;

public class Square {
	protected CCSprite _Sprite;
	
	public CCSprite getSprite()
	{
		return _Sprite;
	}
	
	public float getTop()
	{
		return _Sprite.getPosition().y + (_Sprite.getContentSize().height / 2.0f);
	}
	
	public float getBottom()
	{
		return _Sprite.getPosition().y - (_Sprite.getContentSize().height / 2.0f);
	}
	
	public float getLeft()
	{
		return _Sprite.getPosition().x - (_Sprite.getContentSize().width / 2.0f);
	}
	
	public float getRight()
	{
		return _Sprite.getPosition().x + (_Sprite.getContentSize().width / 2.0f);
	}
	
	
	
	/**
	 * 
	 * @param other_square The square compared to whom this square collides.
	 * @return boolean
	 */
	public boolean isColliding(Square other_square) {
		if(this.getRight() < other_square.getLeft() ||
				this.getLeft() > other_square.getRight()) {
			return false;
		}
		
		if(this.getTop() < other_square.getBottom() ||
				this.getBottom() > other_square.getTop()) {
			return false;
		}
		
		return true;
	}
}
