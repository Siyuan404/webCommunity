package life.jiaomobi.community.exception;

public enum CustomizeErrorCode implements CustomizeErrorCodeInterface{
    QUESTION_NOT_FOUND("你找的MoBi不在了，要不要换一个试试");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
