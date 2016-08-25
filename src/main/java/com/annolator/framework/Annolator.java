package com.annolator.framework;

/**
 * Created by Welkin Bai on 2016/8/25 0025.
 * Annolator
 */
public interface Annolator<S, T> {

    Annolator<S, T> copy(S source);

    void To(T target) throws NoSuchFieldException, IllegalAccessException;
}
