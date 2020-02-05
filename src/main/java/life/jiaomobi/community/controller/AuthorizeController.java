package life.jiaomobi.community.controller;

import life.jiaomobi.community.dto.AccessTokenDto;
import life.jiaomobi.community.dto.GitHubUser;
import life.jiaomobi.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();

        accessTokenDto.setClient_id("875a5f2240e101660ba5");
        accessTokenDto.setClient_secret("b8a6ddcbe2ade6ee5d6f93ec2911d00a8228dc76");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);

        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }
}
