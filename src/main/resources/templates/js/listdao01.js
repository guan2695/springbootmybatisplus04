var bname=0,csname=0,price=0,carage=0,corol=0,address=0,pnum=0;
$(function () {
    //导航栏搜索单击selecter
    $(".fliter-bd").on("click",".fliter-bd a",function(){

        $(this).parent().find("a").css({"background-color":"#f9f9f9","color":"#666"});  //清理样式
        $(this).parent().find("a[name=aa]").attr({"class":"xz"});     //清理class

        $(this).css({"background-color":"#00002e","color":"#fff","text-decoration":"none"});       //添加样式
        $(this).attr({"class":"xzz"});     //添加class

        //得到数据
        getdate();

        //异步跳转
        var tr="";
        $.ajax({
            type:'post',
            url:'listhtml4',
            data:'bid='+bname+'&csid='+csname+'&price='+price+'&carage='+carage+'&colorid='+corol+'&addid='+address,
            cache:false,
            success:function(result){
                $("#addcar1").html("");  //清空处理
                for(var i=0;i<result.length;i++){
                   var obj=result[i];
                   var img="images/"+obj.img;           //获取图片路径
                   var bname=obj.brand.bname;           //获取车品牌
                   var csname=obj.cardseries.csname;    //获取车系
                   var cid=obj.cid;                     //获取车id
                   var carage=obj.carage;               //获取车龄
                   tr+="<li>" +
                       "<div class='list-infoBox'>" +
                       "<a target='_parent' href='#'><img src='"+img+"' width='290' height='194' /></a>" +
                       "<p class='infoBox'><a target='_blank' class='info-title'></a>"+bname+"-"+csname+""+cid +" 车龄"+carage+"年 </p>" +
                       "<p class='fc-gray'><span class='tag-gray'>"+obj.address.address+"</span> <span class=''>车龄"+carage+"年</span> <em class='shuxian'>|</em> 颜色:"+obj.corol.corol+"</p>" +
                       "<p class='priType-s'><span> <i class='fc-org priType'>"+obj.price+"万 </i> </span> <s>"+obj.oprice+"万</s> </p> " +
                       "</div>" +
                       "</li>";
                }
                $("#addcar1").append(tr);
            },
            error:function(){
                alert("响应失败！!");
            }
        });

        //异步跳转《遍历车系集合》
        var tt="<a  class='on' title='c-0'>不限</a>";
        $.ajax({
            type:'post',
            url:'jiangcardseries',
            data:'bid='+bname,
            cache:false,
            success:function(result){
                $(".mycardseries").html("");  //清空处理
                for(var i=0;i<result.length;i++){
                    var obj=result[i];
                    var caname2=obj.csid;
                    if(caname2==csname){
                        tt+="<a style='background-color:#00002e;color:#fff;text-decoration:none;'  class='xzz' name='aa' title='c-"+obj.csid+"'>"+obj.csname+" </a>";
                    }else{
                        tt+="<a  class='xz' name='aa' title='c-"+obj.csid+"'>"+obj.csname+" </a>";
                    }
                }
                $(".mycardseries").append(tt);
                if(csname!=0){
                    $(".mycardseries").find("a:eq(0)").attr({"class":"xz"});  //清理车系样式
                }

            },
            error:function(){
                alert("响应失败！!");
            }
        });
    });

    //下拉搜索单击
    $(".selecter li a").click(function(){
        var mb=$(this).html();
        alert(mb);
        if(mb=="不限"){
            return;
        }
        $(this).parent().parent().find("a[name=aa]").attr({"class":"xz"});     //清理class
        $(this).attr({"class":"xzz"});
        //添加class
        //得到数据
        getdate();

        //异步跳转《遍历车子集合》
        var tr="";
        $.ajax({
            type:'post',
            url:'listhtml4',
            data:'bid='+bname+'&csid='+csname+'&price='+price+'&carage='+carage+'&colorid='+corol+'&addid='+address,
            cache:false,
            success:function(result){
                $("#addcar1").html("");  //清空处理
                for(var i=0;i<result.length;i++){
                    var obj=result[i];
                    var img="images/"+obj.img;           //获取图片路径
                    var bname=obj.brand.bname;           //获取车品牌
                    var csname=obj.cardseries.csname;    //获取车系
                    var cid=obj.cid;                     //获取车id
                    var carage=obj.carage;               //获取车龄
                    tr+="<li>" +
                        "<div class='list-infoBox'>" +
                        "<a target='_parent' href='#'><img src='"+img+"' width='290' height='194' /></a>" +
                        "<p class='infoBox'><a target='_blank' class='info-title'></a>"+bname+"-"+csname+""+cid +" 车龄"+carage+"年 </p>" +
                        "<p class='fc-gray'><span class='tag-gray'>"+obj.address.address+"</span> <span class=''>车龄"+carage+"年</span> <em class='shuxian'>|</em> 颜色:"+obj.corol.corol+"</p>" +
                        "<p class='priType-s'><span> <i class='fc-org priType'>"+obj.price+"万 </i> </span> <s>"+obj.oprice+"万</s> </p> " +
                        "</div>" +
                        "</li>";
                }
                $("#addcar1").append(tr);
            },
            error:function(){
                alert("响应失败！!");
            }
        });

    });

    //得到数据	函数
    function getdate(){
        var ass=window.document.getElementsByClassName("xzz");
        for(var i=0;i < ass.length;i++){
            var ar=ass[i].title.split("-","2");
            var zi=ar[0];
            var ziid=ar[1];
            if(zi=="p"){
                bname=ziid;
                pnum++;
            }
            if(zi=="c"){
                csname=ziid;
            }
            if(zi=="j"){
                price=ziid;
            }
            if(zi=="s"){
                carage=ziid;
            }
            if(zi=="y"){
                corol=ziid;
            }
            if(zi=="d"){
                address=ziid;
            }
        }
        alert("bname"+bname+"\t"+"csname"+csname+"\t"+"price"+price+"\t"+"carage"+carage+"\t"+"corol"+corol+"\t"+"address"+address);
    }

    //跳转
    function carmai(urc) {
        location.href = urc;
    }



});//窗体
    //重新选择
    function cardseries() {
        bname=0;csname=0;
        $(".mycardseries .xzz").css({"background-color":"#f9f9f9","color":"#666"});  //清理样式
        $(".mycardseries .xzz").attr({"class":"xz"});
    }

    //多条件分页
    function carpage(math) {
        alert("多条件分页!!!");
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
        alert(index);
        $.ajax({
            type:'post',
            url:'listhtml3',
            data:'bid='+bname+'&csid='+csname+'&price='+price+'&carage='+carage+'&colorid='+corol+'&addid='+address+'&pageindex='+index,
            cache:false,
            success:function(result){
                var ar=result.split("-","3");
                var first=ar[0];
                var count2=ar[1];
                $(".pagei").find("i:eq(0)").html(first);
                $(".pagei").find("i:eq(1)").html(count2);

                result=eval(ar[2]);
                $("#addcar1").html("");  //清空处理
                for(var i=0;i<result.length;i++){
                    var obj=result[i];
                    var img="images/"+obj.img;           //获取图片路径
                    var bname=obj.brand.bname;           //获取车品牌
                    var csname=obj.cardseries.csname;    //获取车系
                    var cid=obj.cid;                     //获取车id
                    var carage=obj.carage;               //获取车龄
                    tr+="<li>" +
                        "<div class='list-infoBox'>" +
                        "<a target='_parent' href='#'><img src='"+img+"' width='290' height='194' /></a>" +
                        "<p class='infoBox'><a target='_blank' class='info-title'></a>"+bname+"-"+csname+""+cid +" 车龄"+carage+"年 </p>" +
                        "<p class='fc-gray'><span class='tag-gray'>"+obj.address.address+"</span> <span class=''>车龄"+carage+"年</span> <em class='shuxian'>|</em> 颜色:"+obj.corol.corol+"</p>" +
                        "<p class='priType-s'><span> <i class='fc-org priType'>"+obj.price+"万 </i> </span> <s>"+obj.oprice+"万</s> </p> " +
                        "</div>" +
                        "</li>";
                }
                $("#addcar1").append(tr);
            },
            error:function(){
                alert("响应失败！!");
            }
        });
    }