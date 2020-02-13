package life.jiaomobi.community.mapper;

import life.jiaomobi.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO community.user (name, account_id, token, gmt_create, gmt_modify, bio, avatar_url) VALUES (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModify}, #{bio}, #{avatarUrl})")
    void insert(User user);

    @Select("SELECT * from community.user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("SELECT * from community.user where id = #{id}")
    User findById(@Param("id") Integer id);
}



