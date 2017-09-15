<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
  <h2>회원가입</h2>
   <form id="join_form">
      <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="member_id" placeholder="아이디를 입력하세요" name="member_id">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="password">
    </div>
     <div class="form-group">
      <label for="name">이름</label>
      <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email">
    </div>
    <div class="form-group">
      <label for="phone">전화번호</label>
      <input type="text" class="form-control" id="phone" placeholder="전화번호를 입력하세요" name="phone">
    </div>
    <div class="form-group">
      <label for="ssn">주민번호</label>
      <input type="text" id="ssn" name="ssn" class="form-control" placeholder="주민등록번호입력">
    </div>
     <div class="form-group">
      <label for="gender">성별</label>
      <label><input type="radio" id="gender" name="gender" value="male">남성</label>
      <label><input type="radio" id="gender" name="gender" value="female">여성</label>
    </div>
    <div class="form-group">
      <select name="major" id="major">
		  <option value="1">컴퓨터공학</option>
		  <option value="2">과학</option>
		  <option value="3">물리학</option>
		  <option value="4">영어</option>
	  </select>
	  
    </div>
	  <div>
	  </div>
    <div class="form-group">
      <label for="subject">수강과목</label>
	      <div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="1" checked="checked">java</label>
			</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="2" checked="checked">javascript</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="3">html</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="4">css</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="5">phython</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="6">c</label>
		</div>
		<div class="checkbox">
	  		<label><input type="checkbox" id="subject" name="subject" value="7">c++</label>
		</div>
    </div>
	<input type="hidden" id=profile name="profile" value="profile"/>
    <input type="hidden" name="action" value="join"/>
    <input type="hidden" name="page" value="main"/>
    <button type="submit" class="btn btn-danger" id="join">전송</button>
  </form>
   
</div>
</body>
<script>
app.member.init();
</script>

</html>