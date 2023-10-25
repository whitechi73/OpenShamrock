package com.tencent.mobileqq.pb;

import java.util.Collection;
import java.util.List;

public final class PBRepeatField<T> extends PBField<List<T>> {

    public PBRepeatField(PBField<T> pBField) {
    }
    public void add(T t) {
        get().add(t);
    }

    public void addAll(Collection<T> collection) {
        get().addAll(collection);
    }

    public void clear(Object obj) {
    }

    public void copyFrom(PBField<List<T>> pBField) {
    }

    public T get(int index) {
        return null;
    }

    public List<T> get() {
        return null;
    }

    public boolean has() {
        return !isEmpty();
    }

    public boolean isEmpty() {
        return false;
    }

    public void remove(int index) {
    }

    public void set(int index, T t) {
    }

    public void set(List<T> list) {
    }

    public int size() {
        return 0;
    }
}