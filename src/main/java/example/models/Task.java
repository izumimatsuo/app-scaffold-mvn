package example.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class Task {

    private long id;

    @NotNull(message = "タスクを入力してください。")
    private String title;
    private String memo;
    private StatusType status;
    private LocalDateTime createAt;

    @JsonIgnore
    public boolean isNew() {
        return id == 0;
    }
}
