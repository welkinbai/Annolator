package com.annolator.logic;

import com.annolator.annotations.CopyFrom;
import com.annolator.framework.Annolator;
import com.annolator.framework.DefaultAnnolator;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Welkin Bai on 2016/8/18 0018.
 * Annolator
 */
public class CopyTestTest {

    @Test
    public void testCopyTest() throws Exception {
        CopyTest copyTest = new CopyTest();
        Class<? extends CopyTest> copyTestClass = copyTest.getClass();
        if (copyTestClass.isAnnotationPresent(CopyFrom.class)) {
            CopyFrom annotation = copyTestClass.getAnnotation(CopyFrom.class);
            System.out.println(annotation.string1());
            System.out.println(annotation.string2());
        }
    }

    @Test
    public void testTwoClassCopyByReflect() throws Exception {
        Test1 test1 = new Test1();
        test1.setField1("a");
        test1.setField2("b");
        Test2 test2 = new Test2();
        Class<? extends Test1> test1Class = test1.getClass();
        Field[] test1ClassDeclaredFields = test1Class.getDeclaredFields();
        Class<? extends Test2> test2Class = test2.getClass();
        for (Field field : test1ClassDeclaredFields) {
            field.setAccessible(true);
            Object o = field.get(test1);
            Field test2ClassDeclaredField = test2Class.getDeclaredField(field.getName());
            test2ClassDeclaredField.setAccessible(true);
            test2ClassDeclaredField.set(test2, o);
        }
        System.out.println(test2.getField1());
        System.out.println(test2.getField2());
    }

    @Test
    public void testAnnolatorSimple() throws Exception {
        long nanoTime = System.nanoTime();
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        test1.setField1("a");
        test1.setField2("b");
        test1.setField3(3);
        test1.setField4(true);
        test1.setField5(2.1);
        test1.setField6(77.3f);
        test1.setField7("test");
        Annolator<Test1,Test2> annolator = new DefaultAnnolator<Test1, Test2>();
        annolator.copy(test1).To(test2);
        System.out.println(System.nanoTime()-nanoTime);
        System.out.println(test2.getField1());
        System.out.println(test2.getField2());
        System.out.println(test2.getField3());
        System.out.println(test2.isField4());
        System.out.println(test2.getField5());
        System.out.println(test2.getField7());
    }

    @Test
    public void testCopyDirect() throws Exception {
        long nanoTime = System.nanoTime();
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        test1.setField1("a");
        test1.setField2("b");
        test1.setField3(3);
        test1.setField4(true);
        test1.setField5(2.1);
        test1.setField6(77.3f);
        test1.setField7("test");
        test2.setField1(test1.getField1());
        test2.setField2(test1.getField2());
        test2.setField3(test1.getField3());
        test2.setField4(test1.isField4());
        test2.setField5(test1.getField5());
        test2.setField6(test1.getField6());
        test2.setField7(test1.getField7());
        System.out.println(System.nanoTime()-nanoTime);
        System.out.println(test2.getField1());
        System.out.println(test2.getField2());
        System.out.println(test2.getField3());
        System.out.println(test2.isField4());
        System.out.println(test2.getField5());
        System.out.println(test2.getField7());
    }

}