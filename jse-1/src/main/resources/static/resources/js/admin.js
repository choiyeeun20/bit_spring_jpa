"use strict"

var admin = admin || {}

admin = (() => {
	const WHEN_ERROR = `호출하는 js 파일을 찾지 못했습니다.`
	let admin_vue
		
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js`
		onCreate()
	}
	
	let onCreate = () => {
		$.when(
				$.getScript(admin_vue)
		).done(()=>{
			setContentView()
			$.getJSON('/users', d => {
				$.each(d, (i, j) => {
					$('#total_count').text('총 회원 수 : ' + d.length)
					$(`<tr>
	                        	<td>
	                                <span>${i+1}</span>
	                            </td>
	                            <td>
	                                <span>${j.userid}</span>
	                            </td>
	                            <td>
	                                <span id=${j.name}></span>
	                            </td>
	                             <td>
	                                <span>${j.ssn}</span>
	                            </td>
	                           <td>
	                                <span>${j.email}</span>
	                            </td>
	                            <td>
	                                <span>${j.phoneNubmer}</span>
	                            </td>
	                            <td>
	                                <span>${j.registerDate}</span>
	                            </td>
	                            
	                        </tr>`).appendTo('#userData')
	                        
	                        $(`<a>${j.name}</a>`)
	                        .appendTo(`#${j.name}`)
	                        .css({cursor:'pointer',color:'blue'})
	                        .click(e=>{
	                        	e.preventDefault()
	                        	$.getJSON(`/users/${j.name}`, d=>{
	                        		$('#content').empty()
	                        		$('#content').html(adminVue.detail())
	                        		$('#name').text(d.name)
	                        		$('#userid').text(d.userid)
	                        		$('#ssn').text(d.ssn)
	                        		$('#address').text(d.address)
	                        		$('#email').text(d.email)
	                        		$('#phoneNubmer').text(d.phoneNubmer)
	                        		$('#registerDate').text(d.registerDate)
	                        	})
	                        })
				})
			})
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
	
})()