

//底部扩展键
$(function() {
    $('#doc-dropdown-js').dropdown({justify: '#doc-dropdown-justify-js'});
});

$(function(){
	$(".office_text").panel({iWheelStep:32});
});

//tab for three icon	
$(document).ready(function(){
  	$(".sidestrip_icon a").click(function(){
      $(".sidestrip_icon a").eq($(this).index()).addClass("cur").siblings().removeClass('cur');
	  $(".middle").hide().eq($(this).index()).show();
    });
});

//input box focus
$(document).ready(function(){
  	$("#input_box").focus(function(){
       $('.windows_input').css('background','#fff');
       $('#input_box').css('background','#fff');
   });
    $("#input_box").blur(function(){
       $('.windows_input').css('background','');
       $('#input_box').css('background','');
    });
});

window.onload=function b(){
	var text = document.getElementById('input_box');
	var chat = document.getElementById('chatbox');
	var btn = document.getElementById('send');
	var talk = document.getElementById('talkbox');

	btn.onclick=function(){
		if(text.value ==''){
            alert('不能发送空消息');
        }else{
			// $.ajax({
			// 		url:"/usedcar/sendTalk?",
			// 		type:"post",
			// 		dataType:"text",
			// 		success:function (result) {
			//
			// 		},
			// 		error:function () {
			// 			alert("发送消息响应失败");
			// 		}
			// 	})

			//alert("脚本");
			chat.innerHTML += '<li class="me"><img src="'+'images/icon/me.png'+'"><span>'+text.value+'</span></li>';
			text.value = '';
			chat.scrollTop=chat.scrollHeight;
			talk.style.background="#fff";
			text.style.background="#fff";
		};
	};
};

/*单击列表查看消息*/
function showAllTalk(otherid,obj) {
	var chatList=$(obj>".user_time");
	chatList.val("");
	chatList.css("background","#dedbdb");

	var meid=$("#loginUser").val();//当前登录的用户

	$("input[name='idmeid']").val(meid);
	$("input[name='idotherid']").val(otherid);

	var otheruserName=$(obj).find("p").html();//聊天人姓名

	var unread=$(obj).find(".user_time");

	unread.html("");
	unread.css("background","#dedbdb");
	$.ajax({
			url:"/usedcar/getTalkinfo?meid="+meid+"&otherid="+otherid,
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#chatbox").html("");
				var tr="";
				for (var i=0;i<obj.length;i++){
	                var ta=obj[i];
	                if(ta.meuser.uid==meid){
						tr+="<li class=\"me\"><img src=\"images/icon/me.png\" title=\""+ta.meuser.uname+"\"><span>"+ta.talkmsg+"</span></li>";
					}else{
						tr+="<li class=\"other\"><img src=\"images/icon/other.png\" title=\""+ta.otheruser.uname+"\"><span>"+ta.talkmsg+"</span></li>";
					}
	    		}
				$("#talkTopTitle").html(otheruserName);
				$("#chatbox").append(tr);
			},
			error:function () {
				alert("响应失败");
			}
		})
}



/*单击列表查看消息*/
function showAllTalk2(otherid,obj) {
	alert("aaa");
	var chatList=$(obj>".user_time");
	chatList.val("");
	chatList.css("background","#dedbdb");

	var meid=$("#loginUser").val();//当前登录的用户

	$("input[name='idmeid']").val(meid);
	$("input[name='idotherid']").val(otherid);

	var otheruserName=$(obj).find("p").html();//聊天人姓名

	var unread=$(obj).find(".user_time");

	unread.html("");
	unread.css("background","#dedbdb");
	$.ajax({
		url:"/usedcar/getTalkinfo2?meid="+meid+"&otherid="+otherid,
		type:"post",
		success:function (result) {
			var obj=eval(result);
			$("#chatbox").html("");
			var tr="";
			for (var i=0;i<obj.length;i++){
				var ta=obj[i];
				if(ta.meuser.uid==meid){
					tr+="<li class=\"me\"><img src=\"images/icon/me.png\" title=\""+ta.meuser.uname+"\"><span>"+ta.talkmsg+"</span></li>";
				}else{
					tr+="<li class=\"other\"><img src=\"images/icon/other.png\" title=\""+ta.otheruser.uname+"\"><span>"+ta.talkmsg+"</span></li>";
				}
			}
			$("#talkTopTitle").html(otheruserName);
			$("#chatbox").append(tr);
		},
		error:function () {
			alert("响应失败");
		}
	})
}






















































