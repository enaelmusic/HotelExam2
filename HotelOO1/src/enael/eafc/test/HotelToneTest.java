package enael.eafc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enael.eafc.HotelTone;

class HotelToneTest {

	@Test
	void testSingleton() {
		HotelTone ht1 = HotelTone.getInstance();
		HotelTone ht2 = HotelTone.getInstance();
		assertSame(ht1,ht2);
	}
}
