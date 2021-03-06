/**
 * 工具类
 * <p>
 * 处理String相关操作
 * <p>
 * 判断String类型
 * <p>
 * 获取String中指定规则的字符
 *
 * @Author :dengchengchao
 * @Time: 2017-12-11
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

class Tools {
    private static final String chineseRex = "^[0-9\u4e00-\u9fa5]$";

    /**
     * 删除字符串中指定位子的子字符串
     * @param originalStr :参考字符串
     * @param startIndex: remove开始的索引
     * @param length : remove 的长度
     */
    public static String stringRemove(String originalStr, int startIndex, int length) {
        if (originalStr == null) return originalStr;
        if (startIndex < 0 || startIndex >= originalStr.length()) return originalStr;
        if (length <= 0 || startIndex + length > originalStr.length()) return originalStr;

        String resultStr = "";
        for (int i = 0; i < originalStr.length(); i++) {
            if (i >= startIndex && i < startIndex + length) continue;
            resultStr += originalStr.charAt(i);
        }
        return resultStr;
    }

    ;

    /**
     * 判断String是否为空
     */
    public static boolean isNullorEmpty(String s) {
        return (s == null || s.isEmpty());
    }

    /**
     *  检查一个字符是否是汉字
     */
    public static boolean isChineseChar(char word) {
        return Pattern.matches(chineseRex, String.valueOf(word));
    }

    /**
     *  检查一个sentence中包含多少个汉字
     */
    public static int getSentenceChineseCount(String sentence) {
        int chineseCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (isChineseChar(sentence.charAt(i))) {
                chineseCount++;
            }
        }
        return chineseCount;
    }

    /**
     *  获取句子中只包含汉字的子字符串
     */
    public static String getSentenceOnlyChinese(String sentence) {
        String result = "";
        for (int i = 0; i < sentence.length(); i++) {
            char item = sentence.charAt(i);
            if (isChineseChar(item)) {
                result += item;
            }
        }
        return result;
    }

    /**
     *  判断两个ArrayList是否是相同的
     */
    public static boolean isListEquals(ArrayList<String> ary, ArrayList<String> aryOther) {
        if (ary == null || aryOther == null) return false;
        if (ary.size() != aryOther.size()) return false;
        List<String> aryClone = (ArrayList<String>) ary.clone();
        List<String> othClone = (ArrayList<String>) aryOther.clone();
        Collections.sort(aryClone);
        Collections.sort(othClone);
        return aryClone.equals(othClone);
    }

    /**
     *   将拼音的第一个字母大写
     */
    public  static String upperFirstLetter(String letter){
        if (isNullorEmpty(letter)) return "";
         return letter.replaceFirst(letter.substring(0, 1), letter.substring(0, 1).toUpperCase());
    }
}
