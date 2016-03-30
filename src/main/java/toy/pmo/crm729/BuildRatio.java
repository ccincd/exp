/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.pmo.crm729;

import java.math.BigDecimal;

/**
 * @author chichen  Date: 16-3-30 Time: 上午10:56
 */
public class BuildRatio {

    public static void main(String[] args) {
        BigDecimal lastTerm = new BigDecimal(String.valueOf(182.0));
        BigDecimal thisTerm = new BigDecimal(String.valueOf(671.0));

        System.out.println(buildRatioStr(thisTerm, lastTerm));
    }

    /**
     * 计算增减率
     *
     * @param thisTerm 本期数据
     * @param lastTerm 作为对比期的数据
     * @return 增减情况
     */
    public static String buildRatioStr(BigDecimal thisTerm, BigDecimal lastTerm) {
        if (lastTerm.compareTo(new BigDecimal(0)) == 0) {// 对比期数据为0
            int thisTermSign = thisTerm.signum();
            if (thisTermSign == 1) {
                return "增长" + disposeDecimal(thisTerm);
            } else if (thisTermSign == -1) {
                return "减少" + disposeDecimal(thisTerm.abs());
            } else {
                return "相同";
            }
        }

        BigDecimal diff = thisTerm.subtract(lastTerm);
        // MathContext mathContext = new MathContext(4, RoundingMode.HALF_EVEN);
        BigDecimal divResult = diff.divide(lastTerm, 4, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal roundRatio = divResult
                .multiply(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);// 百分比保留两位小数

        int roundRatioSign = roundRatio.signum();// 符号标识
        if (roundRatioSign != 0) {
            BigDecimal durationLimit = BigDecimal.valueOf(0.01);// 增减百分比小于0.01，认为是相同
            if (roundRatio.abs().compareTo(durationLimit) == -1) {
                roundRatioSign = 0;
            }
        }

        if (roundRatioSign == 1) {
            return "增长" + roundRatio.toString() + "%";
        } else if (roundRatioSign == -1) {
            return "减少" + roundRatio.abs().toString() + "%";
        } else {
            return "相同";
        }
    }

    /**
     * 检查BigDecimal的小数部分是否全为0
     *
     * @param originData 初始数据
     * @return 小数部分全为0则返回整数部分，否则返回全部
     */
    private static String disposeDecimal(BigDecimal originData) {
        BigDecimal roundDecimal = originData.setScale(0, BigDecimal.ROUND_DOWN);

        if (originData.compareTo(roundDecimal) != 0) {
            return originData.toString();
        } else {
            return roundDecimal.toString();
        }
    }
}
