/**
 * 
 */

/**
 * 
 */
var meta=meta || {};
meta.common=(function(){
	var init=function(x){
		meta.session.init(x);
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){
		
	};
	return {
		init : init
	};
})();

var $$=function(){return meta.session.getPath('ctx');};
var js=function(){return meta.session.getPath('js');};
var css=function(){return meta.session.getPath('css');};
var img=function(){return meta.session.getPath('img');};

meta.session=(function(){
	var init=function(x){
		onCreate(x);
	};
	var onCreate=function(x){
		setContentView(x);
	};
	var setContentView=function(x){
		sessionStorage.setItem('ctx',x);
		sessionStorage.setItem('js',x+"/resources/js");
		sessionStorage.setItem('css',x+"/resources/css");
		sessionStorage.setItem('img',x+"/resources/img");
	};
	var getPath=function(x){
		return sessionStorage.getItem(x);
	};
	return {
		init : init,
		getPath : getPath
	};
})();

meta.index=(function(){
	var $wrapper;
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		$('#button').on('click',function(){
			alert('버튼 클릭 !!');
			$wrapper.empty();
		});
	};
	var setContentView=function(){
		$wrapper=$('#wrapper');
		var $image=$('<img/>',
			{
				id: 'sigong',
				src: "http://img1.itenjoy.co.kr/files/attach/images/110/772/002/d0aa9adf8d50aaea20d533ed9ca0200d.jpg"
			}
				);
		$wrapper.append($image);
		
		var $button=$('<input/>',
			{
				id : 'button',
				type : 'button',
				value : '버튼'
			});
		$wrapper.append($button);
	};
	return {
		init : init
		};
})();

meta.main=(function(){
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

