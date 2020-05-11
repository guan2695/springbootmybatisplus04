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
})
