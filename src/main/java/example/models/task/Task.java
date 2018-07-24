package example.models.task;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;

@Getter
public class Task {

    private static final int MEMO_MAX_SIZE = 10;

    private long id;

    @NotBlank(message = "タスクを入力してください。")
    private String title;
    @Size(max = MEMO_MAX_SIZE, message = "メモは{1}文字以内で入力してください。")
    private String memo;
    private StatusType status;
    private LocalDateTime createAt;

}
