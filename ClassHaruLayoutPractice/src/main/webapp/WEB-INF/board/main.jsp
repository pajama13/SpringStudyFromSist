<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- 폰트어썸 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
/* css 공통사항 */
*{
  margin:0px;
  padding:0px;
  list-style: none;
  border-collapse: collapse;
  text-decoration: none;
  color: #000;
  font-size:16px;
}
a{
  color: black;
  text-decoration: none;
  cursor:pointer;
}
a:hover{
  color:black;
  text-decoration: none;
  cursor:pointer;
}
a:active{
  color:black;
  text-decoration: none;
  cursor:pointer;
}
a:focus{
  color:black;
  text-decoration: none;
  cursor:pointer;
}
input{
  border:1px solid lightgray;
  border-radius:4px;
}
input:focus{
  outline:none;
}
h1,h2,h3,h4,h5,h6{
  margin:0;padding:0;
}
button,.all_btn {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  
  padding: 10px 15px;
  border:1px solid lightgray;
  border-radius:4px;
}
button:hover{
  cursor:pointer;
}
.board_title{
margin:0 0 20px 0;
font-weight:bold;
}
/* ------------- */
</style>

</head>
<body>
  <div class="wrapper" style="width:1200px;margin:0 auto;">	
  
	  
		<%-- 메뉴, 글작성랭킹 --%>
		<aside style="width:20%; height:700px; float:left;">
		  <tiles:insertAttribute name="board_menu"/>
		</aside>
		
		<%-- 게시판 메인(검색창, 게시글 목록 등) --%>
		<section style="width:80%; float:right;">
		  <tiles:insertAttribute name="board_content"/>	
		</section>
		
	
  </div>
</body>
</html>