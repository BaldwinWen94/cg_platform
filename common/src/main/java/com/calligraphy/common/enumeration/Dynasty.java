package com.calligraphy.common.enumeration;

import lombok.Getter;

public enum Dynasty {
    XIAN_QIN(0),        //先秦
    QIN(1),             //秦
    HAN(2),             //汉
    SAN_GUO(3),         //三国
    JIN(4),             //晋
    NAN_BEI_CHAO(5),    //南北朝
    SUI(6),             //隋
    TANG(7),            //唐
    WU_DAI(8),          //五代
    SONG(9),            //宋
    YUAN(10),           //元
    MING(11),           //明·
    QING(12);           //清

    @Getter
    Integer dynastyNo;

    Dynasty(Integer dynastyNo) {
        this.dynastyNo = dynastyNo;
    }

    public static boolean checkFontType(Integer fontType) {
        boolean result = false;
        if (fontType != null) {
            for (Dynasty type : Dynasty.values()) {
                if (type.getDynastyNo().equals(fontType)) {
                    result = true;
                }
            }
        }
        return result;
    }
}
