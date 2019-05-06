<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><sitemesh:write property='title' /></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta id="Viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <link rel="stylesheet" type="text/css" href='<c:url value="/assets/css/new_style.css"/>'/>
    <link rel="stylesheet" type="text/css" href='<c:url value="/assets/css/common.css"/>'/>
    <script src='<c:url value="/assets/js/jquery/jquery.min.js"/>'></script>
    <script src='<c:url value="/assets/juvis/common/juvis_common.js"/>'></script>
    <script src='<c:url value="/assets/juvis/common/native_interface.js"/>'></script>
    <script src='<c:url value="/assets/js/moment/moment.min.js"/>'></script>
    <script>
        JUVIS.accessToken = '${token}';
    </script>
    <sitemesh:write property='head' />
</head>
<body>
    <sitemesh:write property='body' />
</body>
</html>