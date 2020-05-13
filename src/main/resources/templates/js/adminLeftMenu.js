
//车辆列表总页码
var carPageCount=0;

/*菜单点击样式变化*/
$(function(){
	$("#leftUl>li").click(function(){
		$("#leftUl>li").attr("class","");
		$(this).attr("class","active");
	});

})

/*查询所有用户*/
function adminAllUser(){
	//alert("查询所有用户");
	// location.href="/usedcar/adminIndex?pageIndex=1";
	$("#bodyRightH").html("所有用户");
	userFenye(1);
	userPageYemaAjax(1);
	// $("#userthisPage").html(1);
	// changeSelect(0);
}

/*查询所有车辆信息*/
function adminAllCar(){
	//alert("查询所有车辆信息");
	//获取总页码
	$.ajax({
		url:"/usedcar/adminCarPageCount",
		type:"post",
		success:function (result) {
			carPageCount=eval(result);
			//alert(carPageCount);
			carPageAjax(1);	//拼接第一页表格
			carPageYemaAjax(1);	//拼接页码
		},
		error:function () {
			alert("获取页码响应失败");
		}
	});
}

/*车辆列表下一页方法*/
function carnextPage() {
	var carthisPage=$("#carthisPage").html();
	if(carthisPage>=carPageCount){
		alert("是在下给不了你更多了~~~");
	}else{
		carthisPage=Number(carthisPage)+1;
		var carthisPage2=Number(carthisPage)-1;	//用来改变下拉列表的默认值
		$("#carthisPage").html(carthisPage);
		/*改变下拉列表*/
		CarfenyeSelect(carthisPage2);
		carPageAjax(carthisPage);
	}
}

/*车辆上一页方法*/
function carprePage() {
	var carthisPage=$("#carthisPage").html();
	if(carthisPage<=1){
		alert("这已经是第一页啦~~~");
	}else{
		carthisPage=Number(carthisPage)-1;
		var carthisPage2=Number(carthisPage)-1;
		$("#carthisPage").html(carthisPage);
		//改变下拉列表
		CarfenyeSelect(carthisPage2);
		carPageAjax(carthisPage);
	}
}

/*车辆下拉列表跳转页*/
function CarfenyeYeMaSelect() {
	var carthisPage=$("#CarfenyeSelect").val();
	$("#carthisPage").html(carthisPage);
	carPageAjax(carthisPage);
}

/*改表车列表下拉列表默认值*/
function CarfenyeSelect(carthisPage2) {
	//alert(carthisPage2);
	var osel=document.getElementById("CarfenyeSelect"); //得到select的ID
	var opts=osel.getElementsByTagName("option");//得到数组option
	opts[carthisPage2].selected=true;//设置option第0个元素
}

/*车辆分页异步刷新*/
function carPageAjax(pageIndex) {
	$.ajax({
		url:"/usedcar/adminCarList?pageIndex="+pageIndex,
		type:"post",
		success:function (result) {
			$("#bodyRightH").html("所有车辆");
			$("#adminRightTable").html("");
			var tr="<tr>\n" +
				"      \t\t<td>序号</td>\n" +
				"      \t\t<td>车品牌</td>\n" +
				"      \t\t<td>车系</td>\n" +
				"      \t\t<td>颜色</td>\n" +
				"      \t\t<td>所属用户</td>\n" +
				"      \t\t<td>原价(万元)</td>\n" +
				"      \t\t<td>现价(万元)</td>\n" +
				"      \t\t<td>是否上架</td>\n" +
				"      \t\t<td>是否过审</td>\n" +
				"      \t\t<td>所属地区</td>\n" +
				"      \t\t<td>车龄(年)</td>\n" +
				"      \t\t<td>图片路径</td>\n" +
				"      \t\t<td>查看</td>\n" +
				"      \t\t<td>修改</td>\n" +
				"      \t\t<td>操作</td>\n" +
				"      \t</tr>";
			var obj=eval(result);
			for(var i=0;i<obj.length;i++){
				var c=obj[i];
				var putstate=0;
				var assesstate=0;
				if(c.putstate==0){
					putstate="否";
				}else{
					putstate="是";
				}
				if(c.assesstate==0){
					assesstate="否";
				}else{
					assesstate="是";
				}
				tr+="<tr>\n" +
					"      \t\t<td>"+c.imagesList[0].cid+"</td>\n" +
					"      \t\t<td>"+c.brand.bname+"</td>\n" +
					"      \t\t<td>"+c.cardseries.csname+"</td>\n" +
					"      \t\t<td>"+c.corol.corol+"</td>\n" +
					"      \t\t<td>"+c.user.uname+"</td>\n" +
					"      \t\t<td>"+c.oprice+"</td>\n" +
					"      \t\t<td>"+c.price+"</td>\n" +
					"      \t\t<td>"+putstate+"</td>\n" +
					"      \t\t<td>"+assesstate+"</td>\n" +
					"      \t\t<td>"+c.address.address+"</td>\n" +
					"      \t\t<td>"+c.carage+"</td>\n" +
					"      \t\t<td>"+c.img+"</td>\n" +
					"      \t\t<td><button class=\"btn btn-info btn-xs\" onclick=\"carinfo("+c.imagesList[0].cid+")\">查看</button></td>\n" +
					"      \t\t<td><button class=\"btn btn-primary btn-xs\" onclick=\"updcar("+c.imagesList[0].cid+")\">修改</button></td>\n" +
					"      \t\t<td><button class=\"btn btn-danger btn-xs\" onclick=\"delcar("+c.imagesList[0].cid+")\">下架</button></td>\n" +
					"      \t</tr>";
			}
			$("#adminRightTable").append(tr);

		},
		error:function () {
			alert("车辆分页响应失败");
		}
	})
}

/*车辆拼接切页*/
function carPageYemaAjax(carthisPage) {
	/*页码*/
	$("#BodyFenYeUl").html("");
	var ultr="<li class=\"previous\"><a onclick=\"carprePage()\"><span aria-hidden=\"true\">&larr;</span> 上一页</a></li>\n" +
		"\t    \t<li ><a><span id=\"carthisPage\">"+carthisPage+"</span> &nbsp;/&nbsp; <span id=\"carpageCount\">"+carPageCount+"</span></a></li>\n" +
		"\t    \t<li class=\"next\"><a onclick=\"carnextPage()\">下一页 <span aria-hidden=\"true\">&rarr;</span></a></li>\n" +
		"\t    \t<li class=\"next\">\n" +
		"                <select id=\"CarfenyeSelect\" onchange=\"CarfenyeYeMaSelect()\">";
	for (var i=1;i<=carPageCount;i++) {
		// if(i==carthisPage){
		// 	ultr+="<option selected value=\""+i+"\">"+i+"</option>";
		// }else {
			ultr+="<option value=\""+i+"\">"+i+"</option>";
		// }

	}
	ultr+="</select>\n" +
		"            </li>";
	$("#BodyFenYeUl").append(ultr);

}

/*查询所有审核申请*/
function adminAllAssessment(){
	alert("查询所有审核申请");
}

/*查询所有品牌*/
function adminAllBrand(){
	alert("查询所有品牌");
}

/*添加品牌*/
function adminAddBrand(){
	alert("添加品牌");
}

/*查询所有颜色*/
function adminAllCorol(){
	alert("查询所有颜色");
}

/*添加颜色*/
function adminAddCorol(){
	alert("添加颜色");
}

/*查询所有银行*/
function adminAllBank(){
	alert("查询所有银行");
}

/*添加银行*/
function adminAddBank(){
	alert("添加银行");
}

/*所有贷款申请*/
function adminAllLoans(){
	alert("所有贷款申请");
}

/*查询所有地区*/
function adminAllAddress(){
	alert("查询所有地区");
}

/*所有买家秀*/
function adminAllBuyerShow(){
	alert("所有买家秀");
}

/*交易记录*/
function adminAllTrancation(){
	alert("交易记录");
}




