package com.jhlee.minipj.api.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import com.jhlee.minipj.api.common.base.model.ResultVO;
import com.jhlee.minipj.api.common.constant.MessageConstants;

/**
 * Class Name : Utility.java
 * Description : Utility class
 * Modification Information
 *
 * @author Wan
 * @since 2015.6.8
 * @version 1.0
 *  
 */
public class Utility {

	/**
	 * 필수 파라미터 확인
	 * @param checkMap
	 * @return
	 */
	public final static ResultVO checkParameter (Map checkMap) {
		ResultVO resultVO = new ResultVO();
		if (checkMap.size() > 0) {
			Iterator<String> iterator = checkMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				if(checkMap.get(key) == null || "".equals(checkMap.get(key))) {

					String msg = "("+ key + ")";
					resultVO.setCode(MessageConstants.ResponseEnum.PARAM_REQUIRED.getCode());
					resultVO.setMessage(MessageConstants.ResponseEnum.PARAM_REQUIRED.getDesc() + msg);
					return resultVO;

				}
			}
		}
		return resultVO;
	}
	
	/**
	 * 문자열로 입력받은 파일 크기를 계산하여 리턴. 10M, 2G 등.
	 * @param sizeString
	 * @return long
	 */
	public final static long parseFileSize(String sizeString){
		long size = 0;
		long multiple = 1;
		int pos = -1;
		String[] strs = new String[]{"K", "M", "G"};
		for(int i = 0; i < strs.length; i++){
			pos = sizeString.indexOf(strs[i]);
			if(pos > -1){
				multiple = (long)Math.pow(1024, i+1);
				size = Long.parseLong(sizeString.substring(0, pos));
				break;
			}
		}
		if(pos < 0)
			size = Long.parseLong(sizeString);
		return size * multiple;
	}
	
	/**
	 * ${ 로 시작되는 가변 인자를 판단함.
	 * @param str
	 * @return boolean
	 */
	public final static boolean isVariable(String str){
		if(str.indexOf("${") > -1){
			return true;
		}
		return false;
	}
	
	/**
	 * str에서 해당 variable을 arg로 치환.
	 * @param str
	 * @param variable
	 * @param arg
	 * @return String
	 */
	public final static String replaceVariable(String str, String variable, String arg){
		return str.replaceAll("\\$\\{"+variable+"\\}", arg);
	}
	
	/**
	 * 아스키 코드 값이 숫자인지 판단.
	 * @param s
	 * @return boolean
	 */
	public final static boolean isNumeric(String s){
		char[] ss = s.toCharArray();
		for(int i = 0; i < ss.length; i++) {
			if(!(ss[i]==45 || (ss[i] >= 48 && ss[i] <= 57)))
				return false;
		}
		return true;
	}
	
	/**
	 * buffer 안에 arg가 들어있는지 판단.
	 * @param buffer
	 * @param arg
	 * @return boolean
	 */
	public final static boolean isInArray(String[] buffer, String arg){
		for(int i = 0; i < buffer.length; i++){
			if(buffer[i] == null){
				continue;
			}
			if(buffer[i].equals(arg)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Says IP address is valid 
	 * @param arg
	 * @return boolean
	 */
	public final static boolean isIPAddress(String arg){
		arg = arg.trim();
		int pos1 = arg.indexOf(".");
		if(pos1 < 0){
			return false;
		}
		int pos2 = arg.indexOf(".", pos1+1);
		if(pos2 < 0){
			return false;
		}
		int pos3 = arg.indexOf(".", pos2+1);
		if(pos3 < 0){
			return false;
		}
		
		try {
			int a1 = Integer.parseInt(arg.substring(0, pos1));
			if(a1 < 1 || a1 > 254)
				return false;
			int a2 = Integer.parseInt(arg.substring(pos1 + 1, pos2));
			if(a2 < 0 || a2 > 254)
				return false;
			int a3 = Integer.parseInt(arg.substring(pos2 + 1, pos3));
			if(a3 < 0 || a3 > 254)
				return false;
			int a4 = Integer.parseInt(arg.substring(pos3 + 1));
			if(a4 < 1 || a4 > 254)
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
    /**
     * contentType of characterSet is returned.
     * @param contentType
     * @return String
     */
	public final static String getCharsetFromContentType(String contentType){
		return getCharsetFromContentType(contentType, null);
	}

    /**
     * contentType of characterSet with input characterSet is returned.
     * @param contentType
     * @param defaultCharset
     * @return String
     */
	public final static String getCharsetFromContentType(String contentType, String defaultCharset){
		if(contentType == null){
			return defaultCharset;
		}
        String str = "charset=";
        int i = contentType.indexOf(str);
        if(i == -1)
            return defaultCharset;
        i += str.length();
        int j = contentType.indexOf(';', i);
        if(j == -1)
            j = contentType.length();
        return contentType.substring(i, j).trim();
    }

	/**
	 * 문자열에서 key=value&key=value 로 이루어진 값을 분리하여 map 형식으로 리턴.
	 * @param queryString
	 * @return Map<String, String[]>
	 */
	public static Map<String, String[]> parseQueryString(String queryString) {
		String[] values = null;
		
		Map<String, String[]> parameters = new Hashtable<String, String[]>();
		
		if (queryString == null){
			return parameters;
		}
		if(queryString.indexOf("=") < 0){
			return parameters;
		}
		
		String key;
		for (StringTokenizer st = new StringTokenizer(queryString, "&"); st.hasMoreTokens();) {

			String parameter = st.nextToken();
			int equalPos = parameter.indexOf('=');
			
			if (equalPos > -1) {
				key = parseValue(parameter.substring(0, equalPos));
				String value = parseValue(parameter.substring(equalPos + 1, parameter.length()));
				if(value.length() < 1){
					value = null;
				}
				if (parameters.containsKey(key)) {
					String existsValues[] = (String[]) parameters.get(key);
					values = new String[existsValues.length + 1];
					for (int i = 0; i < existsValues.length; i++){
						values[i] = existsValues[i];
					}

					values[existsValues.length] = value;
				} else {
					values = new String[]{value};
				}
				parameters.put(key, values);
			}
		}
		return parameters;
	}
	

	/**
	 * 문자열에서 +, %를 제거 
	 * @param parameterName
	 * @return String
	 */
	private static String parseValue(String parameterName) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < parameterName.length(); i++) {
			char c = parameterName.charAt(i);
			switch (c) {
			case 43: // '+'
				buffer.append(' ');
				break;

			case 37: // '%'
				try {
					buffer.append((char) Integer.parseInt(parameterName.substring(i + 1, i + 3), 16));
					i += 2;
					break;
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException();
				} catch (StringIndexOutOfBoundsException e) {
					String rest = parameterName.substring(i);
					buffer.append(rest);
					if (rest.length() == 2)
						i++;
				}
				break;

			default:
				buffer.append(c);
				break;
			}
		}

		return buffer.toString();
	}
	
	// 부모 Map 에 key값의 Map이 있으면 리턴 없으면 생성 , jsh
	public static Map<String,Object> getNvlMap(Map<String,Object> obj , String key){
		return obj.get(key) != null ? (Map<String,Object>)obj.get(key) : new HashMap<String,Object>();
	}
	
	// 부모 Map 에 key값의 List가 있으면 리턴 없으면 생성 , jsh
	public static List<Map<String,Object>> getNvlList(Map<String,Object> obj , String key){
		return obj.get(key) != null ? (List<Map<String,Object>>) obj.get(key) : new ArrayList<Map<String,Object>>();
	}
	
	// 부모 Map 에 key값의 List가 있으면 리턴 없으면 생성 , jsh
	public static List<String> getNvlListString(Map<String,Object> obj , String key){
		return obj.get(key) != null ? (List<String>) obj.get(key) : new ArrayList<String>();
	}
	
	// Map 의 value 값에 따라 정렬 후  key값 List를 리턴  , jsh
	public static List<String> getMapSortList(final Map map, boolean isDesc){
		List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator(){
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v1).compareTo(v2);
            }
             
        });
        if(isDesc){
        	Collections.reverse(list); // 주석시 오름차순
        }
        return list;
    }

	// Map 의 value 값에 따라 정렬 후  key값 List를 리턴  , jsh
	public static List<String> getMapSortListByParam(final Map<String,Object> map, final String paramKey, boolean isDesc){
		List<String> list = new ArrayList<String>();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator(){
            public int compare(Object o1,Object o2){
                Map<String,Object> v1 = (Map<String, Object>) map.get(o1+"");
                Map<String,Object> v2 = (Map<String, Object>) map.get(o2+"");
                int v1Seq = MathUtil.getNumber(v1.get(paramKey));
                int v2Seq = MathUtil.getNumber(v2.get(paramKey));
                return ((Comparable) v1Seq).compareTo(v2Seq);
            }
        });
        if(isDesc){
        	Collections.reverse(list); // 주석시 오름차순
        }
        return list;
    }
	
	// map 의 key 리스트를 토대로 list 형태값 반환
	public static List<Map<String,Object>> getSortList(List<String> keyArr, Map<String,Object> map){
		List<Map<String,Object>> rtn = new ArrayList<>();
		for(String key : keyArr){
			Map<String,Object> row = (Map<String, Object>) map.get(key);
			row.put("key", key);
			rtn.add(row);
		}
		return rtn;
	}
	
	// php의 Array[key1][key2][key3].. 형태의 값을 가져올 경우  , jsh
	public static Object getMapValue(Map<String, Object> map, String keyStr) {
		Object value = null;
		String[] keys = keyStr.split("::");
		if(keys.length > 0){
			int lastIndex = keys.length;
			int index = 1;
			Map<String,Object> nextMap = new HashMap<>(map);
			for(String key : keys){
				if(index == lastIndex){
					value = nextMap.get(key);
				}else{
					if(nextMap.get(key) != null){
						nextMap = (Map<String,Object>) nextMap.get(key);
						index ++;
					}else{
						return null;
					}
				}
			}
		}
		return value;
	}
	
	public static double getMapDoubleValue(Map<String, Object> csData, String keyStr) {
		return MathUtil.getDouble(getMapValue(csData, keyStr));
	}
	
	public static String getMapStringValue(Map<String, Object> csData, String keyStr) {
		return UtilString.getNvlObject(getMapValue(csData, keyStr));
	}
	
	public static String getMapDoubleValueString(Map<String, Object> map, String keyStr) {
		return MathUtil.getDoubleToString(MathUtil.getDouble(getMapValue(map, keyStr)));
	}

	// php의 Array[key1][key2][key3].. 형태의 값을 저장할 경우  , jsh
	public static void setMapValue(Map<String, Object> map, String keyStr,Object value) {
		String[] keys = keyStr.split("::");
		if(keys.length > 0){
			int lastIndex = keys.length;
			int index = 1;
			Map<String,Object> nextMap = map;
			for(String key : keys){
				if(index == lastIndex){
					nextMap.put(key,value);
				}else{
					nextMap.put(key, new HashMap<>(getNvlMap(nextMap, key)));
					nextMap = (Map<String, Object>) nextMap.get(key);
					index ++;
				}
			}
		}
	}
	
	// php의 Array[key1][key2][key3].. 형태의 값을 Unset 할 경우  , jsh
	public static void setMapUnset(Map<String, Object> map, String keyStr) {
		String[] keys = keyStr.split("::");
		if(keys.length > 0){
			int lastIndex = keys.length;
			int index = 1;
			Map<String,Object> nextMap = map;
			for(String key : keys){
				if(nextMap.get(key) != null){
					if(index == lastIndex){
						nextMap.remove(key);
					}else{
						nextMap = (Map<String, Object>) nextMap.get(key);
						index ++;
					}
				}
			}
		}
	}
	
	// php의 Array[key1][key2][key3].. 형태의 값에 value 값을 += 해서 저장할 경우  , jsh
	public static void setMapValuePlus(Map<String, Object> map, String keyStr, Object value) {
		setMapValue(map, keyStr, MathUtil.getDouble(getMapValue(map, keyStr)) + MathUtil.getDouble(value));
	}
	
	// php의 Array[key1][key2][key3].. 형태의 값에 value 값을 += 해서 저장할 경우  , jsh - int형 계산
	public static void setMapValuePlus(Map<String, Object> map, String keyStr, int value) {
		setMapValue(map, keyStr, MathUtil.getNumber(getMapValue(map, keyStr)) + value);
	}
	
	// php의 Array[key1][key2][key3].. 형태의 값에 value 값을 -= 해서 저장할 경우  , jsh
	public static void setMapValueMinus(Map<String, Object> map, String keyStr, Object value) {
		setMapValue(map, keyStr, MathUtil.getDouble(getMapValue(map, keyStr)) - MathUtil.getDouble(value));
	}
	
	// float 파싱 - 잘못된 값은 다 0
	public static float getParseFloat(String value) {
		float amount;
		try {
			amount=Float.parseFloat(value);
		} catch (Exception e) {
			amount=0;
		}
		return amount;
	}
	
	// php의 array_merge_recursive 메소드 구현 - > map끼리 합쳤을경우 같은 key 값을 가진 경우 List 로 만들어 밀어 넣어준다.
	public static Map<String,Object> arrayMergeRecursive(Map<String, Object> origin, Map<String, Object> add) {
		for(String oriKey : origin.keySet()){
			Object oriValue = origin.get(oriKey);
			String oriClass = origin.get(oriKey).getClass().getName();
			if(add.get(oriKey) != null){
				Object addValue = add.get(oriKey);
				String addClass = add.get(oriKey).getClass().getName();
				if(oriClass.indexOf("Map") > -1 && addClass.indexOf("Map") > -1){
					//둘다 맵의 형태이므로 for문을 돌면서 다시 점검
					Map<String , Object> newOriMap = (Map<String, Object>) oriValue;
					Map<String , Object> newAddMap = (Map<String, Object>) addValue;
					arrayMergeRecursive(newOriMap , newAddMap); 
				}else if(oriClass.indexOf("Map") > -1 && addClass.indexOf("Map") == -1){
					//원본은 map 형태로 담겨있고 신규값만 추가되어야 할 경우
					Map<String , Object> newValue = (Map<String, Object>) oriValue;
					newValue.put(newValue.size()+"", addValue);
					origin.put(oriKey, newValue);
				}else if(oriClass.indexOf("Map") == -1 && addClass.indexOf("Map") > -1){
					//원본 map에 신규 map에 추가되어야 할 경우 
					origin.put(oriKey , arrayMergeRecursive((Map<String, Object>) oriValue, (Map<String, Object>) addValue));
				}else if(oriClass.indexOf("Map") == -1 && addClass.indexOf("Map") == -1){
					//둘의 값을  key를 index 로 만들어  저장
					Map<String , Object> newValue = new HashMap<>();
					int newIndex = 0;
					newValue.put(newIndex+"", oriValue);
					newValue.put((newIndex+1)+"", addValue);
					origin.put(oriKey, newValue);
				}
			}
		}
		
		//신규 value 가 없는것은 추가해준다.
		for(String addKey : add.keySet()){
			if(origin.get(addKey) == null){
				origin.put(addKey, add.get(addKey));
			}
		}
		return origin;
	}

	//스트링 배열로 반환 받는다 . 변수의 구분자는 :: 이다.
	public static List<String> getStringArray(String param) {
		String[] params = param.split("::");
		return Arrays.asList(params);
	}

	//where[] 형태로 저장된 조건들을 AND 로 붙여서 sql 문으로 만든다.
	public static String setWhere(List<String> where) {
		String rtn = "";
		for(int a=0; a<where.size(); a++){
			rtn += " AND "+where.get(a);
		}
		return rtn;
	}
	
	//Date Array 에서 해당 인덱스 있으면 셋팅 없으면 추가
	public static void setListValue(List<Date> oStart, int i, Date addDate) {
		// TODO Auto-generated method stub
		if(oStart.size() > i){
			oStart.set(i, addDate);
		}else{
			oStart.add(i, addDate);
		}
	}

}
