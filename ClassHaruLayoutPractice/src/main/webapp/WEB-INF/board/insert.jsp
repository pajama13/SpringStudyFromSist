<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- TinyMCE(글작성 에디터) -->

<script src="https://cdn.tiny.cloud/1/6wwhl65tkqjsvcqgxq8dfcbx5zeo5rdp4c258gyz6a1zrkl0/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

<style type="text/css">
/* TinyMCE 관련 */
.tox-control-wrap{
  display:none;
}
/* 제목, 태그입력 관련 */
.input_text{
  padding: 0 20px;
  width:100%;
  height:45px;
  border:1px solid lightgray;
}
.input_name{
  margin:0 0 10px 0;
}
.all_btn{
  display:inline-block;
}
</style>
<script>
tinymce.init({
	selector: '#mytextarea'
});
</script>
</head>
<body>
<div style="padding:50px;">
  <form method="post" action="">
  	
		<%-- 게시글 작성 관련 게시판 구분 --%>
		<div id="select_board" style="margin:0 0 24px 0;">
		  <div class="input_name" style="border:0;padding-left:0;">게시판 선택</div>
		  <div>
		    <a href="../board/insert.do?type=1" class="all_btn">자유주제</a>
		    <a href="../board/insert.do?type=2" class="all_btn">스터디 & 모임</a>
		    <a href="../board/insert.do?type=3" class="all_btn">질문답변</a>
		  </div>
		</div>
		
		<%-- 제목 입력란 --%>
		<div id="insert_title" style="margin:0 0 30px 0;">
		  <div class="input_name">제목</div>
		  <input type=text class="input_text">
		</div>
		
		<%-- 태그 입력란 --%>
		<div id="insert_tag" style="margin:0 0 30px 0;">
		  <div class="input_name">태그<span style="color:lightgray;">&nbsp;&nbsp;&nbsp;본문과 관련된 태그를 입력해주세요.</span></div>
		  <input type="text" class="input_text">
		  <%-- 입력된 태그 출력 --%>
		  <div id="print_tag">
		  
		  </div>
		</div>
		
		<%-- 게시글 입력란 --%>
		<div class="input_name">본문</div>
		
		<textarea placeholder="게시글을 작성해주세요!">
		    
		</textarea>
		<div class="insert_btns" style="margin:20px 0;float:right;">
		  <a href="../board/board_main.do" class="all_btn">취소</a>
		  <a href="#" class="all_btn">등록</a>
		</div>
  
  </form>
</div>
<script>
    tinymce.init({
      language: "ko_KR",
      selector: 'textarea',
      height:500,
      plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
      toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
      tinycomments_mode: 'embedded',
      tinycomments_author: 'Author name',
      mergetags_list: [
        { value: 'First.Name', title: 'First Name' },
        { value: 'Email', title: 'Email' },
      ],
      image_title: true,
      automatic_uploads: true,
      file_picker_types: 'image',
      file_picker_callback: function (cb, value, meta) {
          var input = document.createElement('input');
          input.setAttribute('type', 'file');
          input.setAttribute('accept', 'image/*');

          /*
          Note: In modern browsers input[type="file"] is functional without
          even adding it to the DOM, but that might not be the case in some older
          or quirky browsers like IE, so you might want to add it to the DOM
          just in case, and visually hide it. And do not forget do remove it
          once you do not need it anymore.
          */
          input.onchange = function () {
              var file = this.files[0];

              var reader = new FileReader();
              reader.onload = function () {
                  /*
                  Note: Now we need to register the blob in TinyMCEs image blob
                  registry. In the next release this part hopefully won't be
                  necessary, as we are looking to handle it internally.
                  */
                  var id = 'blobid' + (new Date()).getTime();
                  var blobCache =  tinymce.activeEditor.editorUpload.blobCache;
                  var base64 = reader.result.split(',')[1];
                  var blobInfo = blobCache.create(id, file, base64);
                  blobCache.add(blobInfo);

                  /* call the callback and populate the Title field with the file name */
                  cb(blobInfo.blobUri(), { title: file.name });
              };
              reader.readAsDataURL(file);
          };
          input.click();
      }
    });
  </script>
  
</body>
</html>