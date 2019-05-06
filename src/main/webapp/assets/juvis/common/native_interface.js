/*
 * Native -> Hybrid
 * 데이터 수신용 JavaScript를 호출하여 데이터 전달
 * ex) NativeInterface.function_name(data)
 *
 * Hybrid -> iOS
 * 양측에서 사전에 정의한 jscall 프로토콜을 사용하여
 * uri로 호출하고자 하는 메소드를 지정하고,
 * 쿼리 스트링으로 데이터를 전달
 * ex) jscall://api/[method name]?key1=value1&key2=value2
 *
 * Hybrid -> Android
 * 양측에서 사전에 정의한 JavaScript 용 인터페이스를 호출하여 데이터 전달
 * ex) AndroidInterface.function_name(data);
 */
var MENU_ID = {
	// 예제
	// 'mybodyObesity' : function() {
	// 	return 'S001';
	// }
};

var jsCallArray = []; // jsCall 배열

// jsCall 동기처리를 위한 promise 선언
var jsCallPromise = function (url) {
	
	return new Promise(function (resolve) {
		setTimeout(function()  {
			// jsCall 실행
			document.location.href = url; 
			resolve();
	    }, 50);
	}).
	then(function () {
		// jsCall 0번째 배열 삭제
		jsCallArray.splice(0, 1);
		
		// jsCall 배열있는 경우
		if (jsCallArray.length > 0) {
			return jsCallPromise(jsCallArray[0]);
		}
		return;
		
	});
}

var jsCall = function (url) {
	
	jsCallArray.push(url);
	
	if (jsCallArray.length == 1) {
		jsCallPromise(url);
	}
}

var NativeInterface = {
	/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	 * hybrid --> native
	 =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/**
	 *  로딩바 네이티브 화면 실현
     */		
	'loadingStart' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/loadingStart');
		} else {
		  AndroidInterface.loadingStart();
		}
	 },	
	 
	 /**
	  *  로딩바 네이티브 화면 중지
      */		
	'loadingEnd' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/loadingEnd');
		} else {
			AndroidInterface.loadingEnd();
		}
	 },

	/**
	 *  페이지 이동 요청 (해당 URL 로 페이지 이동 요청)
	 */
	'requestGoPage' : function(url) {
		if (JUVIS.Util.isIOS() ) {
			var urlEncode = encodeURI(url);
			var iosParams = '?url=' + urlEncode;
			jsCall('jscall://api/requestGoPage' + iosParams);
		} else {
			AndroidInterface.requestGoPage(url);
		}
	},

	/**
	 *  현재 페이지 종료 후 페이지 이동 요청 (해당 URL 로 페이지 이동 요청)
	 */
	'requestFinishGoPage' : function(url) {
		if (JUVIS.Util.isIOS() ) {
			var urlEncode = encodeURI(url);
			var iosParams = '?url=' + urlEncode;
			jsCall('jscall://api/requestFinishGoPage' + iosParams);
		} else {
			AndroidInterface.requestFinishGoPage(url);
		}
	},

	 /**
	  * 네이티브측 헤더의 이름을 바꾸기 위한 함수 (기본 쥬비스)
	  */	
	'requestChangeTitle' : function(title) {
		if (!title) {
			title = '쥬비스'
		}
		document.title = title;
		if(JUVIS.Util.isIOS()) {
			title = encodeURI(title);
			jsCall('jscall://api/requestChangeTitle?title='+title);
		} else {
			AndroidInterface.requestChangeTitle(title);
		}
	 },





	/**
	 * 하이브리드에서 백버튼 콜백 받기위한 Native Flag 설정: true (해당 함수 호출 후 Back Button 발생 시 Native에서 Hybrid backButtonClicked 함수 호출)
	 */
	'requestBackClickProxy' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestBackClickProxy/');
		}
		else {
			AndroidInterface.requestBackClickProxy();
		}
	},
	
	/**
	 * 하이브리드에서 백버튼 콜백 받기위한 Native Flag 취소 : false 
	 */
	'cancelBackClickProxy' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/cancelBackClickProxy/');
		}
		else {
			AndroidInterface.cancelBackClickProxy();
		}
	},

	
	/**
	 * Native 토큰 재발급 요청 (하이브리드에서 API 호출 후 토큰 만료 시) 
	 */
	'requestRefreshAccessToken' : function() {
	
		if (JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestRefreshAccessToken/');
		}
		else {
			AndroidInterface.requestRefreshAccessToken();
		}
	},
	
	/**
	 * Native 토큰 설정 요청 (하이브리드 페이지 요청 후 토큰 만료인 경우 서버에서 refreshToken 생성하므로 Native Token 재설정 요청) 
	 */
	'requestSetAccessToken' : function(accessToken, refreshToken) {
		
		var iosParams = '?accessToken=' + accessToken + '&refreshToken=' + refreshToken;
	
		if (JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestSetAccessToken' + iosParams);
		}
		else {
			AndroidInterface.requestSetAccessToken(accessToken, refreshToken);
		}
	},
	
	/**
	 * Native 중복로그인처리 요청 (하이브리드에서 중복로그인 생성시) 
	 */
	'requestMultiLogin' : function() {
	    if (JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestMultiLogin/');
		}
		else {
			AndroidInterface.requestMultiLogin();
		}
	},
	

	
	/**
	 *  페이지 새로고침 요청 (현재 하이브리드 종료 후 이전 하이브리드 refresh ex) 조회->수정 이동 시 수정화면 페이지 종료 후 조회화면 재조회 )
	 */
	'requestGoRefresh' : function() {
	
		if (JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestGoRefresh');
		}
		else {
			AndroidInterface.requestGoRefresh();
		}
	},
	
	/**
	 *  페이지 종료 요청 (현재 하이브리드 종료)
	 */
	'requestGoFinish' : function() {
		
		if (JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestGoFinish/');
		}
		else {
			AndroidInterface.requestGoFinish();
		}
	},
	

	
	/**
	 *  네이티브 페이지 요청 
	 *  @param : String MenuCd(네이티브페이지 메누 코드   : 필수  )
	 * 			 String date(날짜..식사입력시   : 선택 : YYYYMMDD or '' )
     */
	// 'requestGoNativePage' : function(MenuCd,date,ctryCd,closeYn) {
	// 	if (!closeYn) {
	// 		closeYn = 'N';
	// 	}
	//
	// 	if (JUVIS.Util.isIOS() ) {
	// 		var iosParams = '?menuCd=' + MenuCd;
	// 		if (!JUVIS.Util.isEmpty(date)) {
	// 			iosParams += '&date='+date
	// 		}
	// 		if (!JUVIS.Util.isEmpty(ctryCd)) {
	// 			iosParams += '&ctryCd='+ctryCd
	// 		}
	// 		iosParams += '&closeYn='+closeYn
	// 		jsCall('jscall://api/requestGoNativePage' + iosParams);
	// 	} else {
	//
	// 		AndroidInterface.requestGoNativePage(MenuCd,date,ctryCd,closeYn);
	// 	}
	//
	// },
	'requestGoNativePage' : function(closeYn) {
		if (!closeYn) {
			closeYn = 'N';
		}

		if (JUVIS.Util.isIOS() ) {
			var iosParams = '?closeYn='+closeYn;
			jsCall('jscall://api/requestGoNativePage' + iosParams);
		} else {

			AndroidInterface.requestGoNativePage(closeYn);
		}

	},


	
	/**
	 * 네이티브에서 달력 요청
	 * @param : String now(현재 선택된 날짜            : 필수 : YYYYMMDD       )
	 * 			String dateFrom(선택 가능 시작 날짜     : 선택 : YYYYMMDD or '' )
	 */
	'requestChooseDate' : function(now, dateFrom) {
		if(JUVIS.Util.isIOS()) {
			var params = '?now=' + now;
			
			if (!JUVIS.Util.isEmpty(dateFrom)) {
				params += '&dateFrom='+dateFrom
			}
			
			jsCall('jscall://api/requestChooseDate' + params);
		}
		else {
			if(!dateFrom) {
				dateFrom = ''
			}
			AndroidInterface.requestChooseDate(now, dateFrom);
		}
	},
	
	/**
	 * 팝업 Dim 처리 요청 (하이브리드 팝업 띄울 시 네이티브 상단 Dim 처리)
	 */
	'requestPopupShowDim' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestPopupShowDim/');
		}
		else {
			AndroidInterface.requestPopupShowDim();
		}
	},
	
	/**
	 * 팝업 Dim 취소 요청 (하이브리드 팝업 종료 시 네이티브 상단 Dim 취소 처리)
	 */
	'requestPopupCancelDim' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestPopupCancelDim/');
		}
		else {
			AndroidInterface.requestPopupCancelDim();
		}
	},
	
	/**
	 * 하이브리드 팝업 확인시 콜백
	 */
	'requestPopUpCheck' : function() {
		if(JUVIS.Util.isIOS()) {
			jsCall('jscall://api/requestPopUpCheck/');
		}
		else {
			AndroidInterface.requestPopUpCheck();
		}
	},

	/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	 * native --> hybrid
	 =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	/**
	 * Hybrid 토큰값 재설정
	 */
	'setAccessToken' : function(accessToken) {
		if (JUVIS.Util.isEmpty(accessToken)) {
			console.error('setAccessToken - Invalid token sent!!!');
		} else {
            JUVIS.accessToken = accessToken;
		}
	},
	
	/**
	 * Native에서 Back Button 발생 시 해당 Hybrid 함수 호출
	 */
	'backButtonClicked' : function() {
		$(window).trigger('back_key_clicked');
	},

	
	
	/**
	 *  window 'date_changed' 이벤트를 통해 네이티브에서 선택한 날짜 데이터 전달
	 */
	'setSelectedDate' : function(yyyymmdd) {
		if (JUVIS.Util.isEmpty(yyyymmdd) || yyyymmdd == 'null') {
			return;
		}
		$(window).trigger('date_changed', yyyymmdd);
	},

	/**
	  * 목표 설정 후 네이티브로 기초대사량, 목표 걸음 수, 목표 물 섭취량 값 전달
	  */	
	'requestGoalInfo' : function(goalCal, goalStepsCnt, goalWaterIntake) {
		if(JUVIS.Util.isIOS()) {
			
			var params = '?goalCal=' + goalCal;
			
			if (!JUVIS.Util.isEmpty(goalStepsCnt)) {
				params += '&goalStepsCnt='+goalStepsCnt
			}
			if (!JUVIS.Util.isEmpty(goalWaterIntake)) {
				params += '&goalWaterIntake='+goalWaterIntake
			}
			
			jsCall('jscall://api/requestGoalInfo'+params);
		} else {
			AndroidInterface.requestGoalInfo(goalCal, goalStepsCnt, goalWaterIntake);
		}
	 },
	 

	 
	 /**
	  * 웹페이지 이동 url
	  */	
	'requestWebUrl' : function(url) {
		if(JUVIS.Util.isIOS()) {
			var params = '?url=' + url;
			jsCall('jscall://api/requestWebUrl'+params);
		} else {
			AndroidInterface.requestWebUrl(url);
		}
	 },
	 
		/**
		 *  현재 페이지 새로고침 요청
		 */
		'requestRefresh' : function(backRefreshYn) {
			if (!backRefreshYn) {
				backRefreshYn = 'N';
			}
			try {
				if (JUVIS.Util.isIOS()) {
					jsCall('jscall://api/requestRefresh?backRefreshYn='+backRefreshYn);
				} else {
					AndroidInterface.requestRefresh(backRefreshYn);
				}
			} catch (exception) {
				if (JUVIS.Util.isIOS()) {
					jsCall('jscall://api/requestRefresh');
				} else {
					AndroidInterface.requestRefresh();
				}
			}
		}
		

};


//dummy object for PC
(function() {
	if(!JUVIS.Util.isIOS()) {
		if(typeof AndroidInterface == 'undefined') {
			AndroidInterface = {};
		}

		if(typeof AndroidInterface.requestAccessToken == 'undefined') {
			AndroidInterface.requestAccessToken = function(needRefresh) {
				if(!needRefresh) {
					NativeInterface.setAccessToken('76ddd14a-639b-42bd-8e04-3b9b4aa535ca'); //임시 토큰
				}
			};
		}

		if(typeof AndroidInterface.requestShowMenuButton == 'undefined') {
			AndroidInterface.requestShowMenuButton = function() {
			};
		}

		if(typeof AndroidInterface.requestShowBackButton == 'undefined') {
			AndroidInterface.requestShowBackButton = function() {
//				alert('requestShowBackButton 함수가 정의되지 않아 더미 함수를 사용합니다.');
			};
		}

		if(typeof AndroidInterface.requestBackClickProxy == 'undefined') {
			AndroidInterface.requestBackClickProxy = function() {
//				alert('requestBackClickProxy 함수가 정의되지 않아 더미 함수를 사용합니다.');
//				NativeInterface.backButtonClicked();
			};
		}

		if(typeof AndroidInterface.cancelBackClickProxy == 'undefined') {
			AndroidInterface.cancelBackClickProxy = function() {
//				alert('cancelBackClickProxy 함수가 정의되지 않아 더미 함수를 사용합니다.');
			};
		}

		if(typeof AndroidInterface.requestClearAndMove == 'undefined') {
			AndroidInterface.requestClearAndMove = function(menuId) {
//				alert('requestClearAndMove 함수가 정의되지 않아 더미 함수를 사용합니다.\nINDEX 페이지로 이동합니다.');
				document.location.href = '../index.html';
			};
		}

		if(typeof AndroidInterface.requestChangeTitle == 'undefined') {
			AndroidInterface.requestChangeTitle = function(title) {
//				alert('requestChangeTitle 함수가 정의되지 않아 더미 함수를 사용합니다.');

			};
		}

		if(typeof AndroidInterface.requestWelstoryWeeklyMenu == 'undefined') {
			AndroidInterface.requestWelstoryWeeklyMenu = function() {
//				alert('requestWelstoryWeeklyMenu 함수가 정의되지 않아 더미 함수를 사용합니다.');

			};
		}

		if(typeof AndroidInterface.requestEatSightSearch == 'undefined') {
			AndroidInterface.requestEatSightSearch = function() {
//				alert('requestEatSightSearch 함수가 정의되지 않아 더미 함수를 사용합니다.');
//
			};
		}


		if(typeof AndroidInterface.requestEatSightDetail == 'undefined') {
			AndroidInterface.requestEatSightDetail = function() {

			};
		}
		
		if(typeof AndroidInterface.loadingStart == 'undefined') {
			AndroidInterface.loadingStart = function() {
				console.log('loadingStart ')
			};
		}
		
		if(typeof AndroidInterface.loadingEnd == 'undefined') {
			AndroidInterface.loadingEnd = function() {
				console.log('loadingEnd ')
			};
		}
		
		if(typeof AndroidInterface.requestShowFitnessChoice == 'undefined') {
			AndroidInterface.requestShowFitnessChoice = function() {
			};
		}

		if(typeof AndroidInterface.requestPopupShowDim == 'undefined') {
			AndroidInterface.requestPopupShowDim = function() {
				console.log('requestPopupShowDim')
			};
		}
		
		if(typeof AndroidInterface.requestPopupCancelDim == 'undefined') {
			AndroidInterface.requestPopupCancelDim = function() {
				console.log('requestPopupCancelDim')
			};
		}
		
		if(typeof AndroidInterface.requestGoFinish  == 'undefined') {
			AndroidInterface.requestGoFinish  = function() {
				console.log('requestGoFinish ')
			};
		}
		
		if(typeof AndroidInterface.requestPopUpCheck   == 'undefined') {
			AndroidInterface.requestPopUpCheck  = function() {
				console.log('requestPopUpCheck  ')
			};
		}

		if(typeof AndroidInterface.requestGoPage   == 'undefined') {
			AndroidInterface.requestGoPage  = function(url) {
				console.log('requestGoPage  ')
				location.href=url;
			};
		}




		
		
	}
})();