
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
	$("#bodyRight>#adminAddCorol").remove();
	//alert("查询所有用户");
	// location.href="/usedcar/adminIndex?pageIndex=1";
	$("#bodyRightH").html("所有用户");
	userFenye(1);
	userPageYemaAjax(1);
	// $("#userthisPage").html(1);
	// changeSelect(0);
}

/*返回车辆列表*/
function returnCarList() {
	location.href="/usedcar/adminIndex?pageIndex=1";
	// alert("aaa");
	// adminAllCar();
	// alert("bbb");
}

/*查询所有车辆信息*/
function adminAllCar(){
	$("#bodyRight>#adminAddCorol").remove();
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
					"      \t\t<td><button class=\"btn btn-primary btn-xs\" onclick=\"updcar("+c.imagesList[0].cid+")\">修改</button></td>\n";
				if(putstate=="是"){
					tr+="      \t\t<td><button class=\"btn btn-danger btn-xs\" onclick=\"delcar("+c.imagesList[0].cid+")\">下架</button></td>\n" +
						"      \t</tr>";
				}else{
					tr+="      \t\t<td><button class=\"btn btn-danger btn-xs\" onclick=\"upcar("+c.imagesList[0].cid+")\">上架</button></td>\n" +
						"      \t</tr>";
				}

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

/*查看一辆车详情*/
function carinfo(cid) {
	window.open("/usedcar/adminGetOneCar?cid="+cid);
	// location.href="/usedcar/adminGetOneCar?cid="+cid;
}

function selectOver(aid) {
	alert(aid);
	$.ajax({
		type:'post',
		url:"selectOver",
		data:'aid='+aid,
		success:function (result) {
			alert("不通过原因是"+result);
		},
		error:function () {
			alert("失败");

		}
	})
	

}
/*修改一辆车*/
function updcar(cid) {
	// window.open("/usedcar/adminUpdCarBefo?cid="+cid);
	location.href="/usedcar/adminUpdCarBefo?cid="+cid;
}

/*修改一辆车时，车牌变化车系变化*/
function updCarBrandListSel() {
	var bid=$("#updCarBrandList").val();
	//alert(bid);
	$.ajax({
			url:"/usedcar/adminByBrandCarSeries?bid="+bid,
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#updCarCarseriesList").html("");
				var tr="";
				for (var i=0;i<obj.length;i++){
					var cs=obj[i];
					tr+="<option value=\""+cs.csid+"\">"+cs.csname+"</option>";
				}
				$("#updCarCarseriesList").append(tr);
			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*车辆下架*/
function delcar(cid) {
	//alert(cid);
	$.ajax({
			url:"/usedcar/adminDelCar?cid="+cid,
			type:"post",
			dataType:"text",
			success:function (result) {
				// var obj=eval(result);
				if(result=="yes"){
					alert("下架成功");
					adminAllCar();
				}else {
					alert("下架失败");
				}
			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*车辆上架*/
function upcar(cid) {
	$.ajax({
		url:"/usedcar/adminUpCar?cid="+cid,
		type:"post",
		dataType:"text",
		success:function (result) {
			// var obj=eval(result);
			if(result=="yes"){
				alert("上架成功");
				adminAllCar();
			}else {
				alert("上架失败");
			}
		},
		error:function () {
			alert("响应失败");
		}
	})
}

/*查询所有审核申请*/
function adminAllAssessment(){
	$("#bodyRight>#adminAddCorol").remove();
	// alert("查询所有审核申请");
    $("#bodyRightH").html("卖车申请");
    $.ajax({
    		url:"/usedcar/adminGetAllAssess",
    		type:"post",
    		success:function (result) {
    			var obj=eval(result);
    			$("#adminRightTable").html("");
    			var tr="<tr>\n" +
                    "      \t\t<td>序号</td>\n" +
                    "      \t\t<td>用户</td>\n" +
                    "      \t\t<td>管理员</td>\n" +
                    "      \t\t<td>车id</td>\n" +
                    "      \t\t<td>审核状态</td>\n" +
                    "      \t</tr>";
    			for (var i=0;i<obj.length;i++){
                    var ass=obj[i];

                    tr+="<tr>\n" +
                        "      \t\t<td>"+ass.aid+"</td>\n" +
                        "      \t\t<td>"+ass.user.uname+"</td>\n" +
                        "      \t\t<td>"+ass.admin.adminname+"</td>\n" +
                        "      \t\t<td><a  onclick=\"carinfo("+ass.car.carinfo.cid+")\">"+ass.car.carinfo.cid+"</a></td>\n";
                    if(ass.assstate==0){
                        tr+="      \t\t<td><a  onclick=\"goAssessment("+ass.car.carinfo.cid+","+ass.aid+")\">去审核</a></td>\n" +
                        "      \t</tr>";
                    }else {
                        tr+="      \t\t<td><a>已审核</a></td>\n" +
                            "      \t</tr>";
                    }


    			}
                $("#adminRightTable").append(tr);
    			$("#BodyFenYeUl").html("");
    		},
    		error:function () {
    			alert("申请列表响应失败");
    		}
    	})
}

/*去审核方法*/
function goAssessment(cid,aid) {
    location.href="/usedcar/adminGoAssessment?cid="+cid+"&aid="+aid;
}

//判断审核单选按钮是否通过，不通过显示原因
//进行审核
function assessmentState(){
    //alert("aaa");
    var shenhe= document.getElementsByName("shenhe");
    //根据 name集合长度 遍历name集合
    for(var i=0;i<shenhe.length;i++)
    {
        //判断那个单选按钮为选中状态
        if(shenhe[i].checked)
        {
            //单选按钮的值
            var num=shenhe[i].value;
            if(num==0){
                //不通过显示原因行
                $("#shenheState").attr("style","display: inline-block;");
            }else{
                //通过不显示原因行
                $("#shenheState").attr("style","display: none;");
            }
        }
    }
}


/*查询所有品牌*/
function adminAllBrand(){
	$("#BodyFenYeUl").html("");
	$("#bodyRight>#adminAddCorol").remove();
	// alert("查询所有品牌");
	$("#bodyRightH").html("所有品牌");
	$.ajax({
			url:"/usedcar/adminGetAllBrand",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>品牌</td>\n" +
					"      \t\t<td>修改</td>\n" +
					"      \t\t<td>删除</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var b=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+b.bid+"</td>\n" +
						"      \t\t<td>\n" +
						"      \t\t\t<button onclick=\"brandCarseries("+b.bid+")\" type=\"button\" class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
						"      \t\t\t\t"+b.bname+"\n" +
						"\t\t\t\t\t\t</button></td>\n" +
						"<td>\n" +
						"\t\t\t\t\t\t\t<button onclick=\"adminUpdBrand('"+b.bname+"',"+b.bid+")\" type=\"button\" class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#adminUpdBrandMotai\">\n" +
						"      \t\t\t\t修改\n" +
						"\t\t\t\t\t\t</button>\n" +
						"\t\t\t\t\t\t</td>\n";
	                if(b.bid<=10){
						tr+="\t\t\t\t\t\t<td>\n"+
							"\t\t\t\t\t\t\t<button onclick=\"adminDelBrand("+b.bid+")\" disabled=\"disabled\" type=\"button\" class=\"btn btn-danger btn-xs\" data-toggle=\"modal\" data-target=\"\">\n" +
							"      \t\t\t\t删除\n" +
							"\t\t\t\t\t\t</button>\n" +
							"\t\t\t\t\t\t</td>" +
							"      \t</tr>";
					}else {
						tr+="\t\t\t\t\t\t<td>\n"+
							"\t\t\t\t\t\t\t<button onclick=\"adminDelBrand("+b.bid+")\" type=\"button\" class=\"btn btn-danger btn-xs\" data-toggle=\"modal\" data-target=\"\">\n" +
							"      \t\t\t\t删除\n" +
							"\t\t\t\t\t\t</button>\n" +
							"\t\t\t\t\t\t</td>" +
							"      \t</tr>";
					}

	    		}
				$("#adminRightTable").append(tr);
				$("#BodyFenYeUl").html("");
			},
			error:function () {
				alert("获取品牌响应失败");
			}
		})
}

/*根据车品牌得到车系，赋值给模态框*/
function brandCarseries(bid) {
	$.ajax({
			url:"/usedcar/adminGetCarseriesByBrand?bid="+bid,
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminCarSerciesMotal").html("");
				var tr="";
				for (var i=0;i<obj.length;i++){
	                var cs=obj[i];
					tr+="<li class=\"list-group-item\">"+cs.csname+"</li>";
	    		}
				$("#adminCarSerciesMotal").append(tr);
			},
			error:function () {
				alert("获取车系响应失败");
			}
		})
}

/*修改品牌*/
function adminUpdBrand(bname,bid) {
	$("#adminUpdBrandText").val(bname);
	$("#adminUpdBrandIdHidden").val(bid);
}

/*删除品牌*/
function adminDelBrand(bid) {
	if(confirm("确定要删除这个品牌吗？")){
		$.ajax({
				url:"/usedcar/adminDelBrand?bid="+bid,
				type:"post",
				dataType:"text",
				success:function (result) {
					if(result=="yes"){
						alert("删除成功");
					}else {
						alert("删除失败");
					}
					adminAllBrand();
					$("#leftUl:eq(3)>li>a").click();
				},
				error:function () {
					alert("删除响应失败");
				}
			})
	}
}

/*添加品牌*/
function adminAddBrand(){
	// alert("添加品牌");
	$("#bodyRightH").html("添加品牌");
	$("#adminRightTable").html("");
	$("#BodyFenYeUl").html("");
	$("#bodyRight>#adminAddCorol").remove();
	var tr="<div class=\"col-lg-12\" id=\"adminAddCorol\" style=\"margin-bottom: 50px;\">\n" +
		"\t\t\t\t\t<form method=\"post\"  class=\"form-inline\">\n" +
		"\t\t\t\t\t\t<div class=\"form-group\">\n" +
		"\t\t\t\t\t\t\t<div class=\"input-group\">\n" +
		"\t\t\t\t\t\t\t\t<div class=\"input-group-addon\">品牌名</div>\n" +
		"\t\t\t\t\t\t\t\t<input type=\"text\" name=\"adminAddBrandName\" class=\"form-control\" id=\"exampleInputAmount\" placeholder=\"Brand\">\n" +
		"\t\t\t\t\t\t\t</div>\n" +
		"\t\t\t\t\t\t</div>\n" +
		"\t\t\t\t\t\t<button type=\"button\" onclick=\"adminAddBrandFun()\" class=\"btn btn-primary\">添加</button>\n" +
		"\t\t\t\t\t</form>\n" +
		"\t\t\t\t</div>";
	$("#bodyRight").append(tr);
}

/*添加品牌异步刷新*/
function adminAddBrandFun() {
	var name=$("input[name='adminAddBrandName']").val();
	$.ajax({
			url:"/usedcar/adminAddBrand?name="+name,
			type:"post",
			dataType:"text",
			success:function (result) {
				if(result=="yes"){
					alert("添加成功");
				}else {
					alert("添加失败");
				}
				$("#leftUl>li:eq(3)>a").click();
				adminAllBrand();

			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*查询所有颜色*/
function adminAllCorol(){
	$("#BodyFenYeUl").html("");
	// alert("查询所有颜色");
	$("#bodyRightH").html("所有颜色");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetAllCorol",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>颜色</td>\n" +
					"      \t\t<td>删除</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var co=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+co.corolid+"</td>\n" +
						"      \t\t<td>"+co.corol+"</td>\n";

					if(co.corolid<=9){
						tr+="\t\t\t\t\t\t<td>\n"+
							"\t\t\t\t\t\t\t<button onclick=\"adminDelCorol("+co.corolid+")\" disabled=\"disabled\" type=\"button\" class=\"btn btn-danger btn-xs\" >\n" +
							"      \t\t\t\t删除\n" +
							"\t\t\t\t\t\t</button>\n" +
							"\t\t\t\t\t\t</td>" +
							"      \t</tr>";
					}else {
						tr+="\t\t\t\t\t\t<td>\n"+
							"\t\t\t\t\t\t\t<button onclick=\"adminDelCorol("+co.corolid+")\" type=\"button\" class=\"btn btn-danger btn-xs\" >\n" +
							"      \t\t\t\t删除\n" +
							"\t\t\t\t\t\t</button>\n" +
							"\t\t\t\t\t\t</td>" +
							"      \t</tr>";
					}
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("所有颜色响应失败");
			}
		})
}

/*删除颜色异步刷新*/
function adminDelCorol(corolid) {
	if(confirm("确定要删除这个颜色吗？")){
	$.ajax({
			url:"/usedcar/adminDelCorol?corolid="+corolid,
			type:"post",
			dataType:"text",
			success:function (result) {
				if(result=="yes"){
					alert("删除颜色成功");
				}else{
					alert("删除颜色失败");
				}
				adminAllCorol();
			},
			error:function () {
				alert("删除颜色响应失败");
			}
		})
	}
}

/*添加颜色*/
function adminAddCorol(){
	$("#bodyRightH").html("添加颜色");
	$("#adminRightTable").html("");
	$("#BodyFenYeUl").html("");
	$("#bodyRight>#adminAddCorol").remove();
	var tr="<div class=\"col-lg-12\" id=\"adminAddCorol\" style=\"margin-bottom: 50px;\">\n" +
		"\t\t\t\t\t<form method=\"post\" class=\"form-inline\">\n" +
		"\t\t\t\t\t\t<div class=\"form-group\">\n" +
		"\t\t\t\t\t\t\t<div class=\"input-group\">\n" +
		"\t\t\t\t\t\t\t\t<div class=\"input-group-addon\">颜色名</div>\n" +
		"\t\t\t\t\t\t\t\t<input type=\"text\" name=\"adminAddCorolName\" class=\"form-control\" id=\"exampleInputAmount\" placeholder=\"Corol\">\n" +
		"\t\t\t\t\t\t\t</div>\n" +
		"\t\t\t\t\t\t</div>\n" +
		"\t\t\t\t\t\t<button type=\"button\" onclick=\"adminAddCorolFun()\" class=\"btn btn-primary\">添加</button>\n" +
		"\t\t\t\t\t</form>\n" +
		"\t\t\t\t</div>";
	$("#bodyRight").append(tr);
}
/*添加颜色异步刷新*/
function adminAddCorolFun() {
	var name=$("input[name='adminAddCorolName']").val();
	$.ajax({
			url:"/usedcar/adminAddCorol?name="+name,
			type:"post",
			dataType:"text",
			success:function (result) {
				if(result=="yes"){
					alert("添加成功");
				}else {
					alert("添加失败");
				}
				$("#leftUl>li:eq(5)>a").click();
				adminAllCorol();
			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*查询所有银行*/
function adminAllBank(){
	// alert("查询所有银行");
	$("#BodyFenYeUl").html("");
	$("#bodyRightH").html("所有银行");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetAllBank",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>银行名称</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var b=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+b.bankid+"</td>\n" +
						"      \t\t<td>"+b.bankname+"</td>\n" +
						"      \t</tr>";
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("所有银行响应失败");
			}
		})
}

/*所有贷款申请*/
function adminAllLoans(){
	// alert("所有贷款申请");
	$("#BodyFenYeUl").html("");
	$("#bodyRightH").html("所有贷款申请");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetAllLoans",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>用户姓名</td>\n" +
					"      \t\t<td>手机号码</td>\n" +
					"      \t\t<td>贷款金额(万元)</td>\n" +
					"      \t\t<td>是否有房</td>\n" +
					"      \t\t<td>贷款银行</td>\n" +
					"      \t\t<td>贷款状态</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var l=obj[i];
	                var housestate="是";
	                if(l.ishavehouse==0){
						housestate="否";
					}
	                tr+="<tr>\n" +
						"      \t\t<td>"+l.lid+"</td>\n" +
						"      \t\t<td>"+l.user.uname+"</td>\n" +
						"      \t\t<td>"+l.idcard+"</td>\n" +
						"      \t\t<td>"+l.lmoney+"</td>\n" +
						"      \t\t<td>"+housestate+"</td>\n" +
						"      \t\t<td>"+l.banks.bankname+"</td>\n";
	                if(l.lstate==0){
	                	tr+="      \t\t<td><button type=\"button\" onclick=\"adminGoShenheLoans("+l.lid+","+l.lmoney+","+l.user.uid+")\" class=\"btn btn-warning btn-xs\" data-toggle=\"modal\" data-target=\"#loansMotai\">\n" +
							"\t\t\t\t\t\t\t 去审核\n";
					}else if(l.lstate==1){
						tr+="      \t\t<td><button type=\"button\" class=\"btn btn-danger btn-xs\" data-toggle=\"modal\" data-target=\"\">\n" +
							"\t\t\t\t\t\t\t 贷款失败\n";
					}else{
						tr+="      \t\t<td><button type=\"button\" class=\"btn btn-success btn-xs\" data-toggle=\"modal\" data-target=\"\">\n" +
							"\t\t\t\t\t\t\t 贷款成功\n";
					}
	                tr+="\t\t\t\t\t\t\t</button>\n" +
						"      \t\t</td>\n" +
						"      \t</tr>";
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*管理员去审核模态框*/
function adminGoShenheLoans(lid,money,uid) {
	// alert(lid);
	$("input[name='LoansTestId']").val(lid);
	$("input[name='LoansTestMoney']").val(money);
	$("input[name='LoansTestUserid']").val(uid);
}
//贷款审核是否通过下拉列表改变方法
function shenheTong(){
	var num=$("#shenheName").val();
	//alert(num);
	if(num==1){
		$("#shibai").attr("style","display:block");
	}else{
		$("#shibai").attr("style","display:none");
	}
}


/*管理员审核*/
function adminShenheLoansBtn() {
	var lid=$("input[name='LoansTestId']").val();
	var state=$("#shenheName").val();
	var baca=$("#butongguoBecause").val();
	var money=$("input[name='LoansTestMoney']").val();
	var uid=$("input[name='LoansTestUserid']").val();
	$.ajax({
			url:"/usedcar/adminGoLoans?lid="+lid+"&lstate="+state+"&lmsgbecause="+baca+"&lmoney="+money+"&uid="+uid,
			type:"post",
			dataType:"text",
			success:function (result) {
				if(result=="yes"){
					alert("贷款审核成功，结果结果是：成功");
				}else{
					alert("贷款审核成功，结果结果是：失败");
				}
				$("#loansMotai").modal('hide');
				adminAllLoans();
			},
			error:function () {
				alert("审核响应失败");
			}
		})

}

/*查询所有地区*/
function adminAllAddress(){
	// alert("查询所有地区");
	$("#BodyFenYeUl").html("");
	$("#bodyRightH").html("地区列表");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetAllAddress",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>地区名称</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var a=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+a.addid+"</td>\n" +
						"      \t\t<td>"+a.address+"</td>\n" +
						"      \t</tr>";
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("所有地区响应失败");
			}
		})

}

/*所有买家秀*/
function adminAllBuyerShow(){
	// alert("所有买家秀");
	$("#BodyFenYeUl").html("");
	$("#bodyRightH").html("买家秀");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetBuyerShow",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>用户</td>\n" +
					"      \t\t<td>所购车</td>\n" +
					"      \t\t<td>标题</td>\n" +
					"      \t\t<td>发布时间</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var show=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+show.showid+"</td>\n" +
						"      \t\t<td>"+show.user.uname+"</td>\n" +
						"      \t\t<td><a onclick=\"carinfo("+show.car.carinfo.cid+")\">"+show.car.brand.bname+""+show.car.cardseries.csname+""+show.car.carinfo.cid+"</a></td>\n" +
						"      \t\t<td><a onclick=\"adminBuyerShowInfo("+show.showid+")\">"+show.title+"</a></td>\n" +
						"      \t\t<td>"+show.showtime+"</td>\n" +
						"      \t</tr>";
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("买家秀响应失败");
			}
		})
}

/*管理员查看买家秀详情*/
function adminBuyerShowInfo(showid) {
	// alert(showid);
	window.open("/usedcar/adminGetOneBuyerShow?showid="+showid);
}

/*交易记录*/
function adminAllTrancation(){
	// alert("交易记录");
	$("#BodyFenYeUl").html("");
	$("#bodyRightH").html("交易记录");
	$("#bodyRight>#adminAddCorol").remove();
	$.ajax({
			url:"/usedcar/adminGetAllTransation",
			type:"post",
			success:function (result) {
				var obj=eval(result);
				$("#adminRightTable").html("");
				var tr="<tr>\n" +
					"      \t\t<td>序号</td>\n" +
					"      \t\t<td>车辆</td>\n" +
					"      \t\t<td>买家</td>\n" +
					"      \t\t<td>卖家</td>\n" +
					"      \t\t<td>交易金额(万元)</td>\n" +
					"      \t\t<td>交易时间</td>\n" +
					"      \t</tr>";
				for (var i=0;i<obj.length;i++){
	                var t=obj[i];
	                tr+="<tr>\n" +
						"      \t\t<td>"+t.tid+"</td>\n" +
						"      \t\t<td><a onclick=\"carinfo("+t.car.carinfo.cid+")\">"+t.car.carinfo.cid+"</a></td>\n" +
						"      \t\t<td>"+t.buyuser.uname+"</td>\n" +
						"      \t\t<td>"+t.selluser.uname+"</td>\n" +
						"      \t\t<td>"+t.tmoney+"</td>\n" +
						"      \t\t<td>"+t.tdate+"</td>\n" +
						"      \t</tr>";
	    		}
				$("#adminRightTable").append(tr);
			},
			error:function () {
				alert("响应失败");
			}
		})
}

/*图片验证码单击刷新*/
function changeCodeImg(){
	var num=Math.ceil(Math.random()*100);//生成一个随机数（防止缓存）
	var src = $("#vimg").attr("src");
	alert(src + "?num=" + num);
	$("#vimg").attr('src',src + "?num=" + num);
}



