package org.forten.scss.dto.ro;

import org.forten.dto.PagedRo;
import org.forten.utils.collection.CollectionUtil;

import java.util.Collection;

public class PagedRoForEasyUI<T> {
    private PagedRo<T> ro;

    public PagedRoForEasyUI(PagedRo<T> ro) {
        this.ro = ro;
    }

    public Collection<T> getRows() {
        return this.ro.getData();
    }

    public long getTotal() {
        if (this.ro.getPage() == null) {
            return 0;
        } else {
            return this.ro.getPage().getAmount();
        }
    }

    public boolean isEmptyData() {
        return CollectionUtil.isEmpty(this.ro.getData());
    }
}
