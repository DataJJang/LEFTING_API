/**
 * 사용 페이지  :  서바이벌 참가 자격 및 약관 조회
 * 사용 페이지 URL  : /hybrid/survival/survival_info
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/survival/survival_info.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : '서바이벌 소개',
    rtn_url : '/hybrid/survival',
    check_url : '/hybrid/survival/check'
}

$(document).ready(function(event){
    NativeInterface.requestChangeTitle(PAGE_CONSTATNT.getTitle);
});
/*******************************************************
 * HYBRID METHOD
 *******************************************************/


// 서바이벌 참가 자격 check 및 서바이벌 참가 신청 약정 보기
$(document).on('click', '#check_survival', function (event) {

    event.preventDefault();
    var jsonData = JSON.stringify({});
    JUVIS.ajax({
        url      : JUVIS.API.checkSurvival(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            if(result.code == 1) {
              NativeInterface.requestGoPage(PAGE_CONSTATNT.check_url);
            } else {
              alert(result.message);
            }
        },
        error : function(xhr, status, error) {
            alert(error.message);
        }
    });
});

/*******************************************************
 * READY
 *******************************************************/
/*******************************************************
 * HYBRID EVENT
 *******************************************************/
// 페이지 닫기
$(document).on('click', '#close', function(event) {

    NativeInterface.requestGoFinish();
});

 $(window).on('back_key_clicked',function(e){
    NativeInterface.requestGoRefresh();
 });
/*******************************************************
 * NATIVE EVENT
 *******************************************************/