"use strict"
var user = user || {}
user = (()=>{
	let init = () => {
		onCreate()
	}
	let onCreate = () => {
		setContentView()
		 $('#register_a').click(e=>{
	         e.preventDefault()
	         location.href = "/admin"
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