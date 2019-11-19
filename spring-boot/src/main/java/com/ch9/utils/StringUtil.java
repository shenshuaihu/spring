/**
 * 文件名: StringUtil.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.utils;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-18 15:13
 */
public class StringUtil {
    private static final String ENCODING_UFT_8 = "UTF-8";

    public static String stringByU8Byte(String str, int lengthb) {
        try {
            if (str == null || str.length() <= 0) {
                return null;
            }
            byte[] buf = str.getBytes(ENCODING_UFT_8);
            if (lengthb >= buf.length) {
                return str;
            }
            int left = Math.max(lengthb / 3, 1);
            int right = Math.min(str.length(), lengthb);
            int length = 0;
            int middle = 0;
            int middleLen = 0;
            while (middleLen != lengthb) {
                middle = (left + right) / 2;
                middleLen = str.substring(0, middle).getBytes(ENCODING_UFT_8).length;
                if (middleLen == lengthb) {
                    length = middle;
                    break;
                } else if (middleLen > lengthb) {
                    right = middle;
                } else if (middleLen < lengthb) {
                    left = middle;
                }
                if (left == right || (left + right) / 2 == left) {
                    if (left == 1 && str.substring(0, 1).getBytes(ENCODING_UFT_8).length > lengthb) {
                        left = 0;
                    }
                    length = left;
                    break;
                }
            }
            return str.substring(0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
