package example.models.user;

import lombok.Getter;

@Getter
public class UserAccount {

    private long id;
    private String username;
    private String password;
    private String authority;
    private String nickname;
    private boolean enabled;

    public UserAccount() {
        this.id = 0L;
        this.username = "";
        this.password = "";
        this.authority = "";
        this.nickname = "";
        this.enabled = true;
    }
}
