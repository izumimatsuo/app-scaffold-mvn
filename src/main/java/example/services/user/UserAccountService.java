package example.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.models.user.UserAccount;
import example.models.user.UserAccountRepository;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount findBy(String username) {
        return userAccountRepository.findBy(username);
    }
}
