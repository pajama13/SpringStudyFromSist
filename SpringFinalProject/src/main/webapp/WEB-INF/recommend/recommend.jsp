<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- jquery ui - dialog -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">


<script src="https://code.jquery.com/jquery.js"></script>

<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 1300px;
}
h1{
   text-align: center;
}
.details:hover{
  cursor:pointer;
}
</style>
</head>
<body>
<div class="wrapper row3 rows">
  <main class="container clear">
    <div class="row">
      <div class="inline text-center">
		  <button class="btn btn-lg btn-danger" v-on:click="change(1)">상황</button>
		  <button class="btn btn-lg btn-info" v-on:click="change(2)">감성</button>
		  <button class="btn btn-lg btn-success" v-on:click="change(3)">스타일</button>
		  <button class="btn btn-lg btn-warning" v-on:click="change(4)">날씨/계절</button>   
	  </div> 
    </div>
    <div style="height:20px"></div>
    <div class="row">
      <div class="inline text-center">
        <span class="btn btn-lg btn-primary" v-for="r in recommend_list" style="margin:0 10px 0 0;" v-on:click="recommendData(r)">{{r}}</span>
      </div>
    </div>
    <div style="height:20px"></div>
    <div class="row">
	  <recommend_result v-bind:redata="recommend_data"></recommend_result>    
    </div>
    <div class="dialog" title="맛집 상세보기" style="display:none" class="details">
	  <p class="details"></p>
	</div>
  </main>
</div>  
<script>
  
  Vue.component("recommend_result",{
	  props:['redata'], //속성에 값 대입
	  template: '<div class="text-center">'
				+'  <div class="col-md-4" v-for="vo in redata">'
				+'  <div class="thumbnail">'
				+'      <img :src="vo.poster" style="width:width:250px;height:180px;" v-on:click="recommendDetail(vo.fno)">'
				+'      <div class="caption">'
				+'        <p><h4 class="details" v-on:click="recommendDetail(vo.fno)">{{vo.name}}</h4>&nbsp;<span style="color:orange;" v-on:click="recommendDetail(vo.fno)">{{vo.score}}</span></p>'
				+'      </div>'
				+' </div>'
				+'  </div>'
				+'  </div>'
				+'</div>',
	  methods:{
		  recommendDetail:function(fno){
			  this.$parent.recommendDetail(fno)
			  $('.dialog').dialog({
					  autoOpen:false, //클릭 시에만 오픈
					  modal:true,
					  width:1200, //모달창 크기 지정
					  height:800
				}).dialog("open")
		  }
	  }
  })
  
  new Vue({
	  el:'.rows',
	  data:{
		  recommend_list:[],
		  recommend_data:[],
		  recommend_detail:{}
	  },
	  methods:{
		  change:function(no){ //매개변수 있으면 넣기
			  let _this=this
			  axios.get('http://localhost/web/food/recommend_change.do',{
				  params:{
					  no:no  //매개변수:실제값	
				  }
			  }).then(function(response){
				  console.log(response.data) //디버깅용
				  _this.recommend_list=response.data
			  })
		  },
		  recommendData:function(r){
			  let _this=this
			  axios.get('http://localhost/web/food/recommend_result.do',{
				  params:{
					  ss:r
				  }
			  }).then(function(response){
				  console.log(response.data)
				  _this.recommend_data=response.data
			  })
		  },
		  recommendDetail:function(fno){
			  let _this=this
			  axios.get('http://localhost/web/food/recommend_detail.do',{
				  params:{
					  fno:fno
				  }
			  }).then(function(response){
				  console.log(response.data)
				  _this.recommend_detail=response.data

			  })
		  }
	  }
  })
</script>
</body>
</html>