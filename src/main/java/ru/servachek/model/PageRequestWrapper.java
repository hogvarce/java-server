package ru.servachek.model;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
public class PageRequestWrapper {
    private int offset;
    private int size;
    private String sort;
    private String sortBy;
    private Filters filters;

    public PageRequest getPageRequest() {
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return new PageRequest(page, size, direction, sortBy);
    }
}
