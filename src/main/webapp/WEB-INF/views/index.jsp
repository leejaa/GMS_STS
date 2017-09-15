<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
   <script src="${path.js}/meta.js"></script>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a id="home">HOME</a>
    </div>
    <ul id="ul">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">MEMBER
        <span class="caret"></span></a>
        <ul id="ul1">
          <li><a id="member_list">회원목록</a></li>
          <li><a id="member_update">회원정보수정</a></li>
          <li><a id="member_delete">회원탈퇴</a></li>
        </ul>
      </li>
      
   	   <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">GRADE
        <span class="caret"></span></a>
        <ul id="ul2">
          <li><a id="grade_input">성적입력</a></li>
          <li><a id="grade_list">성적목록</a></li>
          <li><a id="grade_update">성적수정</a></li>
        </ul>
      </li>
      
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">BOARD
        <span class="caret"></span></a>
        <ul id="ul3">
          <li><a id="board_write">게시글쓰기</a></li>
          <li><a id="board_list">게시글목록</a></li>
          <li><a id="board_update">게시글수정</a></li>
        </ul>
      </li>
      
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
      <c:choose>
		<c:when test="${empty user}">
      <li><a id="member_join"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
      <li><a id="login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        </c:when>
        <c:otherwise>
        <li><a onclick="detail()"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;님</a></li>
		 <li><a id="logout"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
		</c:otherwise>
	</c:choose>
    </ul>
  </div>
</nav>
</head>
<body>
	<div id="wrapper"></div>
</body>
<script>
meta.main.init();
meta.index.init();
meta.common.init('${path.ctx}');


</script>