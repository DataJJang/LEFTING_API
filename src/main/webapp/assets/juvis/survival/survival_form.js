/**
 * 사용 페이지  :  서바이벌 신청, 정보 조회
 * 사용 페이지 URL  : /hybrid/survival/survival_info
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/survival/survival_info.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : '서바이벌 소개',
    rtn_url : '/hybrid/survival'
}

$(document).ready(function(event){
var memId = $('#memId').val();
    NativeInterface.requestChangeTitle(PAGE_CONSTATNT.getTitle);
    NativeInterface.requestBackClickProxy();

});
/*******************************************************
 * HYBRID METHOD
 *******************************************************/

    init_canvas();

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


function init_canvas(){
	console.log(">>>>init canvas");
	var canvas = document.getElementById('canvas1');
	var ctx = canvas.getContext('2d');

	var painting = document.getElementById('info_canvas');
	var paint_style = getComputedStyle(painting);
	canvas.width = parseInt(paint_style.getPropertyValue('width'));
	canvas.height = parseInt(paint_style.getPropertyValue('height'));

	var mousePos = {x: 0, y: 0};
	var isDrawabled = false;

	ctx.lineWidth = 5;
	ctx.lineJoin = 'round';
	ctx.lineCap = 'round';
	ctx.strokeStyle = '#000000';

  var touchX,touchY;
  var mouseX,mouseY,mouseDown=0;

  function drawDot(ctx,x,y,size, isDown) {

        if(isDown) {
          ctx.beginPath();
	        ctx.strokeStyle = $('#selColor').val();
	        ctx.lineWidth = $('#selWidth').val();
	        ctx.lineJoin = "round";
	        ctx.moveTo(lastX, lastY);
	        ctx.lineTo(x, y);
          ctx.closePath();
          ctx.stroke();
        }
        lastX = x; lastY = y;
    }

    // Clear the canvas context using the canvas width and height
    function clearCanvas(canvas,ctx) {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
    }

    // Keep track of the mouse button being pressed and draw a dot at current location
    function sketchpad_mouseDown() {
        mouseDown=1;
        drawDot(ctx,mouseX,mouseY,5,false);
    }

    // Keep track of the mouse button being released
    function sketchpad_mouseUp() {
        mouseDown=0;
    }

    // Keep track of the mouse position and draw a dot if mouse button is currently pressed
    function sketchpad_mouseMove(e) {
        // Update the mouse co-ordinates when moved
        getMousePos(e);

        // Draw a dot if the mouse button is currently being pressed
        if (mouseDown==1) {
            drawDot(ctx,mouseX,mouseY,5,true);
        }
    }

    // Get the current mouse position relative to the top-left of the canvas
    function getMousePos(e) {
        if (!e)
            var e = event;

        if (e.offsetX) {
            mouseX = e.offsetX;
            mouseY = e.offsetY;
        }
        else if (e.layerX) {
            mouseX = e.layerX;
            mouseY = e.layerY;
        }
     }

    function getTouchPos(e) {
        if (!e)
            var e = event;

        if (e.touches) {
            if (e.touches.length == 1) { // Only deal with one finger
                var touch = e.touches[0]; // Get the information for finger #1
                touchX=touch.pageX-touch.target.offsetLeft;
                touchY=touch.pageY-touch.target.offsetTop;
            }
        }
    }

 function sketchpad_touchStart() {
        getTouchPos();
        drawDot(ctx,touchX,touchY,5,false);

        isDrawabled = true;
        // Prevents an additional mousedown event being triggered
        event.preventDefault();
    }

    function sketchpad_touchMove(e) {
        // Update the touch co-ordinates
        getTouchPos(e);

        // During a touchmove event, unlike a mousemove event, we don't need to check if the touch is engaged, since there will always be contact with the screen by definition.
        if(isDrawabled) {
          drawDot(ctx,touchX,touchY,5,true);
        }
        // Prevent a scrolling action as a result of this touchmove triggering.
        event.preventDefault();
    }

 function sketchpad_touchEnd() {
        getTouchPos();
        isDrawabled = false;

        // Prevents an additional mousedown event being triggered
        event.preventDefault();
    }


canvas.addEventListener('mousedown', sketchpad_mouseDown, false);
canvas.addEventListener('mousemove', sketchpad_mouseMove, false);
window.addEventListener('mouseup', sketchpad_mouseUp, false);
canvas.addEventListener('touchstart', sketchpad_touchStart, false);
canvas.addEventListener('touchmove', sketchpad_touchMove, false);
canvas.addEventListener('touchend', sketchpad_touchMove, false);

	function clearArea() {
	    // Use the identity matrix while clearing the canvas
	    ctx.setTransform(1, 0, 0, 1, 0, 0);
	    ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);

	    isSignYN = false;
	}

	$(document).on("click", ".btnClear", function(){
		clearArea();
	});

var dataUri = $('#canvas1')[0].toDataURL('image/png').split(",")[1];

//서바이벌 가입
$(document).on('click', '#join_survival', function(event) {
    event.preventDefault();

    var dataUri = $('#canvas1')[0].toDataURL('image/png').split(",")[1];
    var jsonData = JSON.stringify({'dataUri' : dataUri});

    JUVIS.ajax({
        url      : JUVIS.API.joinSurvival(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {

            alert('서바이벌 신청이 완료되었습니다.');
            NativeInterface.requestGoRefresh();
        },
        error : function(xhr, status, error) {
            alert(error.message);
//        },
//        complete : function (result) {
//          NativeInterface.requestGoFinish();
        }
    });

});

}
//}