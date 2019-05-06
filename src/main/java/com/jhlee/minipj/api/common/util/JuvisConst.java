package com.jhlee.minipj.api.common.util;

/**
 * Class Name : JuvisConst.java<br>
 * Description : JuvisConst<br>
 * 각종 상수값 보유 클래스
 * @author wan
 * @since 2016. 7. 8.
 * @version 1.0
 * @see
 * <pre>
 *  Modification Information (개정이력)
 *  수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *
 * </pre>
 */
public final class JuvisConst {
	private JuvisConst() {

	}
	
	/** 로컬 프로파일 */
	public static final String PROFILE_LOCAL = "local";
	/** 개발 프로파일 */
	public static final String PROFILE_TEST = "test";
	/** 운영 프로파일 */
	public static final String PROFILE_PROD = "prod";
	/** 정보기술팀 아이디 */
	public static final String JUVIS_ADMIN = "Juvisadmindev";
	/** 개발팀 아이디 */
	public static final String JUVIS_DEV = "devtest";
	
	public static final String ERP_URL_REAL = "http://erp.juvis.co.kr";
	public static final String ERP_URL_DEV = "http://next.youngjuvis.net";
	
	//public static final String _HOME_URL = "http://"+$_SERVER["SERVER_NAME"]+"/");
	public static final String _JUVIS_SITE 		= 	"http://www.juvis.co.kr/index.php";
	public static final String _CORP_SITE  		= 	"http://www.juviscorp.co.kr";
	public static final String _MYPAGE_URL 		=	"http://www.dietconsulting.co.kr";
	public static final String _SMYPAGE_URL 	=	"http://new.dietconsulting.co.kr";
	
	public static final String _CENTER_URL 		=	"http://center.juvis.co.kr";
	public static final String _SURVEY_URL 		=	"http://survey.juvis.co.kr";
	public static final String _FOOD_URL 		=	"http://www.foodbalance.co.kr/main_index.php";
	public static final String _EDU_URL 		=	"http://www.juvisacademy.co.kr/main/main_index.asp";
	public static final String _JACE_URL 		=	"http://www.jacecompany.co.kr/main_index.php";
	/* 파일서버 URL */
	public static final String _WWW_URL 		=	"http://www.juvis.co.kr/index.php";
	public static final String _FILE_URL 		=	"http://file.juvis.co.kr";
	public static final String _FILE_URL_FOOD 	=	"http://file.foodbalance.co.kr";
	public static final String _FILE_URL_JACE 	=	"http://file.jacecompany.co.kr";
	public static final String _FILE_URL_CORP 	=	"http://file.juviscorp.co.kr";
	
	/**
	 * 파일 관련 상수들
	 * @author wan
	 *
	 */
	public final class FileConst{
		/** 원래 파일명 */
		public static final String ORG_NAME = "orgName";
		/** 저장된 파일명 */
		public static final String NEW_NAME = "newName";
		/** 저장된 경로명 */
		public static final String PATH = "path";
		/** 파일 뷰 */
		public static final String DOWNLOAD_VIEW  = "downView";
		/** 이미지 뷰 */
		public static final String IMAGE_VIEW  = "imageView";

		/** 동영상 디렉토리 경로 */
		public static final String MOVIE_DIR_PATH = "/movie";
		/** 동영상 재생 URL */
		public static final String MOVIE_PLAY_URL = _FILE_URL+"/micro_movie";
		/** 배너 디렉토리 경로 */
		public static final String BANNER_DIR_PATH = "/banner";
		/** 인바디 이미지파일 URL */
		public static final String _FILE_URL_INBODY = _FILE_URL+"/inbody/";
		/** 스트레스 이미지파일 URL */
		public static final String _FILE_URL_STRESS = _FILE_URL+"/stress/";
	}
	
	/**
	 * 마이크로 영상 앱 관련 상수들
	 * @author wan
	 *
	 */
	public final class MicroMovieAppConst {
		/** 매일 실행되는 동영상 파일 동기화 시간(MMdd) */
		public static final String SYNC_TIME = "0100";
		public static final int BANNER_ROLLING_TIME = 5;
		
	}

	public final class ExcelConst{
		public static final String ColumnNameList 	=	"columHeader";
		public static final String CellDataList   	=	"cellData";
		public static final String ExcelView		= "excelView";
		public static final String ExcelData      	= "excelData";
		public static final String ExcelFileName  	= "ExfileName";
		public static final String ExcelCellWidth 	= "ExCellWidth";
		public static final String ExcelCellColor 	= "ExCellColor";

		//custom 엑셀
		public static final String MergeCell      	= "merge";
		public static final String ExcelTitle     	= "excelTitle";
		public static final String CustomExcelView  = "customExcelView";

	}

	/**
	 * 로그인과 회원에 관련한 상수 클래스
	 */
	public final class MemberConst {
		public static final String USER_ID = "USER_ID";
		public static final String MEMBER_INFO = "MEMBER_INFO";
		public static final String USER_TYPE = "USER_TYPE";
		public static final String PTT_ID = "PTT_ID";
		public static final String EMP_INFO = "EMP_INFO";
		public static final String IS_CHECKED_PW = "IS_CHECKED_PW";
		public static final String IS_ALLOW_UPDATE = "IS_ALLOW_UPDATE";
		public static final String IS_CERTIFICATE = "IS_CERTIFICATE";
	}

	/**
	 * 이미지 뷰 관련 상수 클래스
	 */
	public final class ImageConst{
		/** 비포, 애프터 이미지 */
		public static final String CHART_IAMGE_URL = _FILE_URL+"/chart/";
	}

}
