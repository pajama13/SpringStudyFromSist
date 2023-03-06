<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrapper{
  width:1200px;
}
</style>
</head>
<body>
  <div class="wrapper">   
  
   <%-- 메뉴, 글작성랭킹 --%>
   <aside style="width:25%;height:700px;background:pink;float:left;">
     <%-- 메뉴 --%>
     <div class="board_menu">
       <a>자유주제</a>
       <a>질문답변</a>
       <a>스터디&모임</a>
     </div>
     <%-- 글작성랭킹 --%>
     <div>
       
     </div>
   </aside>
   
   <%-- 게시판 메인(검색창, 게시글 목록 등) --%>
   <section style="width:75%;height:700px;background:yellow;float:right;">
      
      
      <%-- 기본 검색창 --%>
      <div class="">
        <input type=text>
      </div>
      
      <%-- 태그 검색창 --%>
      <div>
        <input type=text >
      </div>
      
      <%-- 정렬버튼, 글쓰기 버튼 --%>
      <div class="">
        <button>최신순</button>
        <button>조회수순</button>
        <button>댓글많은순</button>
        <button>글쓰기</button>
      </div>
      
      <%-- 게시글 목록 --%>
      <div class="">
        <hr>
        <h4>제목</h4>
        <h5>내용</h5>
        <%-- 태그 --%>
        <div>
          <span>태그1</span>
        </div>
        <div>
          <span>작성자 | 작성시간</span>
        </div>
      </div>
      
      
   </section>
   
   
  </div>
</body>
</html>