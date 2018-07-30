package example.services.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import example.models.user.UserAccount;

public class LoginUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private transient UserAccount userAccount;
    private Collection<? extends GrantedAuthority> authority;

    public LoginUser(UserAccount account) {
        this.userAccount = account;
        this.authority = AuthorityUtils.createAuthorityList(
                account.getAuthority().split("\\s"));
    }

    public String getNickname() {
        return userAccount.getNickname();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userAccount.isEnabled();
    }
}
