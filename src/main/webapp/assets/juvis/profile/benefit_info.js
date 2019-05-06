/**
 * 사용 페이지  :  멤버쉽
 * 사용 페이지 URL  : /hybrid/profile/benefit
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/profile/benefit_info.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : '멤버쉽',
    listCallYn : 'N',
    rangeSize : 10,

    listCall : {

    }
}

/*******************************************************
 * READY
 *******************************************************/

$(document).ready(function(event){
    NativeInterface.requestChangeTitle(PAGE_CONSTATNT.getTitle);
});

/*******************************************************
 * HYBRID METHOD
 *******************************************************/
//포인트 리스트 조회
PAGE_CONSTATNT.listCall.point = function(){
    var lastNode = $('.pointNode:last');
    var currentIdx = lastNode.data('idx');
    var jsonData = JSON.stringify({"currentIdx":currentIdx,"rangeSize":PAGE_CONSTATNT.rangeSize});

    JUVIS.ajax({
        url      : JUVIS.API.getProfilePoint(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            if (result.data && result.data.pointList) {
                var list = result.data.pointList;
                for(var i = 0;  i < list.length; i++ ) {
                    var obj = list[i];
                    var clonenode = lastNode.clone();
                    clonenode.find('.point_plus').removeClass('point_plus');
                    clonenode.find('.point_minus').removeClass('point_minus');

                    clonenode.attr('data-idx',obj.pnlId);
                    clonenode.find('td:first p').html(obj.pnlEtc);
                    if (obj.pnlSave) {
                        clonenode.find('td:nth-child(2) p:first').html(JUVIS.Util.addComma(obj.pnlSave));
                        clonenode.find('td:nth-child(2) p:first').addClass('point_plus');
                    } else {
                        clonenode.find('td:nth-child(2) p:first').html(JUVIS.Util.addComma(obj.pnlUse));
                        clonenode.find('td:nth-child(2) p:first').addClass('point_minus');
                    }
                    clonenode.find('td:last p:last').html(obj.pnlDate);
                    $('.point_body').append(clonenode);
                }
            }
            $('.point_body').attr('data-nextyn',result.data.nextYn ? result.data.nextYn : 'N');
        },
        complete : function (result) {
            PAGE_CONSTATNT.listCallYn = 'N';
        }
    });

};

PAGE_CONSTATNT.listCall.cash = function(){
    var lastNode = $('.cashNode:last');
    var currentIdx = lastNode.data('idx');
    var jsonData = JSON.stringify({"currentIdx":currentIdx,"rangeSize":PAGE_CONSTATNT.rangeSize});

    JUVIS.ajax({
        url      : JUVIS.API.getProfileCash(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {

            if (result.data && result.data.cashList) {
                var list = result.data.cashList;
                for(var i = 0;  i < list.length; i++ ) {
                    var obj = list[i];
                    var clonenode = lastNode.clone();
                    clonenode.find('.cash_plus').removeClass('cash_plus');
                    clonenode.find('.cash_minus').removeClass('cash_minus');
                    clonenode.attr('data-idx',obj.seq);
                    clonenode.find('td:first p').html(obj.cashGubun);

                    if (obj.gubun == 'save') {
                        clonenode.find('td:nth-child(2) p:first').html(JUVIS.Util.addComma(obj.cashAmount));
                        clonenode.find('td:nth-child(2) p:first').addClass('cash_plus');
                    } else {
                        clonenode.find('td:nth-child(2) p:first').html(JUVIS.Util.addComma(obj.cashAmount));
                        clonenode.find('td:nth-child(2) p:first').addClass('cash_minus');
                    }

                    clonenode.find('td:last p:last').html(obj.cashDate);
                    $('.cash_body').append(clonenode);
                }
             }

             $('.cash_body').attr('data-nextyn',result.data.nextYn ? result.data.nextYn : 'N');
        },
        complete : function (result) {
            PAGE_CONSTATNT.listCallYn = 'N';
        }
    });

};

PAGE_CONSTATNT.listCall.stemp = function(){
    var lastNode = $('.stempNode:last');
    var currentIdx = lastNode.data('idx');
    var jsonData = JSON.stringify({"currentIdx":currentIdx,"rangeSize":PAGE_CONSTATNT.rangeSize});

    JUVIS.ajax({
        url      : JUVIS.API.getProfileStamp(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {

            if (result.data && result.data.stampList) {
                var list = result.data.stampList;
                for(var i = 0;  i < list.length; i++ ) {
                    var obj = list[i];
                    var clonenode = lastNode.clone();
                    clonenode.find('.point_use').removeClass('point_use');

                    clonenode.attr('data-idx',obj.stlId);
                    clonenode.find('td:first p').html(obj.stlEtc);
                    clonenode.find('td:nth-child(2) p:first').html(obj.stlExchgeYN);

                    if (obj.stlExchgeYN == '사용') {
                        clonenode.find('td:nth-child(2) p:first').addClass('point_use ');
                    }

                    clonenode.find('td:last p:last').html(obj.stlRegDate);
                    $('.stemp_body').append(clonenode);
                }
            }

            $('.stemp_body').attr('data-nextyn',result.data.nextYn ? result.data.nextYn : 'N');
        },
        complete : function (result) {
            PAGE_CONSTATNT.listCallYn = 'N';
        }
    });
}


/*******************************************************
 * HYBRID EVENT
 *******************************************************/

//헤더 탭 선택
$(document).on('click','.header_tab',function(e){
    $('.tab_select').removeClass('tab_select');
    $(this).addClass('tab_select');
    var currentView = $(this).data('ctgry')+'-wrap';
    $('.view-wrap').addClass('hidden');
    $('#'+currentView).removeClass('hidden');
});

//네이티브 인터페이스 테스트
$(document).on('click','#test2',function(e){
    alert('call start')
    NativeInterface.loadingStart()
    setTimeout(function(){
        // 1초 후 작동해야할 코드
        alert('call end')
        NativeInterface.loadingEnd();
    }, 2000);
});

//스크롤 이벤트
$(window).scroll(function(event){
    var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
    var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
    var ctgry = $('.tab_select').data('ctgry');
    var contentH = $('#'+ctgry+'-wrap').height()+$('.point_tab').height(); //문서 전체 내용을 갖는 div의 높이


    if(scrollT + scrollH >= contentH) { // 스크롤바가 맨 아래에 위치할 때
        var nextYn = $('.'+ctgry+'_body').attr('data-nextyn');
        if ( PAGE_CONSTATNT.listCallYn  == 'Y' || nextYn == 'N' ) {
            return;
        }
        if ( PAGE_CONSTATNT.listCallYn != 'Y' && nextYn != 'N') {
            PAGE_CONSTATNT.listCallYn = 'Y';
            PAGE_CONSTATNT.listCall[ctgry]();

        }
    }
});

/*******************************************************
 * NATIVE EVENT
 *******************************************************/