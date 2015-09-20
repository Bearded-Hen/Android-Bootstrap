package com.beardedhen.androidbootstrap.api.defaults;

public enum ButtonMode {
    REGULAR,
    TOGGLE,
    CHECKBOX,
    RADIO;

    public static ButtonMode fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return REGULAR;
            case 1:
                return TOGGLE;
            case 2:
                return CHECKBOX;
            case 3:
                return RADIO;
            default:
                return REGULAR;
        }
    }
}
