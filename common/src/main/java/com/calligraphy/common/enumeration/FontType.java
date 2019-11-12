package com.calligraphy.common.enumeration;

import lombok.Getter;

public enum FontType {
    ZHUAN(0),   //篆书
    LI(1),      //隶书
    KAI(2),     //楷书
    XING(3),    //行书
    CAO(4);     //草书

    @Getter
    Integer typeNo;

    FontType(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public static boolean checkFontType(Integer fontType) {
        boolean result = false;
        if (fontType != null) {
            for (FontType type : FontType.values()) {
                if (type.getTypeNo().equals(fontType)) {
                    result = true;
                }
            }
        }
        return result;
    }
}
