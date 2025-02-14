
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalcTest {

	Calc c1 = new Calc(); 
	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void testAdd() {
		assertEquals(3, c1.add(1,2),()->"Not good");
	}
}
