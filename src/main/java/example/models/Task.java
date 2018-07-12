package example.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Task {

    private long id;

    @NotNull(message = "入力必須です")
    private String title;
    private String memo;
    private StatusType status;
    private LocalDateTime createAt;

    public boolean isNew() {
        return id == 0;
    }
}
