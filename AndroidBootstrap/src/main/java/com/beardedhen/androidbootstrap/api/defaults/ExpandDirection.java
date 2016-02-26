package com.beardedhen.androidbootstrap.api.defaults;


public enum ExpandDirection {
    UP,
    DOWN;

    public static ExpandDirection fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return UP;
            case 1:
                return DOWN;
            default:
                return DOWN;
        }
    }
}