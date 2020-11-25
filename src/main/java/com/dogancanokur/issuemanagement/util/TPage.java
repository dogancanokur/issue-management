package com.dogancanokur.issuemanagement.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@NoArgsConstructor
public class TPage<T> {
    private int number;
    private int size;
    private Sort sort;
    private int totalPages;
    private Long totalElement;
    private List<T> content;

    public void setStats(Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElement = page.getTotalElements();
        this.content = list;
    }
}
