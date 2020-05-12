//$(function(){
//	$("#myModal").modal("toggle");
//})

//上一页方法
function prePage(){
	var thisPage=$("#brandthisPage").html();
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
	var thisPage=$("#brandthisPage").html();
	var pageCount=$("#brandcarpageCount").html();
	if(thisPage >= pageCount){
		alert("是在下给不了你更多了~~~");
	}else{
		//异步刷新获取下一页的值
		alert("下一页");
	}
}

//获取车品牌下的车系
function brandCarseries(bid){
	//alert(bid);
	
	//异步刷新取到列表下的车系，赋值给模态框
}

