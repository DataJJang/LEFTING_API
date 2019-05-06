//package com.jhlee.minipj.api.common.util;
//
//import com.google.gson.JsonObject;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import kr.co.juvis.api.auth.model.AuthVO;
//import kr.co.juvis.api.common.base.model.UserVO;
//import org.apache.commons.codec.binary.Base64;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ResourceUtils;
//
//@Component
//public class JwtUtil {
//
//    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
//
//    public JwtUtil() {
//
//    }
//
//    public static String generateToken(UserVO userVO, String authPath) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//
//        File file = ResourceUtils.getFile(authPath);
//        String content = new String(Files.readAllBytes(file.toPath()));
//
////        File file = new File(Constants.APP_INFO.APP_AUTH_FILE_PATH_DEV);
//////        File file = new File(Constants.APP_INFO.APP_AUTH_FILE_PATH_LOCAL);
//////        //입력 스트림 생성
////        FileReader filereader = new FileReader(file);
////        StringBuffer sbf = new StringBuffer();
////        int singleCh = 0;
////        while((singleCh = filereader.read()) != -1){
////            sbf.append((char)singleCh);
////        }
////        filereader.close();
//
//        JsonObject jsonHeader = new JsonObject();
//        jsonHeader.addProperty("typ", "JWT");
//        jsonHeader.addProperty("alg", "HS256");
//        String header = jsonHeader.toString();
//        JsonObject jsonPayload = new JsonObject();
//        StringBuffer str = new StringBuffer();
//        String id = userVO.getMemId();
//        for (int i = 0; i < userVO.getMemId().length(); i++) {
//
//            if (id.charAt(i) >= '\uAC00' && id.charAt(i) <= '\uD7A3') {
//                if (((int) id.charAt(i) == 32)) {
//                    str.append(" ");
//                    continue;
//                }
//                str.append("\\u");
//                str.append(Integer.toHexString((int) id.charAt(i)));
//            } else {
//                str.append(id.charAt(i));
//            }
//        }
//        jsonPayload.addProperty("id", str.toString());
//        jsonPayload.addProperty("create_day", "20181107");
//        String payload = jsonPayload.getAsJsonObject().toString().replaceAll("\\\\u", "u");
//        String encodeHeader = Base64.encodeBase64URLSafeString(header.getBytes()).replaceAll("=", "+");
//        String encodePayload = Base64.encodeBase64URLSafeString(payload.getBytes()).replaceAll("=", "+");
//        String concatenated = encodeHeader + "." + encodePayload;
//
//        String algorithm="HmacSHA256";
//        Mac mac = Mac.getInstance(algorithm);
//        mac.init(new SecretKeySpec(content.getBytes(), algorithm));
//        byte[] resultBase = mac.doFinal(concatenated.getBytes("UTF8"));
//        String secret = Base64.encodeBase64URLSafeString(resultBase).replaceAll("=", "").replaceAll("\\+", "-").replaceAll("/", "_");
//        String token = concatenated + "." + secret;
//        return token;
//    }
//
//    public static AuthVO getAuth(String tokenStr) throws Exception{
//
//        //tokenStr = tokenStr.replaceAll("\\+", "=").replaceAll("-", "\\+").replaceAll("_", "/");
//
//        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6Ilx1YmMxNVx1YmJmOFx1YWNiZDA5NzciLCJjcmVhdGVfZGF5IjoiMjAxODExMDcifQ.d1Z2dr7u9Tk7nEEU0Kxk5rLkvQMKyR3GVf4zt2Iqdjo
//        // 1. 위의 토큰값을 (.)으로 split
//        // 2. split 데이터중 가운데(1번째) 데이터는 {"id":"\ubc15\ubbf8\uacbd0977","create_day":"20181107"} <-- 데이터가 인코딩된 데이터
//        // 3. base64로 디코딩 한 후 유니코드를 한글변환
//        //String token_str = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6Ilx1YmMxNVx1YmJmOFx1YWNiZDA5NzciLCJjcmVhdGVfZGF5IjoiMjAxODExMDcifQ.d1Z2dr7u9Tk7nEEU0Kxk5rLkvQMKyR3GVf4zt2Iqdjo";
//        String[] idx = tokenStr.split("\\.");
//        String token = idx[1];
//
//        byte[] decodedBytes1 = Base64.decodeBase64(token);
//
//        // 디코딩한 문자열을 표시
//        String str = new String(decodedBytes1, "UTF-8");
////        logger.debug("decode value : " + str );
//
//        StringBuilder sb = new StringBuilder();
//        char ch;
//        int len = str.length();
//        for (int i = 0; i < len; i++) {
//            ch = str.charAt(i);
//            if (ch == '\\' && str.charAt(i+1) == 'u') {
//                sb.append((char) Integer.parseInt(str.substring(i+2, i+6), 16));
//                i+=5;
//                continue;
//            }
//            sb.append(ch);
//        }
//
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse( sb.toString() );
//        //Map<String, Object> jsonObj = (Map<String, Object>) obj;
//        JSONObject jsonObj = (JSONObject) obj;
//
//        AuthVO rtnObj = new AuthVO();
//        rtnObj.setMemId((String)jsonObj.get("id"));
//
//        return rtnObj;
//    }
//}
