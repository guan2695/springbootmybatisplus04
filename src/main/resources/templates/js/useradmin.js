var userpageCount=0;
//获得用户列表总页码
$(function () {
	userpageCount=$("#userpageCount").html();
})

//得到用户列表总页码
// function getUserListPageCount() {
// 	$.ajax({
// 			url:"/usedcar/adminUserPageCount",
// 			type:"post",
// 			success:function (result) {
// 				userpageCount=eval(result);
// 				alert("获取页码"+userpageCount);
// 				$("#userpageCount").html(userpageCount);
// 			},
// 			error:function () {
// 				alert("响应失败");
// 			}
// 		})
// }

//单击logo图片
function logoGo() {
    location.href="/usedcar/adminIndex?pageIndex=1";
}

//查看用户详情方法
function userinfo(uid){
	//alert(uid);
    location.href="/usedcar/adminLookUser?uid="+uid;
}

//删除用户方法
function deluser(uid){
	//alert(uid);
	if(confirm("确定要删除这个用户吗？")){
		$.ajax({
				url:"/usedcar/adminDelUser?uid="+uid,
				type:"post",
				dataType:"text",
				success:function (result) {
					// var obj=eval(result);
					if(result=="yes"){
						alert("删除成功");
						// getUserListPageCount();
						adminAllUser();
					}else{
						alert("删除失败");
					}
				},
				error:function () {
					alert("删除用户响应失败");
				}
			})
	}
}

//用户列表上一页方法
function prePage(){
	var thisPage=$("#userthisPage").html();
	//alert(thisPage);
	if(thisPage<=1){
		alert("这已经是第一页啦~~~");
	}else{
		//异步刷新获取上一页的值
		//alert("上一页");
		thisPage=Number(thisPage)-1;
        var thispage2=Number(thisPage)-1;
		$("#userthisPage").html(thisPage);
        //改变下拉列表
        changeSelect(thispage2);
		userFenye(thisPage);
	}
		
	
}

//用户列表下一页方法
function nextPage(){
	var thisPage=$("#userthisPage").html();
	userpageCount=$("#userpageCount").html();
	if(thisPage >= userpageCount){
		alert("是在下给不了你更多了~~~");
	}else{
		thisPage=Number(thisPage)+1;
		var thispage2=Number(thisPage)-1;	//用来改变下拉列表的默认值
		$("#userthisPage").html(thisPage);
		//改变下拉列表
        changeSelect(thispage2);
        userFenye(thisPage);
	}
}

/*用户下拉列表分页*/
function fenyeSelect() {
    var thisPage=$("#fenyeSelect").val();
    //alert(thisPage);
    $("#userthisPage").html(thisPage);
    userFenye(thisPage);
}

/*用户切换页码异步刷新*/
function userFenye(thisPage) {
	$.ajax({
		url:"/usedcar/adminIndex2?pageIndex="+thisPage,
		type:"post",
		success:function (result) {
			$("#adminRightTable").html("");
			var tr="<tr>\n" +
				"\t\t\t\t\t\t\t<td>序号</td>\n" +
				"\t\t\t\t\t\t\t<td>用户名</td>\n" +
				"\t\t\t\t\t\t\t<td>密码</td>\n" +
				"\t\t\t\t\t\t\t<td>余额</td>\n" +
				"\t\t\t\t\t\t\t<td>手机</td>\n" +
				"\t\t\t\t\t\t\t<td>查看</td>\n" +
				"\t\t\t\t\t\t\t<td>删除</td>\n" +
				"\t\t\t\t\t\t</tr>";
			var obj=eval(result);
			for (var i=0;i<obj.length;i++){
				var u=obj[i];
				// alert(u.uid);
				tr+="<tr>\n" +
					"\t\t\t\t\t\t<td>"+u.uid+"</td>\n" +
					"\t\t\t\t\t\t<td>"+u.uname+"</td>\n" +
					"\t\t\t\t\t\t<td>"+u.upwd+"</td>\n" +
					"\t\t\t\t\t\t<td>"+u.money+"万元</td>\n" +
					"\t\t\t\t\t\t<td>"+u.phone+"</td>\n" +
					"\t\t\t\t\t\t<td><button class=\"btn btn-info btn-xs\" onclick=\"userinfo("+u.uid+")\">查看</button></td>\n";
				if(u.uid<16){
					tr+="\t\t\t\t\t\t<td><button class=\"btn btn-danger btn-xs \"  disabled=\"disabled\" onclick=\"deluser("+u.uid+")\">删除</button></td>\n" +
						"\t\t\t\t\t</tr>";
				}else{
					tr+="\t\t\t\t\t\t<td><button class=\"btn btn-danger btn-xs \"  onclick=\"deluser("+u.uid+")\">删除</button></td>\n" +
						"\t\t\t\t\t</tr>";
				}

			}
			$("#adminRightTable").append(tr);
		},
		error:function () {
			alert("响应错误");
		}
	})
}

/*用户拼接页码*/
function userPageYemaAjax(thispage) {
	// getUserListPageCount();
	$.ajax({
		url:"/usedcar/adminUserPageCount",
		type:"post",
		success:function (result) {
			userpageCount=eval(result);
			//alert("获取页码"+userpageCount);
			$("#userpageCount").html(userpageCount);


			//alert(userpageCount);
			$("#BodyFenYeUl").html("");
			var ultr="<li class=\"previous\"><a onclick=\"prePage()\"><span aria-hidden=\"true\">&larr;</span> 上一页</a></li>\n" +
				"\t    \t<li ><a><span id=\"userthisPage\">"+thispage+"</span> &nbsp;/&nbsp; <span id=\"userpageCount\">"+userpageCount+"</span></a></li>\n" +
				"\t    \t<li class=\"next\"><a onclick=\"nextPage()\">下一页 <span aria-hidden=\"true\">&rarr;</span></a></li>\n" +
				"\t    \t<li class=\"next\">\n" +
				"                <select id=\"fenyeSelect\" onchange=\"fenyeSelect()\">";
			for (var i=1;i<=userpageCount;i++) {
				// if(i==thispage){
				// 	ultr+="<option selected='selected' value=\""+i+"\">"+i+"</option>";
				// }else {
				ultr+="<option value=\""+i+"\">"+i+"</option>";
				// }

			}
			ultr+="</select>\n" +
				"            </li>";
			$("#BodyFenYeUl").append(ultr);
		},
		error:function () {
			alert("响应失败");
		}
	});

}

/*改变页码下拉列表的选中项*/
function changeSelect(thispage2) {
    //alert(thispage2);
    var osel=document.getElementById("fenyeSelect"); //得到select的ID
    var opts=osel.getElementsByTagName("option");//得到数组option
	//alert(osel.innerHTML+"   "+opts[0].innerHTML);
    opts[thispage2].selected=true;//设置option第4个元素
}
