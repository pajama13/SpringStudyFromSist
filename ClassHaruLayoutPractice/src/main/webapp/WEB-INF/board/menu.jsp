<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.board_menu a{
  display:block;
  margin:0 0 30px 0;
}
</style>
</head>
<body>
  <%-- 게시판 메뉴 --%>
  <div class="board_menu" style="padding:50px 20px;">
	  <a href="../board/main.do?type=1" style="">자유주제</a>
	  <a href="../board/main.do?type=2">스터디 & 모임</a>
	  <a href="../board/main.do?type=3">공지사항</a>
  </div>
  
  <%-- 글작성랭킹 --%>
  <div class="board_rank" style="padding:20px;border:1px solid lightgray;">
      <h4 style="margin:0 0 15px 0;font-size:14px;">올해 게시글 작성 TOP 7</h4>
      <%-- 유저 1명(전체 반복) --%>
      <div class="rank_item" style="display:flex;justify-content:space-between;align-items:center;">
        <div style="display:flex;align-items:center;">
          <img src="" style="width:25px;height:25px;background:pink;">
          <span style="margin:0 0 0 10px;width:120px;font-size:12px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;" title="닉네임">유저닉네임1</span>
        </div>
        <span style="margin:0 0 0 5px;font-size:12px;">150글</span>
      </div>
  </div>
  
</body>
</html>