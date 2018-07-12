package example.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testIsNew() {
		Task sut = new Task();
		boolean actual = sut.isNew();
		assertThat(actual, is(true));
	}

	@Test
	public void testIsNew_false() {
		Task sut = new Task();
		sut.setId(1L);
		boolean actual = sut.isNew();
		assertThat(actual, is(false));
	}

}
