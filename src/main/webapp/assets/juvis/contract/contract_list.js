/**
 * 사용 페이지  :  포인트 혜택
 * 사용 페이지 URL  : /hybrid/profile/benefit
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/profile/benefit_info.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    detailUrl : '/hybrid/profile/contract/',
    dlyUrl : '/hybrid/delay/form/'
}

/*******************************************************
 * READY
 *******************************************************/

$(document).ready(function(event){
    NativeInterface.requestBackClickProxy();
});


/*******************************************************
 * HYBRID METHOD
 *******************************************************/


/*******************************************************
 * HYBRID EVENT
 *******************************************************/
$(window).on('back_key_clicked',function(e){
    NativeInterface.requestGoRefresh();
});

$(document).on('click', ".contract_program>.contract_tit", function (event) {
    $(this).next("table").toggle();
    $(this).next("table").next("div").toggle();
});

$(document).on('click', ".contract_payment>.contract_tit", function (event) {
    $(this).next("div").toggle();
    $(this).next("div").next("div").toggle();

});

// 연기신청 버튼 클릭시 check
$(document).on('click', '#delayBtn', function (event) {

    event.preventDefault();
    var ctdId = $('.contract_program').data("ctdid");
    var jsonData = JSON.stringify(ctdId);
    JUVIS.ajax({
        url      : JUVIS.API.checkDelay(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            console.log('연기신청가능');
            var dlyUrl = PAGE_CONSTATNT.dlyUrl+ctdId;
            NativeInterface.requestGoPage(dlyUrl);
        },
        error : function(xhr, status, error) {
            alert(error.message);
        // },
        // complete : function () {
        //     alert("asdasdasdasd");
        }
    });
});

$(document).on('click','.contract_box',function(e){
    var ctdId = $(this).data('ctrid');
    if (ctdId ) {
        //페이지 콜
        var url = PAGE_CONSTATNT.detailUrl+ctdId;
        NativeInterface.requestGoPage(url);
    }

});

$(document).on('click', '.contractList', function (event) {
    NativeInterface.requestGoFinish();
});
/*******************************************************
 * NATIVE EVENT
 *******************************************************/