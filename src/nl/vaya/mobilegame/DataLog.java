package nl.vaya.mobilegame;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

public class DataLog extends CCLayer {

	protected CCLabel _TextLabel;
	
	public DataLog(){
		this.createLog();
		this.addLog("Test");
	}
	
	public void createLog(){
		if(_TextLabel == null){
			_TextLabel = CCLabel.makeLabel("Hi There", "Arial", 36);
			this.addChild(_TextLabel);
			CGSize winSize = CCDirector.sharedDirector().displaySize();
			_TextLabel.setPosition(CGPoint.ccp(winSize.width / 2.0f, winSize.height / 2.0f));
		}
	}
	
	public void addLog(String text){
		_TextLabel.setString(text);
	}
}
