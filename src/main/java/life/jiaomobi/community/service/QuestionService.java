package life.jiaomobi.community.service;

import life.jiaomobi.community.dto.QuestionDto;
import life.jiaomobi.community.mapper.QuestionMapper;
import life.jiaomobi.community.mapper.UserMapper;
import life.jiaomobi.community.model.Question;
import life.jiaomobi.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDto> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDto> questionDtoList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());

            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto); //将question中所有属性拷贝进questionDto
            questionDto.setUser(user);

            questionDtoList.add(questionDto);
        }

        return questionDtoList;
    }
}
