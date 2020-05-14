<!--单击页面跳转-->
$(function () {

    $("#middle").on("click","dl",function(){
        var showid=$(this).attr("name");
        alert(showid);
        location.href = "carsundetail.html";
    });

}); //窗体

function tiao(urc) {
    location.href = urc;
}

//多条件分页
function carsunpage(math) {
    var tr="";
    var index=0;
    var firstxs=$(".pagei").find("i:eq(0)").html();
    var count=$(".pagei").find("i:eq(1)").html();
    if(math==1){
        index=1;
    }
    if(math==2){
        if(firstxs<=1){
            index=1;
        }else{
            index=firstxs-1;
        }
    }
    if(math==3){
        if(firstxs>=count){
            index=count;
        }else{
            index=parseInt(firstxs)+1;
        }
    }
    if(math==4){
        index=count;
    }
    $.ajax({
        type:'post',
        url:'jlpageindex2',
        data:'first3='+index,
        cache:false,
        success:function(result){
            var ar=result.split("~","3");
            var first=ar[0];
            var count2=ar[1];
            $(".pagei").find("i:eq(0)").html(first);
            $(".pagei").find("i:eq(1)").html(count2);
            //result=$.parseJSON(ar[2])
            result=eval(ar[2]);
            $("#middle").html("");  //清空处理
            for(var i=0;i<result.length;i++){
                var obj=result[i];
                var img="images/"+obj.img;           //获取图片路径
                var name=obj.user.uname;            //获取买家秀名字
                tr+="<dl name='"+obj.showid+"'>" +
                    "<dt><img src='"+img+"' /> <span>"+obj.title+"</span></dt>" +
                    "<dd><span>时间：</span><span>"+obj.showtime+"</span></dd>" +
                    "<dd><span>"+name+"</span> <span>务工</span></dd>" +
                    "</dl> ";
            }
            $("#middle").append(tr);
        },
        error:function(){
            alert("响应失败！!");
        }
    });
}