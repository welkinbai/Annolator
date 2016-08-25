package com.annolator.framework;

import java.lang.reflect.Field;

/**
 * Created by Welkin Bai on 2016/8/25 0025.
 * Annolator
 */
public interface Matcher {

    Field match(Field sourceField, Class source) throws NoSuchFieldException;

}
