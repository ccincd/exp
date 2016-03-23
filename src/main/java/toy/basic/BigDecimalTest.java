/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.basic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author chichen  Date: 16-3-23 Time: 下午6:03
 */
public class BigDecimalTest {

    private static String disposeDecimal(BigDecimal originData) {
        BigDecimal roundDecimal = originData.setScale(0, BigDecimal.ROUND_DOWN);
        if (originData.compareTo(roundDecimal) != 0) {
            return originData.toString();
        } else {
            return roundDecimal.toString();
        }
    }

    private static String buildRatioStr(BigDecimal thisTerm, BigDecimal lastTerm) {
        BigDecimal diff = thisTerm.subtract(lastTerm);
        MathContext mathContext = new MathContext(4, RoundingMode.HALF_EVEN);
        BigDecimal roundRatio = diff
                .divide(lastTerm, mathContext)
                .multiply(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);
        int roundRatioSign = roundRatio.signum();

        if (roundRatioSign != 0) {
            BigDecimal durationLimit = new BigDecimal(0.01);
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

    public static void main(String[] args) {
        BigDecimal pi = new BigDecimal("3.1415926");
        BigDecimal likePi = new BigDecimal("3.00");

        BigDecimal piLong = new BigDecimal(pi.longValue());
        BigDecimal likePiLong = new BigDecimal(likePi.longValue());

        if (pi.compareTo(piLong) != 0) {
            System.out.println("has decimal");
            System.out.println(pi.compareTo(piLong));
        }

        if (likePi.compareTo(likePiLong) == 0) {
            System.out.println("no decimal");
            System.out.println(likePi.compareTo(likePiLong));
        }

        /////////////////////////////////////////////////////

        BigDecimal piExact = pi.setScale(0, BigDecimal.ROUND_DOWN);
        System.out.println(piExact.toString());

        /////////////////////////////////////////////////////

        System.out.println(disposeDecimal(pi));
        System.out.println(disposeDecimal(likePi));

        /////////////////////////////////////////////////////

        System.out.println(buildRatioStr(new BigDecimal(10001), new BigDecimal(10000)));
    }
}
