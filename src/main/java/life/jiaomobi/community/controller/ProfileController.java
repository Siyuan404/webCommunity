package life.jiaomobi.community.controller;

import life.jiaomobi.community.dto.PageDto;
import life.jiaomobi.community.mapper.UserMapper;
import life.jiaomobi.community.model.User;
import life.jiaomobi.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);

                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        if (user == null) {
            return "redirect:/";
        }

        if ("myquestion".equals(action)) {
            model.addAttribute("section", "myquestion");
            model.addAttribute("sectionName", "俺的MoBi");
        } else if ("replies".equals((action))) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PageDto pageDto = questionService.list(user.getId(), page, size);

        model.addAttribute("pagination", pageDto);

        return "profile";
    }
}
