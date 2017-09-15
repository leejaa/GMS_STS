<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
  <title>title</title>
</head>
<header>
</header>
<body>
	

<div class="container">
<h1 align="center">count: ${count} </h1>

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button"  onclick="app.controller.search()">search</button>
      </span>
      <input type="text" class="form-control" id="search" placeholder="단어입력">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
 


  <table class="table">
    <thead>
      <tr>
      	<th>번호</th>
        <th>아이디</th>
        <th>이름</th>
        <th>가입일</th>
        <th>휴대폰번호</th>
        <th>이메일</th>
        <th>성별</th>
        <th>수강과목</th>
        <th>수정/삭제</th>
      </tr>
    </thead>	
    <tbody>
       <c:forEach var="i" items="${list}">
		      <tr class="success">
		      	<td><fmt:formatNumber value="${i.num}" pattern="."/></td>
		      	<td> <a onclick="app.controller.detail('${i.member_id}')">${i.member_id}</a></td>
		      	 <td>${i.name}</td>
		      	 <td>${i.regdate}</td>
		      	 <td>${i.phone}</td>
		      	 <td>${i.email}</td>
		      	 <td>${i.gender}</td>
		      	 <td>${i.title}</td>
		      	 <td>
		      	 <a onclick="app.controller.update('${i.member_id}')">수정</a>/
		      	<a onclick="app.controller.Delete('${i.member_id}')">삭제</a></td>
		      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

 

  <div class="container" style="width: 500px;margin: 0 auto;">
  
  <ul class="pagination">
  
  <c:if test="${pageNumber ne 1}">
	  <li class="page-item">
	  <span class="glyphicon glyphicon-backward" aria-hidden="true" onclick="prevprev()"></span>
	      <a class="page-link" onclick="prev()" tabindex="-1">Previous</a>
	    </li>
  </c:if>
    
     <c:forEach varStatus="i" begin="${startPage}" end="${endPage}" step="1">
	     <c:choose>
	     	<c:when test="${i.index eq pageNumber}">
	     		<li class="page-item active"><a>${i.index}</a></li>
	     	</c:when>
	     	<c:otherwise>
	     		<li class="page-item"><a onclick="pageClick('${i.index}')">${i.index}</a></li>
	     	</c:otherwise>
	     </c:choose>
    
    
    </c:forEach>
    <c:if test="${pageNumber ne theNumberOfPages}">
     <li class="page-item">
      <a class="page-link" onclick="next()">Next</a>
      <span class="glyphicon glyphicon-forward" aria-hidden="true" onclick="nextnext()"></span>
    </li>
    </c:if>
  </ul>

  </div>  
</div>
</body>
<script>
function pageClick(pageNumber){
    location.href=app.path.ctx()+"/member/move_list?pageNumber="+pageNumber;
}
function next(){
    var nextPage=${startPage}+${blockSize};
    location.href=app.path.ctx()+"/member/move_list?pageNumber="+nextPage;
}
function prev(){
    var prevPage=${endPage}-${blockSize};
    if(prevPage<1){
          prevPage=1;
    }
    location.href=app.path.ctx()+"/member/move_list?pageNumber="+prevPage;
}
function nextnext(){
    var nextnextPage=${theNumberOfPages};
    location.href=app.path.ctx()+"/member/move_list?pageNumber="+nextnextPage;
}
function prevprev(){
    var prevPage=${endPage}-${blockSize};
    location.href=app.path.ctx()+"/member/move_list?pageNumber="+prevPage;
}
function updateStudent(id){
    alert('수정할 아이디 : '+id);
    location.href="${ctx}/member.do?action=detail&page=update&member_id="+id;
}
function deleteStudent(id){
    alert('삭제할 아이디 : '+id);
    location.href="${ctx}/member.do?action=delete&page=list&member_id="+id;
}

</script>
</html>

