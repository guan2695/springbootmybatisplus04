
    <!--单击页面跳转-->
    function tiao(showid,uid) {
        var tr="";
        var comm=$(".comment_xie textarea").val();
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
                        "<li>"+obj.comment+"</li>" +
                        "</ul>";
                }
                $(".comment_kan").append(tr);
            },
            error:function(){
                alert("响应失败！!");
            }
        });
    };

$(function () {
    //单击查看回复
   $(".commentreply").click(function () {
       var tt="";
       var commid=$(this).attr("name");           //得到评论id
       var louid=$(this).prev().attr("name");     //得到楼主id

       $(".comment_hui").find("button").attr({"name":commid});
       $(".comment_hui").find("input:eq(1)").attr({"name":louid});

       var commtnt= $(this).prev().html();  //获取楼主评论内容
       var title= $(this).parent().prev().find("span:eq(0)").html();  //获取楼主评论标题
       var date= $(this).parent().prev().find("span:eq(1)").html();  //获取楼主评论时间
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
   });

   //点击回复
   $(".issuereply").click(function () {
       var tt="";
       var commid=$(this).attr("name");           //得到评论id
       var louid=$(this).next().attr("name");       //搂住id
       var loginid=$(this).next().val();          //得到登录者id
       var comment=$(this).prev().val();
       alert("commid"+commid+"louid"+louid+"loginid"+loginid);
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

