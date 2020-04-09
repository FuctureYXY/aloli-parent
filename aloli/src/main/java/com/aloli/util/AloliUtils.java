package com.aloli.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 这是一个字符串工具类
 * <p>
 * 1.判断字符串是否为空
 * <p>
 * 2.整数转换:parseInteger
 * <p>
 * 3.小数转换:parseBigDecimal
 * <p>
 * 4.日期转换，可指定格式:parseDate
 *  * <p>
 * 5.日期转换，固定格式yyyy-MM-dd:parseDate
 * 
 * @author yxy
 * @since aloli
 */
public class AloliUtils {
	/**
	 * 判断字符串是否为空：null,""," "
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.trim().length() == 0;
	}
	public static boolean isNotEmpty(String str) {
		return !AloliUtils.isEmpty(str);
	}

	/**
	 * 判断字符串是否非空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNoEmpty(String str) {
		if (AloliUtils.isEmpty(str)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 字符串转换整型
	 * 
	 * @param a
	 * @return
	 */
	public static Integer parseInteger(String str) {
		Integer integer = null;
		if (AloliUtils.isEmpty(str)) {

		} else {
			try {
				integer = Integer.valueOf(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return integer;

	}
	public static String IntegerToString(Integer x){
		if (x==null) {
			return "";
		}else{
			String y =x.toString(); 
			return y;
		}
	}

	/**
	 * 日期转换:将指定字符串转换为日期类型 可选格式
	 * 
	 * @param str
	 *            传入字符串
	 * @param format
	 *            格式："yyyy-MM-dd";2018-10-10
	 * @return
	 */
	public static Date parseDate(String str, String format) {
		Date date = null;
		if (AloliUtils.isEmpty(str)) {

		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

			try {
				date = simpleDateFormat.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;

	}
	/**
	 * 日期转换:将指定字符串转换为日期类型  直接转换为 yyyy-MM-dd
	 * 
	 * @param str
	 *            传入字符串
	 * @return
	 */
	public static Date parseDate(String str) {
		Date date = null;
		if (AloliUtils.isEmpty(str)) {

		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				date = simpleDateFormat.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;

	}


	/**
	 * 指定字符串格式化日期 Mon Sep 10 00:00:00 CST 2018 ——>2018-10-10
	 * 
	 * @param str
	 * @return
	 */
	public static String dateFormat(Date str) {
		String date = null;
		if(str==null){
			return "";
		}else{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.format(str);
		
		return date;
		}
	}

	/**
	 * 小数转换：将指定字符串转换为bigdecimal类型
	 * 
	 * @param str
	 * @return
	 */
	public static BigDecimal parseBigDecimal(String str) {
		BigDecimal bigDecimal = null;
		if (AloliUtils.isEmpty(str)) {

		} else {
			bigDecimal = new BigDecimal(str);
			return bigDecimal;
		}
		return bigDecimal;
	}
	public static String bigDecimalToString(BigDecimal bigDecimal){
		
		if(bigDecimal == null){
			return "";
		}else{
			return bigDecimal.toString();
		}
		
	}

	/**
	 * 字符串包含指定数值
	 * 
	 * @param str1
	 *            原字符串
	 * @param str2
	 *            被包含的字符串
	 * @return
	 */
	public static boolean contains(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {
			if (str1.substring(i, i + 1).equals(str2)) {
				return true;
			}
		}

		return false;
	}
	public static Integer Integer(String a ){
		if(a==null||a.isEmpty()){
			
			return null;
		}else{
			Integer x = Integer.valueOf(a);
			return x;	
		}
		
	}

	  public static String getNumSmallCharRandom(int length) {  
          Random random = new Random();  
         //参数length，表示生成几位随机数  
          StringBuilder NumSmall = new StringBuilder();
          for(int i = 0; i < length; i++) {  
              String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
              //输出字母还是数字  
              if( "char".equalsIgnoreCase(charOrNum) ) {  
                  //输出小写字母
            	  NumSmall.append((char)(random.nextInt(26) + 97));  
              } else if( "num".equalsIgnoreCase(charOrNum) ) {  
             //输出数字
            	  NumSmall.append(String.valueOf(random.nextInt(10)));  
              }  
          }  
          return  NumSmall.toString();
      }
}
