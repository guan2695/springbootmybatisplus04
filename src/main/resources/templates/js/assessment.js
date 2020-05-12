//判断审核单选按钮是否通过，不通过显示原因
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
				$("#shenheState").attr("style","color: white;background: #23241F;display: inline-block;");
			}else{
				//通过不显示原因行
				$("#shenheState").attr("style","color: white;background: #23241F;display: none;");
			}
		} 
	}
}
