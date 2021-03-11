package org.uniyaz.core.domain;

import java.io.Serializable;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public abstract class BaseDomain implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseDomain that = (BaseDomain) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}