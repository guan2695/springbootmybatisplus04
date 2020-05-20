$(function () {
    $("#phone2").blur(function(){
        var reg = /^1[3|4|5|7|8][0-9]{9}$/;
        if (reg.test($("#phone2").val())){
        }else{
            alert("请输入正确手机号");
        }

    })
})


function regcheck() {


    var phone =$("input[id=phone2]").val();
    var uname =$("input[name=uname]").val();
    var upwd =$("input[id=upwd2]").val();
    var verify=$("input[name='verify']").val();
    //alert("手机号"+phone+uname+upwd);
    //alert("密码"+upwd);
    //alert(verify);
    $.ajax({
        type: 'post',
        url: 'Userphone',
        data:'phone='+phone,
        dataType:'text',
        success:function (result) {
            $("input[name=phone1]").val(result);
            //alert(result);
            if (result=="yes") {
                alert("该手机号已存在,请勿重复注册");
                // $("#form2").attr("action","index");
                // location.href="/usedcar/index";
                // return false;
            }else{
                //alert("注册成功");
                //$("#form2").attr("action","register");
                // location.href="/usedcar/register?phone="+phone+"&uname="+uname+"&upwd="+upwd+"&verify="+verify;
                $.ajax({
                    type:"post",
                    url:"/usedcar/register?phone="+phone+"&uname="+uname+"&upwd="+upwd+"&verify="+verify,
                    dataType:"text",
                    success:function (result) {
                        //alert(result);
                        if(result=="error"){
                            alert("验证码错误");
                        }else {
                            alert("注册成功");
                            location.href="/usedcar/index";
                        }
                    },
                    error:function () {
                        alert("响应失败");
                    }
                });

            }
        },
        error:function() {
            alert("失败");
        }
    })
    // return false;


};

/*图片验证码单击刷新*/
function changeCodeImg(){
    var num=Math.ceil(Math.random()*100);//生成一个随机数（防止缓存）
    var src = $("#vimg").attr("src");
    // alert(src + "?num=" + num);
    $("#vimg").attr('src',src + "?num=" + num);
};


function qingkong(uid) {
    alert("清空");
    $.ajax({
        type: 'post',
        url: 'deleteHistory',
        data: 'uid='+uid,
        success: function (obj) {
            var num = eval(obj);
            if (num > 0) {
                $(".historyuid").html("");
                alert("成功");

            } else {
                $(".historyuid").html("");
            }


        },
        error: function () {
            alert("失败");
        }
    })
};