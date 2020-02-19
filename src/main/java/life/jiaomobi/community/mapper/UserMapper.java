package life.jiaomobi.community.mapper;

import life.jiaomobi.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO community.user (name, account_id, token, gmt_create, gmt_modify, bio, avatar_url) VALUES (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModify}, #{bio}, #{avatarUrl})")
    void insert(User user);

    @Select("SELECT * FROM community.user WHERE token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("SELECT * FROM community.user WHERE id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("SELECT * FROM community.user WHERE account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("UPDATE community.user SET name = #{name}, token = #{token}, gmt_modify = #{gmtModify}, bio = #{bio}, avatar_url = #{avatarUrl} WHERE id = #{id}")
    void update(User dbUser);
}



