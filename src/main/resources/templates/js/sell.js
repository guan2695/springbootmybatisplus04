/*$(document).ready(function(){
   $(".but").click(function(){
        //图片
        var imgs = $(".imgContainer").find("img");
        for(var i=0;i<imgs.length;i++){
            var dish=$(imgs[i]).attr('title');
        }
        $.ajax({
            type:"post",
            url:"usedcar/imagesall",
            data:{"dish":dish},
            dataType:"josn",
           success:function(){

           },error:function () {
               alert("选择错误！！")
            }
        });

        })

    });*/
$(function () {
    /*
    * 取地区品牌车系*/
    var csid = "";
    $(".ul02 li:eq(2) span").click(function () {
        csid = $(this).attr("value");

    });
    $(".ul02 li:eq(3) span").click(function () {
        csid = $(this).attr("value");

    });
    $(".ul02 li:eq(4) span").click(function () {
        csid = $(this).attr("value");

    })
    $(".ul02 li:eq(5) span").click(function () {
        csid = $(this).attr("value");

    })


    $(".but").click(function () {
        var uid = 11;
        var img = $(".imgContainer").find("img");
        var image = $(img).attr('title');
        var price = $("input[name='price']").val();
        var oprice = $("input[name='oprice']").val();
        var carage = $("input[name='carage']").val();
        var color = $("select[name='cars1']").val();
        var addressid = $(".li01 ul li:eq(0) .mo").attr("value");
        var bid = $(".ul02 li:eq(1) .mo").attr("value");
        var pailiang = $("input[name='dis']").val();
        var youtype = $(".qiyou").html();
        var youname= $("input[name='gr']").val();
        var dangtype = $("select[name='cars2']").html();
        var length= $("input[name='le']").val();
        var width= $("input[name='wi']").val();
        var height= $("input[name='he']").val();
        var mass= $("input[name='qu']").val();
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
                                                                alert("uid="+uid+"csid="+csid+"bid="+bid+"color="+color+"addressid="+addressid+
                                                                    "image="+image+"oprice="+oprice+"price="+price+"carage="+carage+"pailiang="+
                                                                    pailiang+"youtype="+youtype+"youname="+youname+"dangtype="+dangtype+"length"+
                                                                    length+"width"+width+"height"+height+"mass"+mass);
                                                                $.ajax({
                                                                    url: "/usedcar/carall",
                                                                    type: "post",
                                                                    data:
                                                                        {"uid":uid,"csid":csid,"bid":bid,"corolid":color,"addressid":addressid,
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
                                                                    },error:function () {
                                                                        alert("错误！！")
                                                                    }
                                                                });
                                                                var imgs = $(".imgContainer").find("img");
                                                                for(var i=0;i<imgs.length;i++){
                                                                    var src=$(imgs[i]).attr('title');
                                                                    if (i==0){
                                                                        continue;
                                                                    }
                                                                    alert(src);

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
                                                                        },error:function () {
                                                                            alert("错误！！")
                                                                        }
                                                                    });
                                                                }
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








    })
})


            /*});*/
   /* });*/

