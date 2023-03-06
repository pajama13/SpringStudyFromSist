<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.check_btn{
  width:35px;
  height:35px;
  background:lightgray;
  border:0;
  border-radius:50px;
}
</style>
</head>
<body>
<div class="container" style="padding:50px;">

  <h1>클래스 신청</h1>
  <%-- 클래스정보, 클래스일정 --%>
  <div style="width:45%">
    <%-- 클래스정보 --%>
    <div class="classInfo">
      <div style="width:25%;float:left">
        <img src="" style="width:150px;height:150px;">
      </div>
      <div style="width:75%;float:right">
        <h4 style="margin:20px 0;">[상위1%]1:1맞춤수업! 미국식 발음교정 & 말 잘하는 영어회화</h4>
        <span>★★★★★</span>&nbsp;4.9
      </div>
    </div>
    <%-- 클래스일정 --%>
    
    <div>
      <h3>클래스 일정을 선택해주세요.</h3>
      
      <div style="padding:25px;clear:both;border:1px solid lightgray;">
        <div style="margin:20px;float:left;">
          <button class="check_btn"><i class="fa-solid fa-check"></i></button>
        </div>
        <div style="width:85%;float:right;">
          <h4>02월 20일 월요일(온라인LIVE)12:00 ~ 14:00</h4>
          <ul>
            <li>2회 02월 27일(월) 12:00 ~ 14:00</li>
            <li>3회 03월 6일(월) 12:00 ~ 14:00</li>
            <li>4회 03월 13일(월) 12:00 ~ 14:00</li>
          </ul>
        </div>
        <hr style="margin:10px 10px;clear:both;">
      </div>
      
    </div>
  </div>
  <%-- 신청인원, 연락처, 메시지 --%>
  <div style="width:50%">
  
  </div>
</div>
</body>
</html>