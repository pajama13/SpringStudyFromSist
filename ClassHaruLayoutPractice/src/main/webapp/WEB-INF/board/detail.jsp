<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.board_info,.board_info > *{
  color:gray;
}
.reply_item:last-child>hr{
  display:none;
}
</style>
</head>
<body>
<div style="padding:50px;">
  
    <%-- 글, 댓글에 수정,삭제 버튼 추가하기 --%>
  
    <%-- 제목, 글정보 --%>
    <h1 class="board_title" style="font-size:32px;">영어회화수업 같이 들을 분!!</h1>
	<div class="board_info">
        <img src="" style="width:40px;height:40px;background:pink;">
        <span style="margin:0 40px 0 10px;width:120px;">유저닉네임</span>
        <span>2023-03-04</span>&nbsp;&nbsp;
        <i class="fa-regular fa-eye"></i>&nbsp;153&nbsp;&nbsp;
	    <i class="fa-regular fa-message"></i>&nbsp;5
    </div>
    <%-- 글내용 --%>
    <div class="board_allcontent" style="margin:50px 0;width:100%;line-height:200%;white-space:pre;">영어회화수업 3명이서 들으면 더 저렴하게 배울 수 있는데,
저랑 같이 들을 분 구합니다~ 지역은 서울이고요, 튜터님은 같이 얘기해서 정해봐요!
관심 있는 분들은 댓글 남겨주세요!  :)
    </div>
    
    <hr style="margin:30px 0;border-top:1px solid lightgray;">
    
    <%-- 댓글개수 --%>
    <h3 style="margin:30px 0;font-weight:bold;">댓글(5)</h3>
    <%-- 댓글입력란 --%>
    
    <%-- 작성된 댓글 --%>
    <div class="reply_all">
        <%-- 댓글 1개(전체 개수만큼 반복) --%>
	    <div class="reply_item">
		    <%-- 댓글정보 --%>
		    <div class="reply_info">
		        <img src="" style="width:40px;height:40px;background:pink;">
		        <span style="margin:0 10px 0 10px;width:120px;font-size:16px;">유저닉네임</span>&nbsp;&nbsp;
		        <span style="color:gray;font-size:14px;">2023-03-04</span>&nbsp;&nbsp;
		    </div>
		    <%-- 댓글내용 --%>
		    <div class="reply_content" style="margin:20px 0;width:100%;line-height:200%;white-space:pre;">저요!!</div>
	        <button class="all_btn" style="background:#f0f0f0;font-size:14px;">답글달기</button>
	        <hr style="margin:30px 0;border-top:1px solid lightgray;">
	    </div>
    </div>
    
    
</div>
</body>
</html>