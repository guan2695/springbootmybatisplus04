
    <!--单击页面跳转-->
    function tiao(showid,uid) {
        var tr="";
        var comm=$(".comment_xie textarea").val();
        alert("进入Ajax跳转"+comm);
        $.ajax({
            type:'post',
            url:'addComment',
            data:'showid='+showid+'&uid='+uid+'&comment01='+comm,
            cache:false,
            success:function(result){
                $(".comment_kan").html("");  //清空处理
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



