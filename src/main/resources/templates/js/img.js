$(function(){
	 
		 $(".imgshow").hover(function(){
		     $(".left01").show();
			 $(".right01").show();
		 },function(){
		     $(".left01").hide();
			 $(".right01").hide();
		 });
		 
		 $(".left01").hover(function(){
		     $(this).show();
				$(".right01").show();
		 },function(){
		     $(this).show();
		 		 $(".right01").show();
		 });
		 
		 $(".right01").hover(function(){
		     $(this).show();
		 			$(".left01").show();
		 },function(){
		     $(this).show();
		 		 $(".left01").show();
		 });
		 
			$(".but-up").click(function(){
				$(".modimg").css("display","none")
			})
		$(".img01").click(function(){
			$(".sizefont2").css("color","#666666");
			$(".sizefont2").css("border"," none");
			$(".sizefont1").css("color","#ff6600");
			$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
			$(".modimg").css("display","block");
			$(".img-pad1").show();
			$(".img-pad2").hide();
			$(".img-pad3").hide();
			$(".img-pad4").hide();
			$(".img-pad5").hide();
			$(".img-pad6").hide();
			  $(".img_not4").css("border","3px #ff6633 solid");
			  $(".img_not5").css("border","none");
			   $(".img_not6").css("border","none");
			    $(".img_not7").css("border","none");
				 $(".img_not8").css("border","none");
				  $(".img_not9").css("border","none");
			i=0;
		})
		$(".img02").click(function(){
			$(".sizefont2").css("color","#666666");
			$(".sizefont2").css("border"," none");
			$(".sizefont1").css("color","#ff6600");
			$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
			$(".modimg").css("display","block");
			$(".img-pad2").show();
			$(".img-pad1").hide();
			$(".img-pad3").hide();
			$(".img-pad4").hide();
			$(".img-pad5").hide();
			$(".img-pad6").hide();
			 $(".img_not5").css("border","3px #ff6633 solid");
			 $(".img_not4").css("border","none");
			  $(".img_not6").css("border","none");
			   $(".img_not7").css("border","none");
			 			 $(".img_not8").css("border","none");
			 			  $(".img_not9").css("border","none");
			i=1;
		})
		$(".img03").click(function(){
			$(".sizefont2").css("color","#666666");
			$(".sizefont2").css("border"," none");
			$(".sizefont1").css("color","#ff6600");
			$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
			$(".modimg").css("display","block");
			$(".img-pad3").show();
			$(".img-pad2").hide();
			$(".img-pad1").hide();
			$(".img-pad4").hide();
			$(".img-pad5").hide();
			$(".img-pad6").hide();
			 $(".img_not6").css("border","3px #ff6633 solid");
			  $(".img_not4").css("border","none");
			  $(".img_not5").css("border","none");
			   
			    $(".img_not7").css("border","none");
			  			 $(".img_not8").css("border","none");
			  			  $(".img_not9").css("border","none");
			i=2;
		})
			
			$(".img_not1").hover(function(){
			   $(".img01").show();
			   $(".img02").hide();
			   $(".img03").hide();
			   $(this).css("border","3px #ff6633 solid");
			   $(".img_not2").css("border","none");
			    $(".img_not3").css("border","none");
			   i=0;
			},function(){
			     $(".img_not2").css("border","none");
			      $(".img_not3").css("border","none");
			});
			$(".img_not2").hover(function(){
				
			   $(".img02").show();
			   $(".img01").hide();
			   $(".img03").hide();
			   $(this).css("border","3px #ff6633 solid");
			   $(".img_not1").css("border","none");
			    $(".img_not3").css("border","none");
			   i=1;
			},function(){
			      $(".img_not1").css("border","none");
				   $(".img_not3").css("border","none");
			});
			$(".img_not3").hover(function(){
			   $(".img03").show();
			   $(".img01").hide();
			   $(".img02").hide();
			   $(this).css("border","3px #ff6633 solid");
			   $(".img_not2").css("border","none");
			    $(".img_not1").css("border","none");
			   i=2;
			},function(){
			     $(".img_not1").css("border","none");
			      $(".img_not2").css("border","none");
			});
			var i = 0;
			var one = parseInt("1");
			$(".left01").click(function(){
				if (i != 0) {
							i--;
							var he = one + i;
							var cha = he + 1;
							$(".img0" + he).show();
							$(".img0" + cha).hide();
							$(".img_not"+he).css("border","3px #ff6633 solid");
							$(".img_not"+cha).css("border","none");
						}
				
			})
			
			$(".right01").click(function(){
				if (i != 2) {
							i++;
							var he = one + i;
							var cha = he - 1;
							$(".img0" + he).show();
							$(".img0" + cha).hide();
							$(".img_not"+he).css("border","3px #ff6633 solid");
							$(".img_not"+cha).css("border","none");
						}
						
			})
			$(".img_not4").click(function(){
				$(".img-pad1").show();
				$(".img-pad2").hide();
				$(".img-pad3").hide();
				$(".img-pad4").hide();
				$(".img-pad5").hide();
				$(".img-pad6").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont2").css("color","#666666")
				$(".sizefont2").css("border","none");
				$(".sizefont1").css("color","#ff6600")
				$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not6").css("border","none");
				$(".img_not5").css("border","none");
				$(".img_not9").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not7").css("border","none");
				i=0;
			})
			$(".img_not5").click(function(){
				$(".img-pad2").show();
				$(".img-pad1").hide();
				$(".img-pad3").hide();
				$(".img-pad4").hide();
				$(".img-pad5").hide();
				$(".img-pad6").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont2").css("color","#666666")
				$(".sizefont2").css("border","none");
				$(".sizefont1").css("color","#ff6600")
				$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not4").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not7").css("border","none");
				$(".img_not9").css("border","none");
				i=1;
			})
			$(".img_not6").click(function(){
				$(".img-pad3").show();
				$(".img-pad2").hide();
				$(".img-pad1").hide();
				$(".img-pad4").hide();
				$(".img-pad5").hide();
				$(".img-pad6").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont2").css("color","#666666")
				$(".sizefont2").css("border","none");
				$(".sizefont1").css("color","#ff6600")
				$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not4").css("border","none");
				$(".img_not5").css("border","none");
				$(".img_not7").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not9").css("border","none");
				i=2;
			})
			$(".img_not7").click(function(){
				$(".img-pad4").show();
				$(".img-pad2").hide();
				$(".img-pad1").hide();
				$(".img-pad3").hide();
				$(".img-pad5").hide();
				$(".img-pad6").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont1").css("color","#666666")
				$(".sizefont1").css("border","none");
				$(".sizefont2").css("color","#ff6600")
				$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not4").css("border","none");
				$(".img_not5").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not9").css("border","none");
				i=3;
			})
			$(".img_not8").click(function(){
				$(".img-pad5").show();
				$(".img-pad2").hide();
				$(".img-pad1").hide();
				$(".img-pad3").hide();
				$(".img-pad4").hide();
				$(".img-pad6").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont1").css("color","#666666")
				$(".sizefont1").css("border","none");
				$(".sizefont2").css("color","#ff6600")
				$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not4").css("border","none");
				$(".img_not5").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not7").css("border","none");
				$(".img_not9").css("border","none");
				i=4;
			})
			$(".img_not9").click(function(){
				$(".img-pad6").show();
				$(".img-pad2").hide();
				$(".img-pad1").hide();
				$(".img-pad3").hide();
				$(".img-pad5").hide();
				$(".img-pad4").hide();
				$(this).css("border","3px #ff6633 solid");
				$(".sizefont1").css("color","#666666")
				$(".sizefont1").css("border","none");
				$(".sizefont2").css("color","#ff6600")
				$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
				$(".img_not4").css("border","none");
				$(".img_not5").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not7").css("border","none");
				i=5;
			})
			$(".sizefont1").click(function(){
				$(".img-pad1").show();
				$(".img-pad2").hide();
				$(".img-pad6").hide();
				$(".img-pad3").hide();
				$(".img-pad5").hide();
				$(".img-pad4").hide();
				$(".img_not4").css("border","3px #ff6633 solid");
				$(".img_not5").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not7").css("border","none");
				$(".img_not9").css("border","none");
				$(".sizefont2").css("color","#666666")
				$(".sizefont2").css("border","none");
				$(".sizefont1").css("color","#ff6600")
				$(".sizefont1").css("border-bottom"," 1.5px #ff6600 solid");
				i=0;
			})
			$(".sizefont2").click(function(){
				$(".img-pad4").show();
				$(".img-pad2").hide();
				$(".img-pad6").hide();
				$(".img-pad3").hide();
				$(".img-pad5").hide();
				$(".img-pad1").hide();
				$(".img_not7").css("border","3px #ff6633 solid");
				$(".img_not5").css("border","none");
				$(".img_not6").css("border","none");
				$(".img_not8").css("border","none");
				$(".img_not4").css("border","none");
				$(".img_not9").css("border","none");
				$(".sizefont1").css("color","#666666")
				$(".sizefont1").css("border","none");
				$(".sizefont2").css("color","#ff6600")
				$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
				i=3
			})
			var four =parseInt("4")
			$(".left02").click(function(){
				if (i != 0) {
							i--;
							var he = one + i;
							var cha = he + 1;
							$(".img-pad" + he).show();
							$(".img-pad" + cha).hide();
							var ve= four +i;
							var che= ve +1;
							$(".img_not"+ve).css("border","3px #ff6633 solid");
							$(".img_not"+che).css("border","none");
						}
						if(i==2
						
						){
							
								$(".sizefont1").css("color","#ff6600")
							$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
							$(".sizefont2").css("color","#666666")
							$(".sizefont2").css("border","none");
						}
			})
			
			$(".right02").click(function(){
				if (i != 5) {
							i++;
							var he = one + i;
							var cha = he - 1;
							$(".img-pad" + he).show();
							$(".img-pad" + cha).hide();
							var ve= four +i;
							var che= ve -1;
							$(".img_not"+ve).css("border","3px #ff6633 solid");
							$(".img_not"+che).css("border","none");
						}
						if(i==3){
								
								$(".sizefont2").css("color","#ff6600")
							$(".sizefont2").css("border-bottom"," 1.5px #ff6600 solid");
							$(".sizefont1").css("color","#666666")
							$(".sizefont1").css("border","none");
						}
			})
});
			
