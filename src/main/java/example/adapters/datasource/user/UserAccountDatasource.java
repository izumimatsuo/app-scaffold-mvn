package example.adapters.datasource.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.models.user.UserAccount;
import example.models.user.UserAccountRepository;

@Repository
public class UserAccountDatasource implements UserAccountRepository {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserAccount findBy(String username) {
        return userAccountMapper.select(username);
    }
}
