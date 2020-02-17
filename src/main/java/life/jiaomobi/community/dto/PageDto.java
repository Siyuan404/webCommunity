package life.jiaomobi.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDto {
    private List<QuestionDto> questions;

    private boolean showPreviousPage;

    private boolean showFirstPage;

    private boolean showNextPage;

    private boolean showEndPage;

    private Integer currentPage;

    private List<Integer> pages = new ArrayList<>();

    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        currentPage = page;

        this.totalPage = totalPage;

        pages.add(page);

        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPreviousPage = false;
        } else {
            showPreviousPage = true;
        }

        //是否展示下一页
        if (page == totalPage) {
            showNextPage = false;
        } else {
            showNextPage = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
