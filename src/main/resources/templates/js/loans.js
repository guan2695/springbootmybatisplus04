//贷款审核

//审核是否通过下拉列表改变方法
function shenheTong(){
	var num=$("#shenheName").val();
	//alert(num);
	
	if(num==1){
		$("#shibai").attr("style","display:block");
	}else{
		$("#shibai").attr("style","display:none");
	}
}
