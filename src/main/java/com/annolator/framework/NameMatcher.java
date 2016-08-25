package com.annolator.framework;

import java.lang.reflect.Field;

/**
 * Created by Welkin Bai on 2016/8/25 0025.
 * Annolator
 */
public class NameMatcher implements Matcher {

    public Field match(Field sourceField, Class target) throws NoSuchFieldException {
        return target.getDeclaredField(sourceField.getName());
    }
}
