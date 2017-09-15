/**
 * Member javaScript
 */

var app=app || {};

app.path=(function(x){
     var init=function(x){
           app.session.init(x);
           onCreate();
     };
     var ctx=function(){
           return app.session.getPath('ctx');
     };
     var js=function(){
           return app.session.getPath('js');
     };
     var img=function(){
           return app.session.getPath('img');
     };
     var css=function(){
           return app.session.getPath('css');
     };
     
     var setContentView=function(){
     };
     var onCreate=function(){
           setContentView();
     };
     
     
     return {
           init : init,
           ctx : ctx,
           img : img,
            js : js,
           css : css   //리턴값 (클로저)에 포함시키지 않으면 외부에서 접근이 불가능하다. 그래서 은닉화 해야할정보는 다른 객체에서 호출해서 사용하면 된다.
     };
})();
app.session=(function(){
     var init=function(x){
           sessionStorage.setItem('ctx',x);
          /* sessionStorage.setItem('js',x);
           sessionStorage.setItem('img',x);
           sessionStorage.setItem('css',x);*/
     };
     var getPath=function(x){
           return sessionStorage.getItem(x);
     };
     return {
           init : init,
           getPath : getPath
           
     };
})();
app.member=(function(){
    var init=function(){
    	join();
    	login();
    };
    
    var join=function(){
    	$('#join').on('click',function(){
    		alert('join click...');
    		$('#join_form').attr('action',app.path.ctx()+"/member/join");
    		$('#join_form').attr('method',"post");
    	});
    };
    
    var login=function(){
    	 $('#loginBtn').on('click',function(){
         	   alert('click');
           if($('#member_id').val()===""){
                 alert('ID 를 입력해주세요');
                 return false;
           }
           if($('#password').val()===""){
                 alert('PASS 를 입력해 주세요');
                 return false;
           }
           $('#login_box').attr('action',app.path.ctx()+"/member/login");
           $('#login_box').attr('method',"post");
           return true;
            }); /*function(){} 이 이벤트 핸들러가 된다.*/
    };
    return {
          init : init
    };
})();

app.controller=(function(){
	
	var list=function(pageNumber){
		location.href=app.path.ctx()+"/member/move_list?search=null&pageNumber="+pageNumber;
	};
	
	var detail=function(id){
		alert(id);
		location.href=app.path.ctx()+"/member/detail?member_id="+id;
	};
	
	var moveTo=function(dir,action,page){
		alert(dir+"/"+action+"_"+page);
		location.href=app.path.ctx()+"/"+dir+"/"+action+"_"+page;
	};
	
	var Delete=function(x){
		alert('탈퇴할 회원 : '+x);
		location.href=app.path.ctx()+"/member/delete?member_id="+x;
	};
	
	var logout=function(){
		location.href=app.path.ctx()+"/common/logout/main";
	};
	
	var search=function(){
		
		alert('search click ..');
		
		var search=$('#search').val();
		location.href=app.path.ctx()+"/member/move_list?search="+search+"&pageNumber=1";
	};
	
	var update=function(){
		alert('update click ..');
		$('#update_form').attr('action',app.path.ctx()+"/member/update");
        $('#update_form').attr('method',"post");
	};
	
	var goUpdate=function(){
		location.href=app.path.ctx()+"/member/go_update";
	};
	
	return {
		detail : detail,
		moveTo : moveTo,
		Delete : Delete,
		logout : logout,
		list : list,
		search : search,
		update : update,
		goUpdate : goUpdate
	};
})();

app.main=(function(){
	var init=function(){
		onCreate();
	};
	
	var onCreate=function(){
		setContentView();
	};
	
	var setContentView=function(){
		
		$("#ul").attr("class","nav navbar-nav");
		$("#ul1").attr("class","dropdown-menu");
		$("#ul2").attr("class","dropdown-menu");
		$("#ul3").attr("class","dropdown-menu");
		$("#home").attr("class","navbar-brand");
		
		$("#member_join").on('click',function(){
			app.controller.moveTo('member','move','join');
		});
		
		$("#home").on('click',function(){
			app.controller.moveTo('common','move','home');
		});
		$("#login").on('click',function(){
			app.controller.moveTo('member','move','login');
		});
		$("#logout").on("click",function(){
			alert("logout !");
			app.controller.logout();
		});

		$("#ul1").children().eq(0).on('click',function(){
			app.controller.list('1');
		});
		
		$("#ul1").children().eq(1).on('click',function(){
			app.controller.moveTo('member','move','update');
		});
			
			$("#ul1").children().eq(2).on('click',function(){
				app.controller.moveTo('member','move','delete');
		});
			
			$("#ul2").children().eq(0).on('click',function(){
				app.controller.moveTo('grade','move','write');
		});
			$("#ul2").children().eq(1).on('click',function(){
				app.controller.moveTo('grade','move','list');
		});
			
			$("#ul2").children().eq(2).on('click',function(){
				app.controller.moveTo('grade','move','update');
			});
			
			$("#ul3").children().eq(0).on('click',function(){
				app.controller.moveTo('board','move','write');
			});
			$("#ul3").children().eq(1).on('click',function(){
				app.controller.moveTo('board','move','list');
			});
			$("#ul3").children().eq(2).on('click',function(){
				app.controller.moveTo('board','move','update');
			});
	};
	return {
		init : init
	};
})();
	
	




app.grade=(function(){
	var init=function(){};
	var onCreate=function(){};
	var setContentView=function(){};
	return{
		init : init
	};
})();

app.board=(function(){
	var init=function(){};
	var onCreate=function(){};
	var setContentView=function(){};
	return{
		init : init
	};
})();
	
	
	
