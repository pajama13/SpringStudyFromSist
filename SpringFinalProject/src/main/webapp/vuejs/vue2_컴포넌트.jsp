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

</head>
<body>

<!--
  <div id="app">
    <h1>{{message}}</h1>
    <my-component1 v-bind:pdata="senddata">{{pdata}}</my-component1>
    <my-component2 v-bind:pdata="senddata2"></my-component2>
  </div>
  
  <template id="aaa">
    <h1>Hello Component</h1>
    <h3>{{pdata}}</h3>
  </template>
-->
  <input type=text size=20>
  <template id="addTag">
  
  </template>
  
  <script>
/*     
	Vue.component('my-component2',{
    	props:['pdata'],
    	template:'#aaa'
    })
    Vue.component('my-component1',{
    	props:['pdata'],
    	template:'<h3>My-Component1:{{pdata}}</h3>'
    })
    new Vue({
    	el:'#app',
    	data:{
    		message:'Vue Component',
    		sendData:'my-component1 데이터 전송',
    		sendData2:'my-component 데이터 전송' 
    	}
    }) */
    
    Vue.component('my-tag',{
    	props:['pdata'],
    	template:''
    })
  </script>
</body>
</html>