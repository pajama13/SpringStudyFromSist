<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.board_search input{
  margin:0 0 15px 0;
  padding:0 20px 0 45px;
  width:70%;
  height:45px;
}
.board_search i,.board_search img{
  margin: 3px 0 0 15px;
  position:absolute;
  z-index:10;
  font-size:20px;
  line-height:40px;
}
.view_btn{
  width:70%;
  float:left;
}
.view_btn button{
  border:0;
  background:white;
}
.board_content{
  overflow:hidden;text-overflow:ellipsis;white-space:nowrap;
  font-size: 16px;
}
/* 하단 작성자, 작성시간, 조회수, 댓글수*/
.board_bottom > div,.board_bottom > * > *{
  color:gray;
}
</style>
</head>
<body>
<div class="container" style="padding:50px;">
  
  
	<%-- 기본 검색창 --%>
    <div class="board_search">
      <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
      <input type=text placeholder="궁금한 것을 검색해보세요!">
      <button style="width:90px;height:45px;">검색</button>
    </div>
      
    <%-- 태그 검색창 --%>
    <div class="board_search">
      <i class="fa-regular fa-hashtag"></i>
      <input type=text placeholder="태그로 검색해보세요!">
      <button style="width:90px;height:45px;">초기화</button>
    </div>
     
    <%-- 정렬버튼, 글작성 버튼 --%>
    <div class="board_btns" style="margin: 15px 0;display:flex;justify-content:space-between;">
      <div class="view_btn">
        <a href="../board/main.do?type=#&order=#" class="all_btn" style="border:0;">최신순</a>
        <a href="../board/main.do?type=#&order=#" class="all_btn" style="border:0;">조회수순</a>
        <a href="../board/main.do?type=#&order=#" class="all_btn" style="border:0;">댓글많은순</a>
      </div>
      <a href="../board/insert.do" class="all_btn" style="height:45px;background:#f0f0f0;">글작성&nbsp;&nbsp;<i class="fa-solid fa-pencil"></i></a>
    </div>
    
    <%-- 게시글 목록 --%>
    <div class="board_item" v-for="(vo,index) in board_list" style="clear:both;">
   
      <hr style="margin:0 0 20px 0; border-top:1px solid lightgray;">
      <a href="../board/detail.do">
      <div style="padding:15px;">
	      <h4 class="board_title">{{vo.title}}</h4>
	      <p class="board_content">{{vo.content}}</p>
	      
	      <%-- 태그 (공백으로 잘라서 전체 출력하기)--%>
	      <div class="board_tag" style="margin: 20px 0 20px 0;">
	        <div v-if="vo.tag!='no'">
	          <span class="all_btn" v-for="t in vo.tag.split(' ')" style="background:#f0f0f0;margin:0 10px 0 0;padding:5px 10px;">{{t}}</span>
	        </div>
	      </div>
	      
	      <%-- 게시글 정보(작성자,작성일,조회수,댓글수) --%>
	      <div class="board_bottom" style="display:flex;justify-content:space-between;">
	        <%-- 작성자, 작성일 --%>
	        <div>
	          <span>{{vo.id}}&nbsp;&nbsp;|&nbsp;&nbsp;{{vo.dbday}}</span>
	        </div>
	        <%-- 조회수, 댓글수 --%>
	        <div style="margin:0 30px 0 0;">
	          <i class="fa-regular fa-eye"></i>&nbsp;{{vo.hit}}&nbsp;&nbsp;
	          <i class="fa-regular fa-message"></i>&nbsp;5
	        </div>
	      </div>
      </div>
      </a>
      
    </div>
    
    <%-- 게시글 페이징 처리 --%>
	<div class="text-center">
	   <input type="button" class="all_btn" value="이전" @click="prev()">
	   {{curpage}}페이지 / {{totalpage}}페이지
	   <input type="button" class="all_btn" value="다음" @click="next()">
	</div>
    
</div>
<script>
  new Vue({
	  el:'.container',
	  data:{
		  btype:1,
		  board_list:[],
		  //bvo:{}, //게시글 1개
		  //tags:[], //게시글 1개 태그들
		  tags:{},
		  curpage:1,
		  totalpage:0
	  },
	  mounted:function(){
		  this.send()
		  let _this=this
		  axios.get('http://localhost/web/board/main_vue.do',{
			  params:{
				  page:_this.curpage,
				  btype:_this.btype
			  }
		  }).then(function(response){
			  console.log(response.data)
			  _this.board_list=response.data
			  //_this.tags=_this.board_list.tags
		  })
	  },
	  methods:{
		  prev:function(){
			  this.curpage=this.curpage>1?this.curpage-1:this.curpage
			  this.send()
		  },
		  next:function(){
			  this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
			  this.send()					
		  },
		  send:function(){
			  let _this=this;
			  axios.get('http://localhost/web/board/main_vue.do',{
				  params:{
					  page:_this.curpage,
					  btype:_this.btype
				  }
			  }).then(function(response){
				  console.log(response.data)
				  _this.board_list=response.data
				  _this.curpage=response.data[0].curpage
				  _this.totalpage=response.data[0].totalpage
			  })
		  }
	  }
  })

</script>
</body>
</html>