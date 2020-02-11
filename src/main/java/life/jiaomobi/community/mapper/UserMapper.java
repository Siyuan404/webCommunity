package life.jiaomobi.community.mapper;

import life.jiaomobi.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO community.user (name, account_id, token, gmt_create, gmt_modify) VALUES (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModify})")
    void insert(User user);
}

