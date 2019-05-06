/**
 * 사용 페이지  :  포인트 혜택
 * 사용 페이지 URL  : /hybrid/research/list
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/research/research_list.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    resultUrl : "/hybrid/research/toxicResult/",
    viewUrl : "/hybrid/research/toxicView/",
    getTitle : {
                list : '중독증 리스트',
                view : '중독증 설문지',
                result : '중독증 결과'
    }
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

$(window).on('back_key_clicked',function(e){
    NativeInterface.requestGoRefresh();
});

var getTermName = function() {
    var termName ;
    var url = window.document.URL.toString();
    if(url.indexOf('?') > -1){
        url = url.split('?')[0]
    }
    termName = url.substr(url.lastIndexOf('/')+1,url.length);
    return termName;
}

function getTimeStamp() {
    var d = new Date();
    var s = leadingZeros(d.getFullYear(), 4) + '-' +
        leadingZeros(d.getMonth() + 1, 2) + '-' +
        leadingZeros(d.getDate(), 2) + ' ' +

        leadingZeros(d.getHours(), 2) + ':' +
        leadingZeros(d.getMinutes(), 2) + ':' +
        leadingZeros(d.getSeconds(), 2);

    return s;
}

function leadingZeros(n, digits) {
    var zero = '';
    n = n.toString();
    if (n.length < digits) {
        for (i = 0; i < digits - n.length; i++) {
            zero += '0';
        }
    }
    return zero + n;
}
$(document).on('click', '#submit_toxic', function (event) {
    event.preventDefault();
    var total = "";
    var memId = $(".research_detail").data("memid");
    var adtId = $(".research_detail").data("adtid");
    var brcId = $(".research_detail").data("brcid");
    var nameList = new Array();
    $('input[type="radio"]').each(function(index, radio){
        var check = true;
        for(var i = 0; i < nameList.length; i++) {
            if (nameList[i] == radio.name) {
                check = false;
            }
        }
        if (check) {
            nameList.push(radio.name);
        }
    });
    $('input[type="radio"]:checked').each(function(key, value){
        var point = value.value;
        var name = value.name;
        total = Number(total) + Number(point);
        for(var i = 0; i < nameList.length; i++) {
            var item = nameList[i];
            if (item == name) {
                nameList.removeItem(item);
                break;
            }
        };
    });

    if (nameList.length > 0) {
        alert(nameList[0].replace("answer", "") + "번 항목이 체크되지 않았습니다.");
        return;
    }

    var nowDate = getTimeStamp();


    var data = {
        "memId" : memId,
        "adtId" : adtId,
        "brcId" : brcId,
        "adlPoint" : total,
        "adlRegDate" : nowDate
    };

    var jsonData = JSON.stringify(data);
    JUVIS.ajax({
        url      : JUVIS.API.toxicWrite(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            alert('중독증 설문이 등록 되었습니다.');
            var adlId = result.data.adlId;
            var url = PAGE_CONSTATNT.resultUrl+adtId+'/'+adlId+'/'+nowDate;
            NativeInterface.requestFinishGoPage(url);
        },
        error : function(xhr, status, error) {
            if ( error.message ) {
                alert(error.message);
            }
        }
    });
});

$(document).on('click', '.toxicView', function (event) {
    var memSex = $(this).data("memsex");
    var adtId = $(this).data("adtid");
    console.log("memSex : " + memSex);
    console.log("adtId : " + adtId);
    var url = PAGE_CONSTATNT.viewUrl+adtId+'/'+memSex;
    NativeInterface.requestGoPage(url);
});

/**
 * 중독증 설문 결과보기
 */
$(document).on('click', '.toxicResult', function (event) {
    var adtId = $(this).data("adtid");
    var adlId = $(this).data("adlid");
    var adlRegDate = $(this).data("adlregdate");
    console.log("adtId : " + adtId);
    console.log("adlId : " + adlId);
    console.log("adlRegDate : " + adlRegDate);
    var url = PAGE_CONSTATNT.resultUrl+adtId+'/'+adlId+'/'+adlRegDate;
    NativeInterface.requestGoPage(url);
});

$(document).on('click', '.toxicList', function (event) {
    NativeInterface.requestGoRefresh();
});
/*******************************************************
 * HYBRID EVENT
 *******************************************************/

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
// $(window).scroll(function(event){
//     var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
//     var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
//     var ctgry = $('.tab_select').data('ctgry');
//     var contentH = $('#'+ctgry+'-wrap').height()+$('.point_tab').height(); //문서 전체 내용을 갖는 div의 높이
//
//
//     if(scrollT + scrollH >= contentH) { // 스크롤바가 맨 아래에 위치할 때
//         var nextYn = $('.'+ctgry+'_body').attr('data-nextyn');
//         if ( PAGE_CONSTATNT.listCallYn  == 'Y' || nextYn == 'N' ) {
//             return;
//         }
//         if ( PAGE_CONSTATNT.listCallYn != 'Y' && nextYn != 'N') {
//             PAGE_CONSTATNT.listCallYn = 'Y';
//             PAGE_CONSTATNT.listCall[ctgry]();
//
//         }
//     }
// });

/*******************************************************
 * NATIVE EVENT
 *******************************************************/