package example.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Task {

    private long id;

    @NotNull
    private String title;
    private String memo;
    private StatusType status;
    private LocalDateTime createAt;

    public boolean isNew() {
        return id == 0;
    }
}
