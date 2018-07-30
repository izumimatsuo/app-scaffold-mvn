package example.adapters.datasource.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import example.models.user.UserAccount;

@Mapper
public interface UserAccountMapper {

    @Select({"SELECT id, username, password, authority, enabled, nickname",
             "FROM user_accounts",
             "WHERE username = #{username}"})
    UserAccount select(String username);
}
