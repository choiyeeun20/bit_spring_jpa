"use strict"
var user = user || {}
user = (()=>{
	const WHEN_ERROR = `호출하는 js 파일을 찾지 못했습니다.`
	let admin_vue
	let init = ()=>{
		admin_vue = `/resources/vue/admin_vue.js`
		onCreate()
	}
	let onCreate = () => {
		$.when(
			$.getScript(admin_vue)
		).done(()=>{
			setContentView()
			 $('#register_a').click(e=>{
		         e.preventDefault()
		         $('#content').empty()
		         $('#content').html(adminVue.join())
		         $(`<input type="button"/>`)
		         .attr({value:'Register'})
		         .css({width : '300px', height : '50px', 'font-size': '30px' })
		         .appendTo('#button_box')
		         .click(e=>{
		        	 $.ajax({
		        		 url:'/admins',
		    			 type:'post',
		    			 data:JSON.stringify({
		    				 name:$('#name').val(),
		    				 position:$('#position').val(),
		    				 email:$('#email').val(),
		    				 phoneNumber:$('#phoneNumber').val()
		    			 }),
		    			 dataType:'json',
		    			 contentType:'application/json',
		    			 success: d=>{
		    				 if(d==='SUCCESS'){
		    					 location.href="/user"
		    				 } else {
		    					 alert('회원가입실패')
		    				 }
		    			 },
		    			 error: (req,x,err)=>{
		    				 alert(req.status)
		    			 }
		        	 })
		         })
		         $(`<input type="button"/>`)
		         .attr({value:'Cancel'})
		         .css({width : '300px', height : '50px', 'font-size': '30px' })
		         .appendTo('#button_box')
		         .click(e=>{
		        	 e.preventDefault()
		        	 alert('취소버튼클릭')
		         })
		     })
		     $('#access_a').click(e=>{
		    	 e.preventDefault()
		    	 $('#content').empty()
		    	 $('#content').html(adminVue.login())
		    	 $(`<input type="button"/>`)
		    	 .attr({value:'Sign_in'})
		    	 .appendTo($('#login_box'))
		    	 .click(e=>{
		    		 e.preventDefault()
		    		 $.ajax({
		    			 url:'/admins/'+$('employNumber').val(),
		    			 type:'post',
		    			 data:JSON.stringify({
		    				 employNumber:$('#employNumber').val(),
		    				 password:$('#password').val()
		    			 }),
		    			 dataType:'json',
		    			 contentType:'application/json',
		    			 success: d=>{
		    				 if(d.messenger==='SUCCESS'){
		    					 location.href="/admin"
		    				 } else {
		    					 alert('로그인실패')
		    				 }
		    			 },
		    			 error: (req,x,err)=>{
		    				 alert(req.status)
		    			 }
		    		 })
		    		 
		    	 })
		    	 $(`<input type="button"/>`)
		    	 .attr({value:"Cancel"})
		    	 .appendTo($('#login_box'))
		    	 .click(e=>{
		    		 e.preventDefault()
		    		 alert('취소버튼클릭')
		    	 })
		     })
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
		
	}
	let setContentView = () => {
		 $('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
	     $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#kcdc td').addClass('border_black', 'width_full')
	}
	
	return {init}
})()