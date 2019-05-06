//운영계에서 로그 남기지 않도록 console 객체를 override
/*window.console = {
		'debug' : function() {},
		'info'  : function() {},
		'warn'  : function() {},
		'error' : function() {}
};
*/
/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
| init constants
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
API_SERVER = '';
AJAX_RETRY_MAX_COUNT = 30; //재요청 최대 횟수
AJAX_RETRY_DELAY = 1000; // ms

JUVIS = {
	'accessToken' : null,
	'refreshToken' : null,
	'isRefreshToken' : null,
	'intnClsfctnCd' : null,
	'contextPath' : null,
	'ajaxHistory' : [],
	'isPrd'       : true
};

(function($) {

	var ajaxCount = 0; //현재 ajax 요청 횟수
	var ajaxRetryCount = 0; //현재 ajax 재요청 횟수
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| JUVIS console
	-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	JUVIS.console = {
			'debug' : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.debug(msg);  } },
			'info'  : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.info(msg);   } },
			'warn'  : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.warn(msg);   } },
			'error' : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.error(msg);  } },
			'dir'   : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.dir(msg);    } },
			'log'   : function(msg) { if (JUVIS.isPrd) { return; } else { window.console.log(msg);    } }
	} 

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Common Util
	-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    JUVIS.Util =

	{
		/**
		 * 인자값이 boolean 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isBoolean' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Boolean(') == 0;
		},

		/**
		 * 인자값이 String 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isString' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function String(') == 0;
		},

		/**
		 * 인자값이 Number 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isNumber' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Number(') == 0;
		},

		/**
		 * 인자값이 Array 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isArray' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Array(') == 0;
		},

		/**
		 * 인자값이 Object 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isObject' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Object(') == 0;
		},

		/**
		 * 인자값이 Date 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isDate' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Date(') == 0;
		},

		/**
		 * 인자값이 function 인지 여부
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isFunction' : function(obj) {
			if( typeof obj == 'undefined' || obj == null ) {
				return false;
			}
			return obj.constructor.toString().indexOf('function Function(') == 0;
		},

		/**
		 * 인자값이 undefined, null, 또는 '' 인 경우 true를 리턴
		 *
		 * @param obj
		 * @returns {Boolean}
		 */
		'isEmpty' : function( obj ) {
			if( typeof obj == 'undefined') {
				return true;
			}
			if( obj == null ) {
				return true;
			}
			if( obj == 'null' ) {
				return true;
			}
			if( JUVIS.Util.isFunction(obj) ) {
				return false;
			}
			if( !JUVIS.Util.isNumber(obj) && obj == '' ) {
				return true;
			}
			if( !JUVIS.Util.isNumber(obj) && JSON.stringify(obj).length <= 2 ) {
				return true;
			}

			return false;
		},

		/**
		 * JSON을 이용한 간단한 deepCopy
		 * 인자로 사용되는 object에는 function을 포함하고 있지 않아야 한다.
		 *
		 * @param obj
		 * @returns
		 */
		'deepCopy' : function( obj ) {
			if( typeof obj == 'undefined' || obj == null ) {
				return null;
			}
			if( typeof obj != 'object') {
				return obj;
			}

			return JSON.parse(JSON.stringify(obj));
		},

		/**
		 * 숫자에 1000단위 comma 추가
		 * @param nStr
		 * @returns
		 */
		'addComma' : function(nStr, delimiter) {
			nStr += '';
			delimiter = delimiter || ',';
			var x = nStr.split('.');
			var x1 = x[0];
			var x2 = x.length > 1 ? '.' + x[1] : '';
			var rgx = /(\d+)(\d{3})/;
			while (rgx.test(x1)) {
				x1 = x1.replace(rgx, '$1' + delimiter + '$2');
			}
			return x1 + x2;
		},

		/**
		 * 스트링이 지정된 길이가 될 때까지 스트링의 왼쪽을 지정된 문자열로 채움.
		 * @param str
		 * @param fillWith
		 * @param length
		 * @returns
		 */
		'lpad' : function( str, fillWith, length ) {
			fillWith = fillWith || ' ';
			str = '' + str;

			while( str.length < length ) {
				str = fillWith + str;
			}
			return str;
		},


		'isIOS' : function() {
			return (navigator.userAgent.indexOf('iPhone;') > 0
					|| navigator.userAgent.indexOf('iPad;') > 0);
		},
		
		/**
		 * date format 체크
		 * @param date 날짜 문자열 (YYYYMMDD)
		 * @returns 날짜 유효성 여부 true, false
		 */
		'isDateFormat' : function (date) {
			
			if (JUVIS.Util.isEmpty(date)) {
				return false
			} 
			
		    var dateRegex = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|1\d|2\d|3[01])$/ ;
			if (dateRegex.test(date)) {
				return true;
			} else {
				return false;
		    }
		},



		'toYyyymmdd' : function(date, delimiter) {
			if (date == null) {
				return '';
			}
			if(typeof date == 'number' || typeof date == 'string') {
				if(date.toString().length == 8) {
					date = date.toString();
					date = new Date(date.substr(0,4) + "/" + date.substr(4,2) + "/" + date.substr(6,2));

				}
				else if(date == ''){
					return '';
				}
				else {
					date = new Date(date);
				}
			}

			if(typeof date != 'object' || date.constructor.toString().indexOf('function Date') != 0) {
				return '';
			} else if (isNaN(date.getYear())) {
				return '';
			}

			delimiter = delimiter || '';

			return date.getFullYear()
					+ delimiter
					+ JUVIS.Util.lpad(date.getMonth() + 1, '0', 2)
					+ delimiter
					+ JUVIS.Util.lpad(date.getDate(), '0', 2);
		},

		'toYyyymmddhhmm' : function(date, delimiter) {
			if (date == null) {
				return '';
			}
			if(typeof date == 'number') {
				date = new Date(date);
			}

			if(typeof date != 'object' || date.constructor.toString().indexOf('function Date') != 0) {
				return '';
			}

			var delimiter = delimiter || '';

			return date.getFullYear()
					+ delimiter
					+ JUVIS.Util.lpad(date.getMonth() + 1, '0', 2)
					+ delimiter
					+ JUVIS.Util.lpad(date.getDate(), '0', 2)
					+ delimiter
					+ JUVIS.Util.lpad(date.getHours(), '0', 2)
					+ delimiter
					+ JUVIS.Util.lpad(date.getMinutes(), '0', 2);
		},



		'getParamToJson' : function() {
			var params = {};
			var url = window.document.URL.toString();

			if(url.indexOf('?') < 0){
				return params;
			}else{
			    var urlParams = url.split('?')[1].split('&');
			    for (var i = 0; i < urlParams.length; i++)
			    {
			        var key =  urlParams[i].split('=')[0];
			        var value = urlParams[i].split('=')[1];
			        params[key] = value;
			    }
			}

			return params;
		},



		/**
		 * 숫자를 소수점 자리수에 맞춤 (숫자 내림 처리)
		 * @param value
		 * @param digit
		 * @returns
		 */
		'replaceDecimalDigit' : function(value, digit){
			if (!digit) {
				digit = 0;
			}

			var tempString = value.toString();

			// 마지막 문자가 소수점으로 끝나는지 체크
			if (tempString.charAt(tempString.length - 1) == '.') {
				return value;

			//소수점 내림 처리
			}else{
				value = parseFloat(value);
				return Math.floor(value * Math.pow(10, digit)) / Math.pow(10, digit).toString();
			}
		},



		/**
		 * BMI 계산 (키 단위 : m, 몸무게 : kg)
		 * @param tall
		 * @param weight
		 * @returns
		 */
		'getBMI' : function(tall, weight){
			if(tall == 0){
				return 0;
			}else{
				return parseFloat(weight) / Math.pow(tall, 2);
			}
		},



		/**
		 * 인풋박스에 입력가능한 숫자범위 정보 입력
		 */
		'setInputRange' : function($obj, num, precision) {
			$obj.data({
				'number' : num,
				'precision' : precision
			});
		},


		/**
		 * Cross Site Scripting 방지를 위한 parameter 확인 및 보정
		 */
		'filterXSS' : function(dataObject) {
			var regexp = /(<)(|\/)(\!|\?|html|head|title|meta|body|style|link|base|script|frameset|frame|noframes|iframe|applet|embed|object|param|noscript|noembed|map|area|basefont|xmp|plaintext|comment)/i;

			for(var key in dataObject) {
				if(dataObject.hasOwnProperty(key)) {
					if(JUVIS.Util.isObject(dataObject[key]) || JUVIS.Util.isArray(dataObject[key])) {
						dataObject[key] = JUVIS.Util.filterXSS(dataObject[key]);
					}
					else if(JUVIS.Util.isString(dataObject[key])) {
						dataObject[key] = _filterXSS(dataObject[key]);
					}
				}
			}

			function _filterXSS(str) {
				return str.replace(regexp, '&lt;$2$3');
			}

			return dataObject;
		},



		/**
		 * 유효한 숫자인지 체크
		 */
		'validNumberChk' : function(val, num, digit) {
			val = val.toString();

			// 빈값인경우 판단 안함.
			if (!val) {
				return true;
			}
			var numChk = /^[0-9]{1,}(\.)?([0-9]{1,})?$/;

			// 숫자인지 판단
			if (!numChk.test(val)) {
				return false;
			}

			// 소수점 체크
			if (val.indexOf('.') > -1 ) {
				var digitVal = val.substr(val.indexOf('.') + 1);
				var intVal   = val.substr(0, val.indexOf('.'));

				if (digitVal.length > digit) {
					return false;
				}

				if (intVal.length > num) {
					return false;
				}
			} else {
				if (val.length > num) {
					return false;
				}
			}

			return true;

		},
		
		/**
		 * null 공백으로 변환
		 * @return 공백값 or 현재값
		 */
		'replaceNull' : function (obj) {
			
			if (obj == undefined || obj == null || obj == 'undefined' || obj == 'null') {
				return '';
			}
			
			return obj;
		},
		
		/**
		 * 페이징 반환
		 * @return page시작, page 종료
		 */
		'getPage' : function (pageCount, pageSize) {
			
			var page = {
					'startNum' : 0,
					'endNum' : 0,
					
			};
			
			if (!pageCount || !pageSize) {
				return pageNumber;
			}
			
			page.endNum = parseInt(pageCount) * parseInt(pageSize);
			page.startNum = page.endNum - parseInt(pageSize) + 1; 

			return page;
		},
		
		/**
		 * 크로스사이트 스크립트 처리 reverse
		 * @return page시작, page 종료
		 */
		'reaplceXSSReverse' : function (text) {
			text = text.replace(/&amp;/gi, "&");
	    	text = text.replace(/&#35;/gi, "#");
	    	text = text.replace(/&quot;/gi, "\"");
	    	text = text.replace(/&#39;/gi, "'");
	    	text = text.replace(/&lt;/gi, "<").replace(/&gt;/gi, ">");
	        text = text.replace(/&#40;/gi, "\(").replace(/&#41;/gi, "\)" );  
	        
	        text = text.replace(/&#33;/gi, "!");
			text = text.replace(/&#64;/gi, "@");
			text = text.replace(/&#36;/gi, "$");
			text = text.replace(/&#37;/gi, "%");
			text = text.replace(/&#94;/gi, "^");
			text = text.replace(/&#42;/gi, "*");
			text = text.replace(/&#123;/gi, "{");
			text = text.replace(/&#125;/gi, "}");
			text = text.replace(/&#91;/gi, "[");
			text = text.replace(/&#93;/gi, "]");
			text = text.replace(/&#47;/gi, "/");
	        
	        return text;
		}
	};

	JUVIS.ErrorMessage = {
		'9223'	:	'인증번호가 이미 전송되었습니다.', 									// 인증번호 재전송 후 1분 이내 재전송 버튼 클릭 시
		'9206'	:	'인증시간이 3분을 초과했습니다.<br />인증번호 재전송 받으세요', 		// 인증번호 전송 후 3분경과 시
		
		// 기업회원 전용 (getOtp/validOtp 전용)
		'9201'	:	'이미 사용중인 이메일입니다.<br/>기존 회원은 로그인하시기 바랍니다.', 	// 이미 사용중인 아이디일 경우

		'9203'	:	'잘못된 인증번호입니다.<br />다시 입력해 주세요.', 					// 인증번호가 존재하지 않은경우

		// 기업회원 전용 (insertRegister/validOtp)
		'9207'	:	'이메일이 확인되지 않습니다. 다시 입력해주세요.', 					// 싱글아이디가 없는 경우
		
		//마이바디
		'9751'	:	'건강건진(인바디) 데이터가 이미 존재 합니다', 					// 싱글아이디가 없는 경우
		
		// 비밀번호 변경
		'9226'  :   '기존 비밀번호 입력이 잘못되었습니다.', 	    // 기존 비밀번호 동일한 경우
		'9209'  :   '비밀번호는 계정아이디와 다르게 입력해주세요.', // 패스워드와 계정아이디 같은 경우 
		'9210'  :   '기존 비밀번호와 동일합니다.',					// 기존 비밀번호와 동일한 경우
		'9211'  :   '전전 비밀번호와 동일합니다.',					// 전전 비밀번호와 동일한 경우
		
		// 목표 설정
		'9712'  :   '목표설정은 1일 5회로 제한 됩니다.',		// 일일 목표설정 횟수가 5회 이상일 경우
			
		// 설문
		'9741'  :   '설문 기간이 종료되었습니다.',		// 설문 기간이 종료되었을 경우
		'9742'  :   '설문에 이미 참여하셧습니다.',		// 설문을 이전에 참여 하였을 경우
		
		// 이벤트
		'9731'	: 	'이벤트에 이미 참여하였습니다.',
		'9732'	: 	'선착순 적립이 완료되었습니다.\n다음에 참여해 주세요~',
		'9737'	: 	'이벤트 참여기간이 아닙니다.',
		'9739'	: 	'당첨된 상품이 없습니다.',
		'9740'	: 	'당첨된 상품배송이 시작되었습니다.',
		
		// 포인트
		'9733'	: 	'현재 웰스토리몰 회원이 아닙니다.',
		'9734'	: 	'전환할 포인트가 없습니다.',
		'9735'	: 	'포인트 전환이 정상적으로 되지 않았습니다.\n잠시 후 다시 이용해 주세요.',
		'9736'	: 	'포인트 전환이 정상적으로 취소되었습니다.',
		'9738'	: 	'1일 1회 포인트 전환이 가능합니다.',
			
		// 식사
		'9301'	: 	'식사 추가 일자가 가입일 이전입니다.'
	};
	
	JUVIS.PageRefreshErrorCode = ['9731', '9732' ,'9737'];
	
	
	JUVIS.SUCCESS_COMMON_CODE = '1'; // API 성공 코드
	JUVIS.FAIL_PARAM_CODE = '9001';     // API parameter 실패 코드
	JUVIS.FAIL_TOKEN_NULL = '9002';	  // 토큰값이 없는 경우
	JUVIS.FAIL_TOKEN_EXPIRE = '9004';  // 토큰값이 인식 불가능한 경우
	JUVIS.FAIL_MULTI_LOGIN = '9003';
	
	/**
	 * 지정된 위치의 아이템을 삭제
	 *
	 * @param index 삭제할 아이템들 중 첫번째 위치
	 * @returns 삭제된 아이템
	 */
	Array.prototype.removeItemAt = function(index) {
	    return this.splice(index, 1);

	};

	/**
	 * 배열로부터 지정된 아이템을 삭제
	 *
	 * @param item 삭제할 아이템
	 * @returns 삭제된 아이템
	 */
	Array.prototype.removeItem = function( item ) {
		var idx = this.indexOf( item );
		if( idx < 0 ) {
			return null;
		}

		this.removeItemAt( idx, 1 );
	};

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| API Server URLs
	-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	JUVIS.API = {
		/**
		 * API  포인트 리스트 조희
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'getProfilePoint' : function() {
			return API_SERVER + '/membership/searchMembershipPointList';
		},
		/**
		 * API  캐시 리스트 조희
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'getProfileCash' : function() {
			return API_SERVER + '/membership/searchMembershipCashList';
		},

		/**
		 * API 스탬프 리스트 조희
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'getProfileStamp' : function() {
			return API_SERVER + '/membership/searchMembershipStampList';
		},

		/**
         * API otp 인증번호 요청
         * @Method - GET,POST
         * @Pram -
         * @Return -
         */
        'getOtp' : function(_type) {
            if ( _type == 'id')
                return API_SERVER + '/member/searchMemberIdGetOtp';
			else if ( _type == 'join')
				return API_SERVER + '/member/sendOtp';
            else
                return API_SERVER + '/member/searchMemberPwdGetOtp';
        },

        /**
         * API otp 인증번호 확인인
        * @Method - GET,POST
         * @Pram -
         * @Return -
         */
        'validOtp' : function(_type) {
            if ( _type == 'id')
                return API_SERVER + '/member/searchMemberIdvalidOtp';
			else if ( _type == 'join')
				return API_SERVER + '/member/validOtp';
            else
                return API_SERVER + '/member/searchMemberPwdValidOtp';
        },

		/**
		 * ID 중복 체크
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'validMemId' : function() {
			return API_SERVER + '/member/searchDuplicateIdCheck';
		},

		/**
		 * ID 중복 체크
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'createMember' : function() {
			return API_SERVER + '/member/createMember';
		},

		/**
		 * 중독증 목록 조회
		 * @Method - GET,POST
		 * @Param -
		 * @Return -
		 */
		'toxicList' : function() {
			return API_SERVER + '/hybrid/research/toxicList';
		},

		/**
		 * 중독증 결과 조회
		 * @Method - GET,POST
		 * @Param -
		 * @Return -
		 */
		'toxicResult' : function() {
			return API_SERVER + '/hybrid/research/toxicResult/';
		},

		/**
		 * 중독증 설문 조회
		 * @Method - GET,POST
		 * @Param -
		 * @Return -
		 */
		'toxicView' : function() {
			return API_SERVER + '/hybrid/research/toxicView';
		},

		/**
		 * 중독증 설문 등록
		 * @Method - GET,POST
		 * @Param -
		 * @Return -
		 */
		'toxicWrite' : function() {
			return API_SERVER + '/api/research/putToxic';
		},
		/**
		 * 서바이벌 약정 보기
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'checkSurvival' : function() {
			return API_SERVER + '/survival/check';
		},

		/**
		 * 서바이벌 가입 신청
		 * @Method - GET,POST
		 * @Pram -
		 * @Return -
		 */
		'joinSurvival' : function() {
			return API_SERVER + '/survival/join';
		},

		/**
		 * 연기 신청 인증 번호 요청
		 */
		'sendDlyAuthSms' :  function () {
			return API_SERVER + '/formDelay/signature/write';
		},

		/**
		 * 연기 신청 인증 번호 확인
		 */
		'checkDlyAuthNum' :  function () {
			return API_SERVER + '/formDelay/signature/check';
		},

		/**
		 * 연기 신청
		 */
		'createDelay' :  function () {
			return API_SERVER + '/formDelay/write';
		},

		/**
		 * 연기 신청
		 */
		'checkDelay' :  function () {
			return API_SERVER + '/formDelay/check';
		},

		/**
		 * 연기 정정 신청
		 */
		'createDelayCancel' :  function () {
			return API_SERVER + '/formDelayCancel/write';
		}
	};


	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Ajax Util
    -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    JUVIS.EXPECT_URLs = [
        JUVIS.API.getOtp('id')
        ,JUVIS.API.validOtp('id')
        ,JUVIS.API.getOtp('pwd')
        ,JUVIS.API.validOtp('pwd')
		,JUVIS.API.getOtp('join')
		,JUVIS.API.validOtp('join')
		,JUVIS.API.validMemId()
		,JUVIS.API.createMember()
		,JUVIS.API.toxicResult()
		,JUVIS.API.toxicView()
		,JUVIS.API.checkSurvival()
		,JUVIS.API.joinSurvival()

    ];
	JUVIS.SUCCESS_COMMON_CODE_LIST = [
		 '9200' // 사용가능 아이디
		 // '9431'
	//
	];

    JUVIS.ajax = function(options, showLoader) {
        //네이티브 쪽에서 JUVIS.accessToken을 아직 받지 못하였을때
         if(!JUVIS.accessToken && !JUVIS.EXPECT_URLs.includes(options.url)) {
            setTimeout(function() {
                if(ajaxRetryCount++ >= AJAX_RETRY_MAX_COUNT) {
                    // TODO 에러 화면 처리 ex) $('section').hide();
                    alert('일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다. 1');
                    return;
                }
                JUVIS.ajax(options, showLoader);
            }, AJAX_RETRY_DELAY);
            return;
        }
        ajaxRetryCount = 0;

        //기존 요청 재요청 불가
        if (JUVIS.ajaxHistory.indexOf(options.url) > -1) {
            return false;
        }

        JUVIS.ajaxHistory.push(options.url);

        if(!showLoader) {
            showLoader = true;
        }

        var _options = {
            'url'      : '',
            'method'   : 'GET', // GET, POST, PUT, DELETE
            'dataType' : 'json', // xml, html, script, json, jsonp, text
            'data'     : {},
            'headers'  : { 'AUTH_TOKEN': JUVIS.accessToken }
        };
        $.extend(_options, options);

        $.extend(_options, {
            'beforeSend' : function(xhr, settings) {
                if (showLoader && ajaxCount++ == 0) {
                    //로딩바 시작
                    NativeInterface.loadingStart();
                }

                if(typeof options.beforeSend == 'function') {
                    options.beforeSend(xhr, settings);
                }
            },
            'success' : function(result, status, xhr) {
                //if (xhr.status == 200 && result.code == JUVIS.SUCCESS_COMMON_CODE) {
                if (xhr.status == 200 && ( result.code == JUVIS.SUCCESS_COMMON_CODE || JUVIS.SUCCESS_COMMON_CODE_LIST.includes(result.code))) {
                    if (typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                }
                else if (typeof result != 'undefined' && result.hasOwnProperty('application')) {
                    if (application.result
                            && application.result == 'success'
                            && typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                    else if(typeof options.error == 'function') {
                        options.error(xhr, status, result);
                    }
                }
                else {
                    options.error(xhr, status, result);
                }
            },
            'error' : function(xhr, status, error) {
                var statusCode = xhr.status;
                var errorMessage = xhr.responseJSON.message;
                var errorCode = xhr.responseJSON.code;


                // API에서 토큰 만료인 경우
                if (statusCode == 403 && errorCode == JUVIS.FAIL_TOKEN_EXPIRE) {
                    JUVIS.accessToken = null;
                    NativeInterface.requestRefreshAccessToken();

                    setTimeout(function() {
                        if(showLoader && --ajaxCount == 0) { 	// ajax call 하는 경우 ajaxCount가 다시 증가되기 때문에 미리 하나를 빼줌.
                            JUVIS.Util.hideLoader();
                        }
                        JUVIS.ajax(options, showLoader);
                    }, AJAX_RETRY_DELAY);
                } else if ( statusCode == 403 && errorCode == SHP.FAIL_MULTI_LOGIN){
                    NativeInterface.requestMultiLogin();
                } else if ( statusCode == 400 && errorCode == SHP.FAIL_PARAM_CODE){
                    /*필수파라미터 없는 경우*/
                    /*필수파라미터 => 값으로 맵핑*/
                    alert('필수값이 없습니다')
                } else if ( statusCode == 400 ){
                    var errorMsg = SHP.ErrorMessage[errorCode]
                    alert(errorMsg);

                    // refresh 필요한 에러코드인 경우
                    if (SHP.PageRefreshErrorCode.indexOf(errorCode) >= 0) {
                        NativeInterface.requestGoRefresh();
                    }
                } else if ( statusCode == 204 ){
                    //데이터 없음.
                    options.error(xhr, status, result);

                }  else {
                    alert('일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다. 2');
                }

                if(typeof options.error == 'function') {
                    options.error(xhr, status, error);
                }




            },
            'complete' : function(xhr, status) {
                if(typeof options.complete == 'function') {
                    options.complete(xhr, status);
                }
                if(showLoader && --ajaxCount == 0) {
                    //SHP.Util.hideLoader(); -> 네이티브 로딩바로 구현 후에 삭제
                    NativeInterface.loadingEnd();
                }
                JUVIS.ajaxHistory.removeItem(options.url);
            }
        });

        $.ajax(_options);
    };

})(jQuery);
