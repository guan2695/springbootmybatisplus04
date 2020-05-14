function isShow4(tab2_id,div2_id,t_Style,ss)    //
{
   for(var i = 0;i < 5;i++)
   {
   document.getElementById("divs2_"+i).style.display="none";
   document.getElementById("tabs2_"+i).className="li";
   }
   document.getElementById(div2_id).style.display=t_Style;
   document.getElementById(tab2_id).className="hover";
   document.getElementById('11').innerHTML=ss;
}

$(function () {
   var lists= document.getElementsByClassName("shangpai");

   var date=new Date();
   var year=date.getFullYear();//当前年份
   for (var i=0;i<lists.length;i++){
      lists[i].innerHTML=(year-lists[i].innerHTML)+"年上牌";
   }

   //异步刷新判断用户是否登录成功
   $("#pingpai").click(function(){
      var bid=$("input[name=bid]").val();
      var csid=$("input[name=csid]").val();
      alert(bid);
      alert(csid);
      var li1="";
      $.ajax({
         type : 'post',
         url  : 'listhtml3',
         data : 'bid='+bid+'&csid='+csid,
         success : function(obj) {
            var list = eval(obj);
            alert("成功");
            $("#addcar1").html("");
            for(i=0;i<list.length;i++ ){
               var l=list[i];
              li1+=tr+="<li>" +
                  "<div class='list-infoBox'>" +
                  "<a target='_parent' href='#'><img src='"+img+"' width='290' height='194' /></a>" +
                  "<p class='infoBox'></p>" +
                  "</div>" +
                  "<li>";
            }
            $("#addcar1").append(li1);
         },
         error:function () {
            alert("失败");
            }
      })
   });
  function qingkong(uid){
     alert("清空");
     $.ajax({
        type : 'post',
        url  : 'deleteHistory',
        data : 'uid='+uid,
        success : function(obj) {
           var num = eval(obj);
         if(num>0){
            alert("成功");
            $("#history").html("");
         }else{
            alert("清空失败");
         }


        },
        error : function () {
           alert("失败");
        }
     })
  }


})
