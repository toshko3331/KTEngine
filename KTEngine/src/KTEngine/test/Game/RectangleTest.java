package KTEngine.test.Game;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import KTEngine.Game.Rectangle;
import KTEngine.Math.Vector2;

class RectangleTest {

	private Rectangle mainRect;

	//intnx is an abbreviation for intersect.
	//
	private Rectangle TLintnx;
	private Rectangle TRintnx;
	private Rectangle BLintnx;
	private Rectangle BRintnx;
	//
	private Rectangle TLandTRintnx;
	private Rectangle BLandBRintnx;
	private Rectangle TLandBLintnx;
	private Rectangle TRandBRintnx;
	//
	private Rectangle circumscribedRect;
	//
	private Rectangle outsideHorizontal;
	private Rectangle outsideVertical;
	
	public void setUp() {
		//M prefix = mainRectangle's coordinates.
		float mTLX = -1;
		float mTLY = 1;
		float mBRX = 1;
		float mBRY = -1;
		mainRect = new Rectangle(new Vector2(mTLX, mTLY),new Vector2(mBRX, mBRY));

		TLintnx = new Rectangle(new Vector2(mTLX + 1, mTLY - 1), new Vector2(mBRX + 1, mBRY - 1));
		TRintnx = new Rectangle(new Vector2(mTLX - 1, mTLY - 1), new Vector2(mBRX - 1, mBRY - 1));
		BLintnx = new Rectangle(new Vector2(mTLX + 1, mTLY + 1), new Vector2(mBRX + 1, mBRY + 1));
		BRintnx = new Rectangle(new Vector2(mTLX - 1, mTLY + 1), new Vector2(mBRX - 1, mBRY + 1));
		
		TLandTRintnx = new Rectangle(new Vector2(mTLX + 0.5f, mTLY - 1), new Vector2(mBRX - 0.5f, mBRY - 1));
		BLandBRintnx = new Rectangle(new Vector2(mTLX + 0.5f, mTLY + 1), new Vector2(mBRX - 0.5f, mTLY - 1));
		TLandBLintnx = new Rectangle(new Vector2(mTLX + 1, mTLY - 0.5f), new Vector2(mBRX + 1, mBRY + 0.5f));
		TRandBRintnx = new Rectangle(new Vector2(mTLX - 1, mTLY - 0.5f), new Vector2(mBRX - 1, mBRY + 0.5f));
		
		circumscribedRect = new Rectangle(new Vector2(mTLX + 0.5f, mTLY - 0.5f), new Vector2(mBRX - 0.5f, mBRY + 0.5f));
	
		outsideHorizontal = new Rectangle(new Vector2(mTLX - 1, mTLY - 0.5f), new Vector2(mBRX + 1, mBRY + 0.5f));
		outsideVertical = new Rectangle(new Vector2(mTLX + 0.5f, mTLY + 1), new Vector2(mBRX - 0.5f, mBRY - 1));
		
	}
	
	
	@Test
	void test() {
		this.setUp();
		
		Assert.assertNotNull(mainRect.getIntersectingRect(TLintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(TRintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(BLintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(BRintnx));
		
		Assert.assertNotNull(mainRect.getIntersectingRect(TLandTRintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(BLandBRintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(TLandBLintnx));
		Assert.assertNotNull(mainRect.getIntersectingRect(TRandBRintnx));
		
		Assert.assertNotNull(mainRect.getIntersectingRect(circumscribedRect));
		
		/////
		Assert.assertNotNull(TLintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(TRintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(BLintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(BRintnx.getIntersectingRect(mainRect));
		
		Assert.assertNotNull(TLandTRintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(BLandBRintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(TLandBLintnx.getIntersectingRect(mainRect));
		Assert.assertNotNull(TRandBRintnx.getIntersectingRect(mainRect));
		
		Assert.assertNotNull(circumscribedRect.getIntersectingRect(mainRect));
		
		/////
		Assert.assertNotNull(mainRect.getIntersectingRect(outsideHorizontal));
		Assert.assertNotNull(mainRect.getIntersectingRect(outsideVertical));
		
		Assert.assertNotNull(outsideHorizontal.getIntersectingRect(mainRect));
		Assert.assertNotNull(outsideVertical.getIntersectingRect(mainRect));
		
	}

}
