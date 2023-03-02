<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top:50px;
}
.row{
  margin:0px auto;
  width:1200px;
}
h1{
  text-align:center;
}
</style>
</head>
<body>
<div class="container">
    <h3 class="text-center" style="color:gray">${vo.title }</h3>
    <div class="row">
	    <table class="table">
	      <tr>
	        <td><img src="${vo.poster }" style="display:block;margin:0 auto;width:700px;height:500px;"></td>
	      </tr>
	      <tr>
	        <td>${vo.address }</td>
	      </tr>
	      <tr>
	        <td>${vo.msg }</td>
	      </tr>
	    </table>
    </div>


    <div style="height:10px;"></div>
    <h3>인근 맛집</h3>
    <hr>
    <div class="row">
      <c:forEach var="fvo" items="${list }">
       	  <div class="col-md-4" style="width:300px;">
		    <div class="thumbnail">
		      <a href="../food/detail.do?no=${fvo.fno }">
		        <img src="${fvo.poster }" style="width:250px;height:180px;">
		        <div class="caption">
		          <p class="text-center">${fvo.name }</p>
		        </div>
		      </a>
		    </div>
		  </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>