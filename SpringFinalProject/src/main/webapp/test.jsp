<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var tag=''
	var tagAll=''
	$('#tagInput').keypress(function(){
		var tag=$(this).val()
		console.log(tag)
		//var inputLength=$(this).val().length //입력한 값의 글자수
		$('#test').append('<span style="padding:5px 10px;margin-right:10px;background:yellow;">'+tag+" "+'</span>')
		$('#tagInput').val('')
		
		tagAll=$('#test').text().trim()
		console.log(tagAll) //확인용
		
		$('#test2').text(tagAll)
	})

})
</script>
</head>
<body>
	<button id="b">버튼</button>
    <input type=text id="tagInput">
	<div id="test">
	
	</div>
	<span id=test2 style="display:none;"></span>
</body>
</html>