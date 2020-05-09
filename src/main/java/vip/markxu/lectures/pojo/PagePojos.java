package vip.markxu.lectures.pojo;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Data
public class PagePojos<T> implements Serializable {
    int totalPages;
    long totalElements;
    int number;
    int size;
    int numberOfElements;
    List<T> content;

    boolean first;
    boolean last;
    boolean next;
    boolean previous;


    public PagePojos(Page page, List<T> pojoList) {
        this.setTotalPages(page.getTotalPages());
        this.setTotalElements(page.getTotalElements());
        this.setNumber(page.getNumber());
        this.setSize(page.getSize());
        this.setNumberOfElements(page.getNumberOfElements());
        this.setContent(pojoList);
        this.setFirst(page.isFirst());
        this.setLast(page.isLast());
        this.setNext(page.hasNext());
        this.setPrevious(page.hasPrevious());
    }
}
