/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package controller.bean;

import common.base.PrintableBean;

/**
 * @author chichen  Date: 16-3-30 Time: 下午1:50
 */
public class Box extends PrintableBean {

    private float length;

    private float width;

    private float height;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
