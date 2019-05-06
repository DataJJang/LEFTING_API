/**
 * 사용 페이지  :  모든 이용 약관 페이지
 * 사용 페이지 URL  : /hybrid/member/join
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/member/join.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : {
                 use : '이용안내 약관',
                 privacy : '개인정보 수집/이용 약관',
                 marketing : '마케팅 정보 수신 동의'
    }
}

/*******************************************************
 * HYBRID METHOD
 *******************************************************/

var getTermName = function() {
    var termName ;
    var url = window.document.URL.toString();
    if(url.indexOf('?') > -1){
        url = url.split('?')[0]
    }
    termName = url.substr(url.lastIndexOf('/')+1,url.length);
    return termName;
}

/*******************************************************
 * READY
 *******************************************************/

$(document).ready(function(event){
    var termName = getTermName();
    var title = PAGE_CONSTATNT.getTitle[termName];
    if ( title ) {
        NativeInterface.requestChangeTitle(title);
    }

});
/*******************************************************
 * HYBRID EVENT
 *******************************************************/
// 페이지 닫기
$(document).on('click', '#close', function(event) {

    NativeInterface.requestGoFinish();
});

/*******************************************************
 * NATIVE EVENT
 *******************************************************/
