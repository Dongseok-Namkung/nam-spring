<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Index</title>
		<link href="/statics/framework/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
		
	</head> 
	<body>
		<div id="index">
			<h2>{{ nm }}</h2>
			<h2>${user.nm}</h2>
		</div>
		<input v-model="nm" placeholder="여기를 수정해보세요">
		
		<span>Multiline message is:</span>
<p>{{ message }}</p>
<br>
<textarea v-model="message" placeholder="add multiple lines"></textarea>

		
	
	<script src="/statics/js/vuejs/vue.min.js"></script>
	<script src="/statics/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="/statics/framework/bootstrap-3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var index = new Vue({
		  el: '#index',
		  data: {
		    nm: '',
		    message: ''
		  },
		  mounted : function()
	        {
	            this.getUserInfo();
	        },
	        methods:
	        {
	        	getUserInfo: function()
	            {
					var $this = this;
					
	        		$.ajax({

						url : '/service/rest/user/8911520',
	        			dataType: 'json',
	        			method: 'get'
// 	        			,
// 	        			data: {id : '8911520'}
	        		}).done(function(user) {
	        			$this.nm = user.nm;
	        			$this.message = user.nm;

	        		  })

	        		  .fail(function(request,status,error) {

	        		    alert( request.responseText );

	        		  })
	            }
	        }

		})
	</script>
	</body>
	
</html>
