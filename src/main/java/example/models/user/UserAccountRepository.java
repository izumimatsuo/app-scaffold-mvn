package example.models.user;

public interface UserAccountRepository {

    UserAccount findBy(String username);
}
