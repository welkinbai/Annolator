package com.annolator.framework;


import java.lang.reflect.Field;

/**
 * Created by Welkin Bai on 2016/8/25 0025.
 * Annolator
 */
public class DefaultAnnolator<S, T> implements Annolator<S, T> {

    private Matcher innoMatcher;
    private S source;

    public Annolator copy(S source) {
        Class<?> sourceClazz = source.getClass();
        com.annolator.annotations.Annolator annolator = sourceClazz.getAnnotation(com.annolator.annotations.Annolator.class);
        if (annolator == null) {
            this.innoMatcher = new NameMatcher();
        } else {
            this.innoMatcher = new NameMatcher();
        }
        this.source = source;
        return this;
    }

    public void To(T target) throws NoSuchFieldException, IllegalAccessException {
        Class<?> targetClazz = target.getClass();
        Class<?> sourceClazz = source.getClass();
        for (Field sourceField : sourceClazz.getDeclaredFields()) {
            sourceField.setAccessible(true);
            Field targetField = innoMatcher.match(sourceField, targetClazz);
            targetField.setAccessible(true);
            targetField.set(target, sourceField.get(source));
        }
    }
}
