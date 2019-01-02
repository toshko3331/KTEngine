package KTEngine.test.Math;

import org.junit.jupiter.api.Test;

import KTEngine.Math.Vector2;
import org.junit.Assert;

class Vector2Test {
    Vector2 vec1;
    Vector2 vec2;
    public void setUp(){
        vec1 = new Vector2(0.0f, 5.0f);
        vec2 = new Vector2(30.0f, 2.0f);

    }
	@Test
	void test() {
		
		this.setUp();
		
		//Vector2f.add();
		Assert.assertEquals(new Vector2(30.0f, 7.0f).x, vec1.add(vec2).x, 0.000001f);
		Assert.assertEquals(new Vector2(30.0f, 7.0f).y, vec1.add(vec2).y, 0.000001f);
		//Vector2f.sub();
		Assert.assertEquals(new Vector2(-30.0f, 3.0f).x, vec1.sub(vec2).x, 0.000001f);
		Assert.assertEquals(new Vector2(-30.0f, 3.0f).y, vec1.sub(vec2).y, 0.000001f);
		//Vector2f.scalarMult();
		Assert.assertEquals(new Vector2(0.0f, 40.0f).x, vec1.scalarMult(8).x, 0.000001f);
		Assert.assertEquals(new Vector2(0.0f, 40.0f).y, vec1.scalarMult(8).y, 0.000001f);
		//Vector2f.dotProduct();
		Assert.assertEquals(10.0f, vec1.dotProduct(vec2), 0.000001f);
	}

}
