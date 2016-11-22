package task5;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Car car = new Car("Car", "Red");
		assertEquals("Red",car.colour); 
	}

}
