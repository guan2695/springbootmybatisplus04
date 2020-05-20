
var csid="";
function csids(obj) {
    $(obj).addClass("mo");
    $(obj).siblings().removeClass("mo");
    csid= $(obj).attr("value");
}

$(function () {

    var bid = $(".ul02 li:eq(1) .mo1").attr("value");

  var num="";
    $.ajax({
        url:'/usedcar/selllogin02',
        post:'json',
        data:'bid='+bid,
        cache:false,
        success:function (result) {
            $(".ul02 li:eq(2)").html("");
            for (var i=0;i<result.length;i++) {
                var obj=result[i];
                num+="<span onclick='csids(this)' value='"+obj.bid+"'>"+obj.csname+"</span>";
            }
            var car="车系：";
            $(".ul02 li:eq(2)").append(car);
            $(".ul02 li:eq(2)").append(num);
        },error:function () {

        }
    })
    /*
    * 取车系集合单击切换
    * */
   $(".mo1").click(function () {
       var bid = $(this).attr("value");
        //var bid=$(this).val();

        var num="";
       $.ajax({
           url:'/usedcar/selllogin02',
           post:'json',
           data:'bid='+bid,
           cache:false,
           success:function (result) {
               $(".ul02 li:eq(2)").html("");
               for (var i=0;i<result.length;i++) {
                   var obj=result[i];
                   num+="<span onclick='csids(this)' value='"+obj.bid+"'>"+obj.csname+"</span>";
               }
               var car="车系：";
               $(".ul02 li:eq(2)").append(car);
               $(".ul02 li:eq(2)").append(num);
           },error:function () {
               alert("响应失败");
           }
       })
        
        
    })

    
    $(".but").click(function () {
        var uname = $(".uname").html();
        var img = $(".imgContainer").find("img");
        var image = $(img).attr('title');
        var price = $("input[name='price']").val();
        var oprice = $("input[name='oprice']").val();
        var carage = $("input[name='carage']").val();
        var color = $("select[name='cars1']").val();
        var addressid = $(".li01 ul li:eq(0) .mo").attr("value");
        var bid = $(".ul02 li:eq(1) .mo1").attr("value");
        var pailiang = $("input[name='dis']").val();
        var youtype = $(".qiyou").html();
        var youname= $("input[name='gr']").val();
        var dangtype = $("select[name='cars2']").val();
        var length= $("input[name='le']").val();
        var width= $("input[name='wi']").val();
        var height= $("input[name='he']").val();
        var mass= $("input[name='qu']").val();
        if(uname!=""){
            if(image != null){
                if (addressid!=null) {
                    if (bid != null){
                        if(csid != ""){
                            if(oprice != ""){
                                if(price!=""){
                                    if (carage != ""){
                                        if(pailiang != ""){
                                            if (youname != ""){
                                                if(dangtype != ""){
                                                    if (length != ""){
                                                        if (width != ""){
                                                            if (height != ""){
                                                                if (mass != ""){

                                                                    $.ajax({
                                                                        url: "/usedcar/carall",
                                                                        type: "post",
                                                                        data:
                                                                            {"uname":uname,"csid":csid,"bid":bid,"corolid":color,"addressid":addressid,
                                                                                "img":image,"oprice":oprice,"price":price,"carage":carage,
                                                                                "pailiang":pailiang,"youtype":youtype,"youname":youname,"dangtype":dangtype
                                                                                ,"length":length,"width":width,"height":height,"mass":mass},
                                                                        dataType:"json",
                                                                        success: function (result) {
                                                                            if(result=="yes"){
                                                                                alert("添加成功");
                                                                            }else{
                                                                                alert("添加失败");
                                                                            }
                                                                        }
                                                                    });
                                                                    var imgs = $(".imgContainer").find("img");
                                                                    for(var i=0;i<imgs.length;i++){
                                                                        var src=$(imgs[i]).attr('title');
                                                                        if (i==0){
                                                                            continue;
                                                                        }
                                                                        $.ajax({
                                                                            url: "/usedcar/imagesall",
                                                                            type: "post",
                                                                            data:
                                                                                {"src":src},
                                                                            dataType:"json",
                                                                            success: function (result) {
                                                                                if(result=="yes"){
                                                                                    alert("添加成功");
                                                                                }else{
                                                                                    alert("添加失败");
                                                                                }
                                                                            }
                                                                        });
                                                                    }
                                                                    alert("添加成功！！")
                                                                } else {
                                                                    alert("请输入质量！")
                                                                }
                                                            } else {
                                                                alert("请输入高度！")
                                                            }
                                                        } else {
                                                            alert("请输入宽度！")
                                                        }
                                                    } else {
                                                        alert("请输入长度！")
                                                    }

                                                }else {
                                                    alert("请输入制动类型！")
                                                }
                                            } else {
                                                alert("请输入燃油标号！")
                                            }
                                        }else {
                                            alert("请输入排量！")
                                        }






                                    } else {
                                        alert("请输入车龄！")
                                    }
                                }else {
                                    alert("请输入现价！")
                                }
                            }else {
                                alert("请输入原价！")
                            }
                        }else {
                            alert("请选择车系！")
                        }
                    } else {
                        alert("请选择车辆品牌！")
                    }
                }else {
                    alert("请选择地区！")
                }
            }else {
                alert("请选择图片！")
            }

        }else {
            alert("请先登录！")
        }








    })
})
