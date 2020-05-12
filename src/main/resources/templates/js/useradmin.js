//查看用户详情方法
function userinfo(uid){
	//alert(uid);
	//异步刷新到userinfo.html
	location.href="userinfo.html";
}

//删除用户方法
function deluser(uid){
	//alert(uid);
	if(confirm("确定要删除这个用户吗？")){
		
	}
}

//上一页方法
function prePage(){
	var thisPage=$("#userthisPage").html();
	//alert(thisPage);
	if(thisPage<=1){
		alert("这已经是第一页啦~~~");
	}else{
		//异步刷新获取上一页的值
		alert("上一页");
		
	}
		
	
}

//下一页方法
function nextPage(){
	var thisPage=$("#userthisPage").html();
	var pageCount=$("#userpageCount").html();
	if(thisPage >= pageCount){
		alert("是在下给不了你更多了~~~");
	}else{
		//异步刷新获取下一页的值
		alert("下一页");
	}
}
