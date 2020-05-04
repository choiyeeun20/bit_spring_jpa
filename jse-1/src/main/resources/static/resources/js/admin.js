"use strict"
var admin = admin || {}
admin = (()=>{
	let init = ()=>{
		onCreate()
	}
	let onCreate = ()=>{
		setContentView()
		$.getJSON('/users', d=>{
			$.each(d, (i,j)=>{
				$(`<tr><td>${i+1}</td><td>${j.name}</td><td>${j.userid}</td><td>${j.ssn}</td><td>${j.email}</td><td>${j.phoneNubmer}</td><td>${j.registerDate}</td></tr>`)
				.appendTo('#admin_list')
				.css({border : '1px solid black'})
			})
		})
	}
	let setContentView = ()=>{
		 $('#admin_list tr').addClass('border_black').css({height:'30px'})
		 $('#admin_list tr').first().css({'background-color':'yellow'})
		 $('#admin_list tr td').addClass('border_black').css({width: '14%'})
	}
	return {init}
})()