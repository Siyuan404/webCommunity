package life.jiaomobi.community.mapper;

import life.jiaomobi.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO community.question(title, description, gmt_create, gmt_modify, creator, tag) VALUES (#{title}, #{description}, #{gmtCreate}, #{gmtModify}, #{creator}, #{tag})")
    void create(Question question);

    @Select("SELECT * FROM community.question LIMIT #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT * FROM community.question WHERE creator = #{userId} LIMIT #{offset}, #{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT COUNT(1) FROM community.question")
    Integer count();

    @Select("SELECT COUNT(1) FROM community.question WHERE creator = #{userId}")
    Integer countByUserId(@Param(value = "userId") Integer userId);
}
