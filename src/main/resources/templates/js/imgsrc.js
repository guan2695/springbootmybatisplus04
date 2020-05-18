$(function(){
	
		$(".li01 ul li span").click(function(){
			$(this).addClass("mo");
			$(this).siblings().removeClass("mo");

		})
		$("#mo1").click(function(){
			$(".show").show();
			$(".hide1").hide();
			$(".hide1").find("span").removeClass("mo");
			$(".hide2").hide();
			$(".hide2").find("span").removeClass("mo");
			$(".hide3").hide();
			$(".hide3").find("span").removeClass("mo");
			$(".hide4").hide();
			$(".hide4").find("span").removeClass("mo");
		});
		$("#mo2").click(function(){
			$(".show").hide();
			$(".show").find("span").removeClass("mo");
			$(".hide1").show();
			$(".hide2").hide();
			$(".hide2").find("span").removeClass("mo");
			$(".hide3").hide();
			$(".hide3").find("span").removeClass("mo");
			$(".hide4").hide();
			$(".hide4").find("span").removeClass("mo");

			});
		
		$("#mo3").click(function(){
			$(".show").hide();$(".show").find("span").removeClass("mo");
			$(".hide1").hide();$(".hide1").find("span").removeClass("mo");
			$(".hide2").show();
			$(".hide3").hide();	$(".hide3").find("span").removeClass("mo");
			$(".hide4").hide();$(".hide4").find("span").removeClass("mo");
		});
		$("#mo4").click(function(){
			$(".show").hide();$(".show").find("span").removeClass("mo");
			$(".hide1").hide();$(".hide1").find("span").removeClass("mo");
			$(".hide2").hide();$(".hide2").find("span").removeClass("mo");
			$(".hide3").show();
			$(".hide4").hide();$(".hide4").find("span").removeClass("mo");
		});
		
		$("#mo5").click(function(){
			$(".show").hide();$(".show").find("span").removeClass("mo");
			$(".hide1").hide();$(".hide1").find("span").removeClass("mo");
			$(".hide2").hide();$(".hide2").find("span").removeClass("mo");
			$(".hide3").hide();$(".hide3").find("span").removeClass("mo");
			$(".hide4").show();
		});
	})
	
