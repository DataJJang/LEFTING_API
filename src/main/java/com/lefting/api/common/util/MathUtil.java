package com.lefting.api.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;


public class MathUtil {


	/**
	 * Null 값이 넘어 올경우 0 을 return
	 * @param i
	 * @return
	 */
	public static int getNumber(Object i) {

		if(i == null || "".equals(i)) {
			return 0;
		} else {
			return Integer.valueOf(i+"");
		}
	}
	
	/**
	 * Null 값이 넘어 올경우 0 을 return
	 * @param i
	 * @return
	 */
	public static long getLong(Object i) {
		
		if(i == null || "".equals(i)) {
			return 0;
		} else {
			return Long.valueOf(i+"");
		}
	}

	/**
	 * Null 값이 넘어 올경우 0 을 return
	 * @param i
	 * @return
	 */
	public static double getDouble(Object i) {

		if(i == null || "".equals(i)) {
			return 0;
		} else {
			return Double.valueOf(i+"");
		}
	}

	/**
	 * 소수점 반올림
	 * @param d 반올림할 수
	 * @param i 자리수 반올림 1(10),2(100),3(1000)
	 * @return
	 */
	public static double getRoundDouble(double d, int i) {
		double pow = (double)Math.pow(10, i);
		return ((double)Math.round(d * pow)) /pow;
	}

	public static String getDoubleToString(double value) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format((double) value);
	}

    /**
     * 평균값 계산
     * @param args 숫자 인수들...
     * @return
     */
    public static double avg(Object ... args)
    {
        BigDecimal num = null;
        BigDecimal sum = new BigDecimal(0);
        for(Object arg : args) {
            num = new BigDecimal(String.valueOf(arg));
            sum = sum.add(num);
        }
        return sum.divide(new BigDecimal(args.length)).doubleValue();
    }
    /**
     * 비율별 합계 계산
     * @param args 숫자 인수들...
     * @param ratios 비율 배열
     * @return
     */
    public static double avgRatio(Object[] args, double[] ratios)
    {
        BigDecimal num = null;
        BigDecimal ratio = null;
        BigDecimal sum = new BigDecimal(0);
        for(int i=0; i<args.length; i++) {
            num = new BigDecimal(String.valueOf(args[i]));
            ratio = new BigDecimal(ratios[i]);
            sum = sum.add(num.multiply(ratio));
        }
        return sum.doubleValue();
    }

	public static String numberGen(int len) {
		Random rand = new Random();
		String numStr = "";

		for(int i = 0; i < len; i++){
			String ran = Integer.toString(rand.nextInt(10));
			if(!numStr.contains(ran)) {
				numStr += ran;
			}else {
				i-=1;
			}
		}
		return numStr;
	}

}