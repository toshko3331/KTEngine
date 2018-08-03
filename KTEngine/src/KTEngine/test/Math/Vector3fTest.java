package KTEngine.test.Math;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import KTEngine.Math.Vector3f;

class Vector3fTest {

    Vector3f vec1;
    Vector3f vec2;
    public void setUp(){
        vec1 = new Vector3f(0.0f, 5.0f, 3.2f);
        vec2 = new Vector3f(30.0f, 2.0f, 49.0f);

    }
	@Test
	void test() {
		
		this.setUp();
		
		//Vector3f.add();
		Assert.assertEquals(new Vector3f(30.0f, 7.0f, 52.2f).x, vec1.add(vec2).x, 0.000001f);
		Assert.assertEquals(new Vector3f(30.0f, 7.0f, 52.2f).y, vec1.add(vec2).y, 0.000001f);
		Assert.assertEquals(new Vector3f(30.0f, 7.0f, 52.2f).z, vec1.add(vec2).z, 0.000001f);
		//Vector3f.sub();
		Assert.assertEquals(new Vector3f(-30.0f, 3.0f, -45.8f).x, vec1.sub(vec2).x, 0.000001f);
		Assert.assertEquals(new Vector3f(-30.0f, 3.0f, -45.8f).y, vec1.sub(vec2).y, 0.000001f);
		Assert.assertEquals(new Vector3f(-30.0f, 3.0f, -45.8f).z, vec1.sub(vec2).z, 0.000001f);
		//Vector3f.scalarMult();
		Assert.assertEquals(new Vector3f(0.0f, 40.0f, 25.6f).x, vec1.scalarMult(8).x, 0.000001f);
		Assert.assertEquals(new Vector3f(0.0f, 40.0f, 25.6f).y, vec1.scalarMult(8).y, 0.000001f);
		Assert.assertEquals(new Vector3f(0.0f, 40.0f, 25.6f).z, vec1.scalarMult(8).z, 0.000001f);
		//Vector3f.dotProduct();
		Assert.assertEquals(new Vector3f(0.0f, 10.0f, 156.8f).x, vec1.dotProduct(vec2).x, 0.000001f);
		Assert.assertEquals(new Vector3f(0.0f, 10.0f, 156.8f).y, vec1.dotProduct(vec2).y, 0.000001f);
		Assert.assertEquals(new Vector3f(0.0f, 10.0f, 156.8f).z, vec1.dotProduct(vec2).z, 0.000001f);
	}
}
