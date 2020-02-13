package life.jiaomobi.community.mapper;

import life.jiaomobi.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO community.question(title, description, gmt_create, gmt_modify, creator, tag) VALUES (#{title}, #{description}, #{gmtCreate}, #{gmtModify}, #{creator}, #{tag})")
    void create(Question question);

    @Select("SELECT * FROM community.question")
    List<Question> list();
}
