
$(function(){
	 
	/*$('.banShow').cycle(
	{
		
		fx:'fade',
		timeout:6000,
		next:'.nexts',
		prev:'.prevs'
	}
	); */
   
	$('.c-item').hover(function(){
		
		$(this).toggleClass('active');
	});
	
	$(window).bind('scroll',function(e){
		var sTop=$(window).scrollTop();
		if(sTop<=460){
			
			$('.head-search').hide();
			$('#header .logo').hide();
			$('.nav a:first').css('padding-left','0px');
		}else{
			$('.head-search').fadeIn();
			$('#header .logo').show();
			$('.nav a:first').css('padding-left','20px');
		}
	});
	
	$(".slide").slide({titCell:'.hd li',mainCell:".bd ul",effect:"fold",autoPlay:true,vis:1});
	
	$('.mDiv').hover(function(){
		$(this).addClass('active');
	})
	$('.jpTit a').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.jpDl').eq(index).fadeIn().siblings().hide();
		})
	});


})
function regcheck() {
	var phone =$("input[id=phone2]").val();
	var uname =$("input[name=uname]").val();
	var upwd =$("input[id=upwd2]").val();
	//alert("手机号"+phone+uname+upwd);
	//alert("密码"+upwd);
	$.ajax({
		type: 'post',
		url: 'Userphone',
		data:'phone='+phone,
		dataType:'text',
		success:function (result) {
			$("input[name=phone1]").val(result);
			alert(result);
			if (result=="yes") {
				alert("该手机号已存在,请勿重复注册");
				$("#form2").attr("action","index");
				location.href="/usedcar/index";
				return false;
			}
			if(result=="no"){
				alert("注册成功");
				$("#form2").attr("action","register");
				location.href="/usedcar/register?phone="+phone+"&uname="+uname+"&upwd="+upwd;
				return true;
			}
		},
		error:function() {
			alert("失败");
		}
	})
	// return false;


};
