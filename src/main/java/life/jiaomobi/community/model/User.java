package life.jiaomobi.community.model;

import lombok.Data;

@Data
public class User {
    private int id;

    private String accountId;

    private String name;

    private String token;

    private Long gmtCreate;

    private Long gmtModify;

    private String bio;

    private String avatarUrl;
}
