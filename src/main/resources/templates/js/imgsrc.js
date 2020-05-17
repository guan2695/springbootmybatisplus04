$(function(){
	
		$(".li01 ul li span").click(function(){
			$(this).css("background-color","#f9f9f9");
			$(this).css("color","#ff6600")
			$(this).siblings().css("color","#666");
			$(this).siblings().css("background-color","#fff");
		})
		$(".mo1").click(function(){
			$(".show").show();
			$(".hide1").hide();
			$(".hide2").hide();
			$(".hide3").hide();	
			$(".hide4").hide();
		});
		$(".mo2").click(function(){
			$(".show").hide();
			$(".hide1").show();
			$(".hide2").hide();
			$(".hide3").hide();	
			$(".hide4").hide();
			});
		
		$(".mo3").click(function(){
			$(".show").hide();
			$(".hide1").hide();
			$(".hide2").show();
			$(".hide3").hide();	
			$(".hide4").hide();
		});
		$(".mo4").click(function(){
			$(".show").hide();
			$(".hide1").hide();
			$(".hide2").hide();
			$(".hide3").show();
			$(".hide4").hide();
		});
		
		$(".mo5").click(function(){
			$(".show").hide();
			$(".hide1").hide();
			$(".hide2").hide();
			$(".hide3").hide();
			$(".hide4").show();
		});
	})
	
