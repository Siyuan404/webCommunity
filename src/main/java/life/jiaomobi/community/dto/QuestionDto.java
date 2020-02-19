package life.jiaomobi.community.dto;

import life.jiaomobi.community.model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private Integer id;

    private String title;

    private String description;

    private Long gmtCreate;

    private Long gmtModify;

    private String creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

    private User user;
}
