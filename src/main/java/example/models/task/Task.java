package example.models.task;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;

@Getter
public class Task {

    private long id;

    @NotBlank(message = "タスクを入力してください。")
    private String title;
    @Size(max = 10, message = "メモは{1}文字以内で入力してください。")
    private String memo;
    private StatusType status;
    private LocalDateTime createAt;

}
