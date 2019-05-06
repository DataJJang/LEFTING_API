package com.jhlee.minipj.api.common.util;

import java.util.List;
import java.util.Map;

public class UtilArray {
	
	/**
	 * List<Map<String,Object>>  로 생성된 리스트에 안의 특정 key 의 value 값이 존재 하는지 여부
	 * @param list
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean isExist(List<Map<String,Object>> list, String key, String value) {
		
		int checkCount = 0;
		
		if(list != null && list.size() > 0) {
			for(Map<String, Object> map : list) {

				Object obj = map.get(key);
				if(value.equals(obj)) {
					checkCount++;
				}
			}
		}
		
		if(checkCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * List<String>  로 생성된 리스트에 안의 value 값이 존재 하는지 여부
	 * @param list
	 * @param value
	 * @return
	 */
	public static boolean isExist(List<String> list, String value) {

		int checkCount = 0;

		if(list != null && list.size() > 0) {
			for(String str : list) {

				if(value.equals(str)) {
					checkCount++;
				}
			}
		}

		if(checkCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * String[]  String 배열의 value 값이 존재 하는지 여부
	 * @param strArray
	 * @param value
	 * @return
	 */
	public static boolean isExist(String[] strArray, String value) {

		int checkCount = 0;

		if(strArray != null && strArray.length > 0) {
			for(String str : strArray) {

				if(value.equals(str)) {
					checkCount++;
				}
			}
		}

		if(checkCount > 0) {
			return true;
		} else {
			return false;
		}
	}

}
