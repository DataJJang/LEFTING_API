package com.lefting.api.common.base.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVO implements Serializable {

    private String memId;
    private Integer currentPage;
    private Integer page;

    private Integer currentIdx;
    private Integer rangeSize;
    private String nextYn;


    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }                         

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCurrentIdx() {return currentIdx;  }

    public void setCurrentIdx(Integer currentIdx) { this.currentIdx = currentIdx;  }

    public Integer getRangeSize() {   return rangeSize; }

    public String getNextYn() {
        return nextYn;
    }

    public void setNextYn(String nextYn) {
        this.nextYn = nextYn;
    }

    public void setRangeSize(Integer rangeSize) {
        this.rangeSize = rangeSize;
    }

    private static final long serialVersionUID = 1L;

//    @Override
//    public String toString (){
//        String result = "";
//
//        Field[] fields = this.getClass().getDeclaredFields();
//        result += this.getClass().getName() + "\n";
//
//        for(Field field : fields) {
//            try {
//                field.setAccessible(true);
//
//                String name = field.getName();
//                Object value = field.get(this);
//
//                result += "<"+name+"> : ";
//
//                if(field.getType() == java.util.List.class) {
//                    result += "[\n";
//                    result += (value == null || ((List) value).isEmpty()) ? "NULL OR IS EMPTY" : value.toString() + ", ";
//                    result += "]\n";
//                } else if (field.getType() == java.util.Map.class) {
//                    result += "{\n";
//                    result += (value == null || ((Map) value).isEmpty()) ? "NULL OR IS EMPTY" : value.toString() + ", ";
//                    result += "}\n";
//                } else {
//                    result += (value == null) ? "NULL" : value.toString() + "\n";
//                }
//
//
//            }catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        return result;
//    }

}
