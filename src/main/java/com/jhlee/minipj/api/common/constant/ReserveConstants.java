package com.jhlee.minipj.api.common.constant;

import java.util.Iterator;
import java.util.Map;

public class ReserveConstants {

    public ReserveConstants() {

    }

    public static final String RESERVE_LIMIT = "예약일 ${{rsvDate}} 는 2 주일(${{limitDay}}) 예약횟수 제한으로 예약할 수 없습니다.\n\n예약 시도 프로그램 : ${{prgName}}";
    public static final String RESERVE_DUPLICATED = "해당일 (${{rsvDate}}) 에 예약이 있어 예약을 할 수 없습니다.\\n\\n예약 시도 프로그램 : ${{prgName}} \\n\\n";
    public static final String NOT_CONTRACT_PERIOD = "${{rsvDate}} 은  관리예약할 수 있는 기간(${{ctdStart}} ~ ${{ctdEnd}})이 아닙니다.\\n관리프로그램을 확인하세요\\n\\n예약 시도 프로그램 : ${{prgName}}";
    public static final String PROGRAM_A_LIMIT = "요요방지관리 예약횟수를 초과하여 관리예약을 할 수 없습니다.\\n요요방지관리 프로그램은 월 1 회 관리 받을 수 있습니다.\\n\\n관리예약을 확인해주세요.\\n\\n예약 시도 프로그램 : ${{prgName}}";

    public static String getMsgAddParam(String msg, Map<String, String> pMap) {

        if (pMap.size() > 0) {
            Iterator<String> iterator = pMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = pMap.get(key);
                msg = msg.replace("${{"+key+"}}", value);
            }
        }
        return msg;
    }
}
