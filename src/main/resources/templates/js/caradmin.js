
//上一页方法
function prePage(){
	var thisPage=$("#carthisPage").html();
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
	var thisPage=$("#carthisPage").html();
	var pageCount=$("#carpageCount").html();
	if(thisPage >= pageCount){
		alert("是在下给不了你更多了~~~");
	}else{
		//异步刷新获取下一页的值
		alert("下一页");
	}
}


//查看车详情
function carinfo(cid){
	//alert(cid);
	
	//异步刷新获取一辆车的详细信息
	location="carinfo.html";
}

//修改车详情
function updcar(cid){
	//alert(cid);
	
	location="adminUpdCar.html";
}

//删除车方法 
function delcar(cid){
	//alert(cid);
	
	if(confirm("确定要下架这辆车吗？")){
		//下架
		
	}
}
