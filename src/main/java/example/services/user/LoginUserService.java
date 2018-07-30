package example.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import example.models.user.UserAccount;

@Primary
@Service
public class LoginUserService implements UserDetailsService {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountService.findBy(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("ユーザが見つかりません。");
        }
        return new LoginUser(userAccount);
    }
}
