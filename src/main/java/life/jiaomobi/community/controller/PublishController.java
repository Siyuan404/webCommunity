package life.jiaomobi.community.controller;

import life.jiaomobi.community.mapper.QuestionMapper;
import life.jiaomobi.community.model.Question;
import life.jiaomobi.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("tag") String tag,
                            @RequestParam("description") String description,
                            HttpServletRequest request,
                            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("tag", tag);
        model.addAttribute("description", description);

        if (title == null || title == "") {
            model.addAttribute("error", "MoBi的标题呢？？？ ");
            return "publish";
        }

        if (description == null || description == "") {
            model.addAttribute("error", "所以你说了MoBi？？？");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            model.addAttribute("error", "急MoBi，你还没登录呢");
            return "publish";
        }

        Question question = new Question();

        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModify(question.getGmtCreate());

        questionMapper.create(question);
        return "redirect:/";
    }
}
