<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="expires" content="-1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>아이디 찾기 결과 | 도비스프리</title>
    <link rel="stylesheet" href="./css/user/findIDResult.css"/>
</head>
<body>
<header class="header">
    <div class="headerBox">
        <div class="inner">
            <h1 class="page_tit">아이디 찾기 결과</h1>
            <a href="http://localhost:80/" button type="button" class="btn_page_close">
                <span class="blind">닫기</span>
            </a>
            </button>
        </div>
    </div>
</header>
<section class="container">
    <div class="page_top_area">
        <h2>고객님의 아이디 정보입니다.</h2></br>
    </div>
    <div class="sec_join">
        <div class="user_info">
            <input type="hidden" id="user_id" name="loginid" value="">
            <strong class="st_txt">아이디  :  jungsuk</strong>
        </div>
        <div class="btn_submit">
            <button type="button" id="dologin" class="btnA btn_blue">
                <a href="/login"style="text-decoration: none; color: #FFFFFF"; >로그인 하기</a></button>
        </div>
    </div>
</section>
</body>
</html>