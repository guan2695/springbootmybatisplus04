/*管理员登录*/
function adminLogin() {
    var adminname=$("#adminname").val();
    var adminpwd=$("#adminpwd").val();
    //alert("用户名："+adminname+"密码："+adminpwd);

    if(adminname=="" || adminpwd==""){
        alert("用户名或密码不能为空");
    }else{
        $.ajax({
            url:"/usedcar/adminlogin?adminname="+adminname+"&adminpwd="+adminpwd,
            type:"post",
            dataType:"text",
            success:function (result) {
                if(result=="error"){
                    alert("用户名或密码错误");
                }else {
                    location.href="/usedcar/adminIndex?pageIndex=1";
                }
            },
            error:function () {
                alert("响应失败");
            }
        })
    }
}