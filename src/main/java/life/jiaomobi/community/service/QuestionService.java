package life.jiaomobi.community.service;

import life.jiaomobi.community.dto.PageDto;
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

    public PageDto list(Integer page, Integer size) {
        PageDto pageDto = new PageDto();

        Integer totalCount = questionMapper.count();

        pageDto.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > pageDto.getTotalPage()) {
            page = pageDto.getTotalPage();
        }

        Integer offset = size * (page - 1);

        List<Question> questions = questionMapper.list(offset, size); //每一页的问题列表
        List<QuestionDto> questionDtoList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());

            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto); //将question中所有属性拷贝进questionDto
            questionDto.setUser(user);

            questionDtoList.add(questionDto);
        }

        pageDto.setQuestions((questionDtoList));

        return pageDto;
    }
}
