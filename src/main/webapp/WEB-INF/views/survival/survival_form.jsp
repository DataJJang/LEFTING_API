<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>쥬비스 다이어트 | 서바이벌 안내</title>
	</head>

	<body>
		<div id="wrap">
			<div class="survival_info">
				<div class="info_top">
					<p class="f17 w500">서바이벌 안내</p>
				</div>
				<div class="info_middle">
					<div class="info_txt_box">
						${data.dcmContent} <br>
					</div>
					<div class="contract_txt">
						<p class="f13 w700 cont_txt1">위 내용을 확인 하신 후 서명란에 서명 해주시기 바랍니다.</p>
					</div>

					<div class="contract_input">
						<form>
							<fieldset>
							<a href="#" class="btn_Gline marT30 marL200 btnClear">서명 지우기</a>
								<div id="info_canvas" class="info_canvas sign_ipt3">
									<canvas id="canvas1" width="auto" height="100px" class="pad" placeholder="서명하기">이 브라우저에서는 HTML5 CANVAS를 지원하지 않습니다.</canvas>
								</div>

								<div class="info_btn">
									<button class="btn_submit btn_submit_half" id="join_survival" style="">저장하기<br>
                  </button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
<script src='<c:url value="/assets/juvis/survival/survival_form.js"/>'></script>
</body></html>