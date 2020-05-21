
    <!--单击页面跳转-->
    function tiao(showid,uid) {
        var tr="";
        var comm=$(".comment_xie textarea").val();
        if (comm == "") {
            alert("评论内容不能为空！");
            return;
        }
        $.ajax({
            type:'post',
            url:'addComment',
            data:'showid='+showid+'&uid='+uid+'&comment01='+comm,
            cache:false,
            success:function(result){
                $(".comment_kan").html("");  //清空处理
                $(".comment_xie textarea").val("");

                for(var i=0;i<result.length;i++){
                    var obj=result[i];
                    tr+="<ul>" +
                        "<li><span>"+obj.user.uname+"</span> <span>"+obj.cdate+"</span></li>" +
                        "<li><span name='"+obj.user.uid+"'>"+obj.comment+"</span> <span class='commentreply' onclick='replyhui(this)' name='"+obj.commid+"' data-toggle='modal' data-target='#myModal'>查看回复</span></li>" +
                        "</ul>";
                }
                $(".comment_kan").append(tr);
            },
            error:function(){
                alert("响应失败！!");
            }
        });
    };

    //单击查看回复
    function replyhui(this01){
        var tt="";
        var commid=$(this01).attr("name");           //得到评论id
        //alert("评论id"+commid);
        var louid=$(this01).prev().attr("name");     //得到楼主id
        var louname=$(this01).parent().prev().find("span:eq(0)").html();  //得到楼主名字
        //alert("楼主名字："+louname);

        $(".comment_hui").find("input:eq(0)").attr({"placeholder":"回复："+louname});
        $(".comment_hui").find("button").attr({"name":commid});
        $(".comment_hui").find("input:eq(1)").attr({"name":louid});

        var commtnt= $(this01).prev().html();  //获取楼主评论内容
        var title= $(this01).parent().prev().find("span:eq(0)").html();  //获取楼主评论标题
        var date= $(this01).parent().prev().find("span:eq(1)").html();  //获取楼主评论时间
        //楼主赋值
        $(".modal_zhu").find("li:eq(0)").find("span:eq(0)").html(title);
        $(".modal_zhu").find("li:eq(0)").find("span:eq(1)").html(date);
        $(".modal_zhu").find("li:eq(1)").find("span:eq(0)").html(commtnt);

        //模态框异步
        $.ajax({
            type:'post',
            url:'getallreply',
            data:'commid='+commid,
            cache:false,
            success:function(result){
                $(".modal_nei").html("");  //清空处理
                for(var i=0;i<result.length;i++) {
                    var obj = result[i];
                    var replyid = obj.replyid; //得到回复对象的id
                    if (replyid == louid) {
                        tt += "<ul>" +
                            "<li><span>" + obj.user.uname + "</span> <span>" + obj.redate + "</span></li>" +
                            "<li>" + obj.comment + "</li>" +
                            "</ul>";
                    }else{
                        tt += "<ul>" +
                            "<li><span>" + obj.user.uname + "</span>回复"+replyid+" <span>" + obj.redate + "</span></li>" +
                            "<li>" + obj.comment + "</li>" +
                            "</ul>";
                    }
                }
                $(".modal_nei").append(tt);
            },
            error:function(){
                alert("响应失败！!");
            }
        });
    }

$(function () {
   //点击回复
   $(".issuereply").click(function () {
       var tt="";
       var commid=$(this).attr("name");           //得到评论id
       var louid=$(this).next().attr("name");       //搂住id
       var loginid=$(this).next().val();          //得到登录者id
       var comment=$(this).prev().val();
       if(loginid==louid){
           alert("不能回复自己的评论！");
           $(".comment_hui").find("input:eq(0)").val("");
           return;
       }
       if(comment==""){
           alert("回复评论没有内容！！");
           $(".comment_hui").find("input:eq(0)").val("");
           return;
       }
       //alert("commid"+commid+"louid"+louid+"loginid"+loginid);
       //模态框异步
       $.ajax({
           type:'post',
           url:'addreply',
           data:'commid='+commid+'&uid='+loginid+'&replyid='+louid+'&comment='+comment,
           cache:false,
           success:function(result){
               $(".modal_nei").html("");  //清空处理
               $(".issuereply").prev().val("");
               for(var i=0;i<result.length;i++) {
                   var obj = result[i];
                   var replyid = obj.replyid; //得到回复对象的id
                   if (replyid == louid) {
                       tt += "<ul>" +
                           "<li><span>" + obj.user.uname + "</span> <span>" + obj.redate + "</span></li>" +
                           "<li>" + obj.comment + "</li>" +
                           "</ul>";
                   }else{
                       tt += "<ul>" +
                           "<li><span>" + obj.user.uname + "</span>回复"+replyid+" <span>" + obj.redate + "</span></li>" +
                           "<li>" + obj.comment + "</li>" +
                           "</ul>";
                   }
               }
               $(".modal_nei").append(tt);
           },
           error:function(){
               alert("响应失败！!");
           }
       });

   });

});  //窗体

