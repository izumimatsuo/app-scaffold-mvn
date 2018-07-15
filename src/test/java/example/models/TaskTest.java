package example.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

public class TaskTest {

	@Test
	public void test_新規登録であること() {
		Task sut = new Task();
		boolean actual = sut.isNew();
		assertThat(actual, is(true));
	}

	@Test
	public void test_新規登録で無いこと() {
		Task sut = new Task(1L, "タイトル", "", StatusType.実行中, LocalDateTime.now());
		boolean actual = sut.isNew();
		assertThat(actual, is(false));
	}

}
