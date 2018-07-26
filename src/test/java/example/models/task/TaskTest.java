package example.models.task;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;

public class TaskTest {
    
    private static Class<Task> taskType;
    private static Validator validator;

    @BeforeClass
    public static void beforeClass() {
        taskType = Task.class;
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void タスク名が入力エラーでないこと() {
        int actual = validator.validateValue(taskType, "title", "タスク名").size();
        assertThat(actual, is(0));
    }
    
    @Test
    public void タスク名が入力エラーであること() {
        int actual = validator.validateValue(taskType, "title", "").size();
        assertThat(actual, is(1));
    }
    
    @Test
    public void メモが入力エラーでないこと() {
        int actual = validator.validateValue(taskType, "memo", "1234567890").size();
        assertThat(actual, is(0));
    }
    
    @Test
    public void メモが入力エラーであること() {
        int actual = validator.validateValue(taskType, "memo", "12345678901").size();
        assertThat(actual, is(1));
    }
}
