<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Index</title>
	</head> 
	<body>
		<div id="index">
			<h2>{{ message }}</h2>
			<h2>${user.nm}</h2>
		</div>
	</body>
	<script src="/statics/js/vuejs/vue.min.js"></script>
	<script src="/statics/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var app = new Vue({
		  el: '#index',
		  data: {
		    message: 'asdf'
		  },
		  mounted : function()
	        {
	            this.getUserInfo();
	        },
	        methods:
	        {
	        	getUserInfo: function()
	            {

	        		$.ajax({

						url : '/service/rest/user/891152',
	        			dataType: 'json',
	        			method: 'get'
// 	        			,
// 	        			data: {id : '8911520'}
	        		}).done(function(user) {

	        		    alert( user.nm );

	        		  })

	        		  .fail(function() {

	        		    alert( "error" );

	        		  })




	        		
// 	        		this.$http.get('/rest/user/8911520', function(user)
// 	                {
// 	                    alert(user.nm);
// 	                });
	            }
	        }

		})
	</script>
</html>
