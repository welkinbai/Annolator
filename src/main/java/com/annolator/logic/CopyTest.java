package com.annolator.logic;

import com.annolator.annotations.CopyFrom;

/**
 * Created by Welkin Bai on 2016/8/18 0018.
 * Annolator
 */
@CopyFrom(string1 = "獭獭最逗",string2 = "猫猫最帅")
public class CopyTest {
    public String myName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
