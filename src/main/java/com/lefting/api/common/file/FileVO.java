package com.lefting.api.common.file;


import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileVO  {

    /** 업로드 방식 : "F"(FTP로 파일서버에 업로드) | "S"(Server로 직접 업로드) 기본값 S */
    private String uploadType = "S";

    /** 첨부파일 아이디 */
    private String filId;
    /** 첨부파일 아이디 배열 */
    private String[] filIds;
    /** 첨부파일 업로드시 이름 */
    private String filOrgNm;
    /** 첨부파일 실제 저장 이름 */
    private String filNewNm;
    /** 첨부파일 경로 */
    private String filPath;
    /** 첨부파일 용량 */
    private Integer filSize;
    /** 첨부파일을 사용하는 DB Table PK */
    private String tblId;
    /** 첨부파일 그룹 */
    private Integer filGrp;
    /** 첨부파일 순서 */
    private Integer sortOrd;
    /** 첨부파일 순서 배열 */
    private Integer[] sortOrds;

    /** 첨부파일 */
    private MultipartFile file;

    /** 압축 여부 */
    private boolean isCompress;

    /** FileVO 목록 */
    private List<FileVO> fileList;

    /** 첨부파일 이미지명 */
    private String imgNm;
    /** 첨부파일 이미지 가로크기 */
    private Integer imgWidth;
    /** 첨부파일 이미지 세로크기 */
    private Integer imgHeight;

    private String tableName;

    /** j2t_file 관련 VO */
    private String filType;
    private Integer filParentID;
    private Integer filStep;
    private String brdBid;
    private String filServerName;
    private String filLocalName;
    private Integer filDownCount;
    private Date filRegDate;
    private String filFinfo;

    /** j2t_chart_file, j2t_promotion_file 관련 VO */
    private String filBid;
    private String memId;

    /** event_file 관련 VO */
    private String eventFileIdx;

}
