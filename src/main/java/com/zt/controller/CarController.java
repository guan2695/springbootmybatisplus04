package com.zt.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.*;
import com.zt.mapper.CarMapper;
import com.zt.mapper.CorolMapper;
import com.zt.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author guan
 * @create 2020-05-08 9:20
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private UserService userService;

    @Autowired
    private BrandService brandService;
    @Autowired
    private CorolMapper corolMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private  HistoryService historyService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private  CardinfomaxService cardinfomaxService;
    @Autowired
    private CarinfoService carinfoService;
    @Autowired
    private AssessmentService assessmentService;
     @Autowired
    private BuyershowService buyershowService;


    /**
     *  首页的查询车辆
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String  homePage(Model model,HttpSession session){
        System.out.println("进入多表查询车");
        List<Car> carList = carService.selectlimit();
        carList.forEach(System.out::println);
        model.addAttribute("carList",carList);

        List<Car> carListagr=carService.selectCarage();
        model.addAttribute("carListagr",carListagr);
        List<Car> carlistPrice=carService.selectOprice();
        model.addAttribute("carlistPrice",carlistPrice);
        System.out.println("一共输出了"+carList.size()+"条数据");
        //车品牌
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList3",brandList);
//        model.addAttribute("brandList",brandList);
        return "index";
    }

    /**
     * 账户退出时走的方法
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index2")
    public String  homePage2(Model model,HttpSession session){
        System.out.println("进入多表查询车");
        List<Car> carList = carService.selectlimit();
        carList.forEach(System.out::println);
        model.addAttribute("carList",carList);
        List<Car> carListagr=carService.selectCarage();
        model.addAttribute("carListagr",carListagr);
        List<Car> carlistPrice=carService.selectOprice();
        model.addAttribute("carlistPrice",carlistPrice);
        System.out.println("一共输出了"+carList.size()+"条数据");
        session.removeAttribute("list2");
        //车品牌
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList",brandList);
        return "index";
    }

    /**
     * 修改车的评估状态
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/updateAssesstate")
    public String updateCarassesstate(Model model,Car car){
        car.setCid(1);
        car.setAssesstate(0);
        int num=carService.updateCarassesstate(car);
        System.out.println("成功"+num+"失败"+num);
        return "login";
    }

    /**
     * 修改车的上架状态
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/updatePutstate")
    public String updateCarputstate(Model model,Car car){
        car.setCid(1);
        car.setPutstate(0);
        int num=carService.updateCarputstate(car);
        System.out.println("成功"+num+"失败"+num);
        return "login";
    }

    /**
     * 查询评估或者未评估的车辆
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/getAssesstate")
    public String getAssesstate(Model model,Car car){
        car.setAssesstate(0);
       List<Car> listAssesstate= carService.selectgetAssesstate(car);
       model.addAttribute("listAssesstate",listAssesstate);
               if(listAssesstate.size()==0){
                   return "error";
               }
       return "show";
    }

    /**
     * 查询上架或者下架的车辆
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/getPutstate")
    public String getPutstate(Model model,Car car){
        car.setPutstate(0);
        List<Car> listputstate = carService.selectgetPutstate(car);
        model.addAttribute("listputstate",listputstate);
        if(listputstate.size()==0){
            return "error";
        }
        return "show2";
    }

    /**
     * 多条件查询
     * @param model
     * @param car
     * @return
     */
    @RequestMapping("/listhtml")
    public String manyConditions(Model model,Car car,Integer first,HttpSession session){
        System.out.println("进入多条件查询");
       // System.out.println(bid);
        System.out.println(car);
        List<Car> listmanyQuery;
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList",brandList);
//        if(bid==null){
//            bid="0";
//        }
//       int bid2 =Integer.parseInt(bid);
//       System.out.println("车牌id为"+bid2);
        //页面显示八个
        int pageSize=8;
        if(first==null){
            first=1;
          //  car.setBid(bid2);
            listmanyQuery =carService.manyCar(car,(first-1)*pageSize,pageSize);
        }

       listmanyQuery =carService.manyCar(car,(first-1)*pageSize,pageSize);
        int total=listmanyQuery.size();
        System.out.println("多条件查询共"+listmanyQuery.size()+"条数据");
        int count= (int) (total%pageSize==0?total/pageSize:total/pageSize+1);
        model.addAttribute("listmanyQuery",listmanyQuery);
        System.out.println("总页数为"+count);
        model.addAttribute("pageindex",first);
        model.addAttribute("count",count);
        return "list";
    }




    //根据品牌进入
    @RequestMapping("/listhtml2")
    public String listhtml(String pageindex,Model model, Car car,String bid,Double price,String carage,HttpSession session,String csid) {
        System.out.println(" --------进入查询--------- ");
        if(bid==null){
            bid="0";
        }
        if(csid==null){
            csid="0";
        }
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList",brandList);
        int bid2 =Integer.parseInt(bid);
        int csid2=Integer.parseInt(csid);
        System.out.println("车牌id为"+bid2);
        car.setBid(bid2);
        car.setCsid(csid2);
        car.setPrice(price);
        car.setFirst(0);
        car.setPageSize(8);
        if(carage==null){
            carage="0";
        }
        int age = Integer.parseInt(carage);
        System.out.println("车龄是区间"+age);
        car.setCarage(car.getCarage());
        System.out.println("价格"+car.getPrice());
        List<Car> listmanyQuery =carService.manyConditions(car);
        model.addAttribute("listmanyQuery",listmanyQuery);
        System.out.println("多条件查询共"+listmanyQuery.size()+"条数据");

        //分页得总页数
        int pageSize=8;
        if(pageindex==null){
            pageindex="0";
        }
        int first1=Integer.parseInt(pageindex);
        //查询页码
        System.out.println(first1);
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }

        //总页数
        List<Car> listmanyQuery02 =carService.jiangPageconut(car);
        int count=listmanyQuery02.size();
        System.out.println("总个数："+count);

        car.setFirst(first);
        car.setPageSize(pageSize);
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        System.out.println("总页数："+count);
        session.setAttribute("jiangconnt",count);

        System.out.println("进入查询一个车牌和他的车系");
        if(bid2!=0){
            Brand brand= brandService.getOneBrandById(bid2);
            List<Cardseries> cardserieslist= brand.getCardseries();
            model.addAttribute("brand",brand);
            session.setAttribute("cardserieslist",cardserieslist);
        }
        //得到所有颜色
        List<Corol> corollist=corolMapper.getAllcorol();
        session.setAttribute("corollist",corollist);
        //得到所有地区
        List<Address>addresseslist = addressService.getAllAddress();
        session.setAttribute("addresseslist",addresseslist);
        return "list";
    }
    //分页
    @RequestMapping("/listhtml3")
    @ResponseBody
    public String listhtml3(String pageindex,Model model, Car car,String bid,Double price,String carage,HttpSession session,String csid,String addid,String colorid) {
        System.out.println(" --------进入分页查询--------- ");
        if(bid==null){
            bid="0";
        }
        if(csid==null){
            csid="0";
        }
        if(addid==null){
            addid="0";
        }
        if(colorid==null){
            colorid="0";
        }
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList",brandList);
        int bid2 =Integer.parseInt(bid);
        int csid2=Integer.parseInt(csid);
        int addid2 = Integer.parseInt(addid);
        int colorid2 =Integer.parseInt(colorid);
        System.out.println("车牌id为"+bid2);
        car.setBid(bid2);
        car.setCsid(csid2);
        car.setPrice(price);
        car.setAddressid(addid2);
        car.setCorolid(colorid2);
        if(carage==null){
            carage="0";
        }
        int age = Integer.parseInt(carage);
        System.out.println("车龄是区间"+age);
        car.setCarage(car.getCarage());
        System.out.println("价格"+car.getPrice());

        //分页
        int pageSize=8;
        if(pageindex==null){
            pageindex="0";
        }
        int first1=Integer.parseInt(pageindex);
        //查询页码
        System.out.println(first1);
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }

        //总页数
        List<Car> listmanyQuery02 =carService.jiangPageconut(car);
        int count=listmanyQuery02.size();
        System.out.println("总个数："+count);

        car.setFirst(first);
        car.setPageSize(pageSize);
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        System.out.println("总页数："+count);

        //显示页码
        int first2=0;
        if(first!=0){
            first2=(first/pageSize+1);
        }else{
            first2=1;
        }
        System.out.println("显示页数"+first2);

        List<Car> listmanyQuery =carService.manyConditions(car);
        if(bid2!=0){
            Brand brand= brandService.getOneBrandById(bid2);
            List<Cardseries> cardserieslist= brand.getCardseries();
            model.addAttribute("brand",brand);
            session.setAttribute("cardserieslist",cardserieslist);
        }
        model.addAttribute("listmanyQuery",listmanyQuery);
        System.out.println("多条件查询共"+listmanyQuery.size()+"条数据");

        //存值
        String str=first2+"-"+count+"-"+ JSONArray.toJSONString(listmanyQuery);
        System.out.println(str);

        return str;
    }

    //得到总页数
    @RequestMapping("/getcarcount")
    @ResponseBody
    public int listhtmlconnt(String pageindex,Model model, Car car,String bid,Double price,String carage,HttpSession session,String csid,String addid,String colorid) {
        System.out.println(" --------进入查询--------- ");
        if(bid==null){
            bid="0";
        }
        if(csid==null){
            csid="0";
        }
        if(addid==null){
            addid="0";
        }
        if(colorid==null){
            colorid="0";
        }
        int addid2 = Integer.parseInt(addid);
        int colorid2 =Integer.parseInt(colorid);
        car.setAddressid(addid2);
        car.setCorolid(colorid2);

        int bid2 =Integer.parseInt(bid);
        int csid2=Integer.parseInt(csid);
        System.out.println("车牌id为"+bid2);
        car.setBid(bid2);
        car.setCsid(csid2);
        car.setPrice(price);
        car.setFirst(1);
        car.setPageSize(8);
        if(carage==null){
            carage="0";
        }
        int age = Integer.parseInt(carage);
        System.out.println("车龄是区间"+age);
        car.setCarage(car.getCarage());
        System.out.println("价格"+car.getPrice());

        //分页得总页数
        int pageSize=8;
        if(pageindex==null){
            pageindex="0";
        }
        int first1=Integer.parseInt(pageindex);
        //查询页码
        System.out.println(first1);
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }

        //总页数
        List<Car> listmanyQuery02 =carService.jiangPageconut(car);
        int count=listmanyQuery02.size();
        System.out.println("总个数："+count);

        car.setFirst(first);
        car.setPageSize(pageSize);
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        System.out.println("总页数："+count);

        return count;
    }

    //导航栏异步跳转
    @RequestMapping("/listhtml4")
    @ResponseBody
    public List<Car> listhtml4(Integer pageindex,Model model, Car car,String bid,Double price,String carage,HttpSession session,String csid,String addid,String colorid) {
        System.out.println(" --------getcardseries进入查询--------- ");
        if(bid==null){
            bid="0";
        }
        if(csid==null){
            csid="0";
        }
        if(addid==null){
            addid="0";
        }
        if(colorid==null){
            colorid="0";
        }
        List<Brand> brandList= brandService.getAllBrand();
        session.setAttribute("brandList",brandList);
        int bid2 =Integer.parseInt(bid);
        int csid2=Integer.parseInt(csid);
        int addid2 = Integer.parseInt(addid);
        int colorid2 =Integer.parseInt(colorid);
        System.out.println("车牌id为"+bid2);
        car.setBid(bid2);
        car.setCsid(csid2);
        car.setPrice(price);
        car.setAddressid(addid2);
        car.setCorolid(colorid2);
        car.setFirst(0);
        car.setPageSize(8);
        if(carage==null){
            carage="0";
        }
        int age = Integer.parseInt(carage);
        System.out.println("车龄是区间"+age);
        car.setCarage(car.getCarage());
        System.out.println("价格"+car.getPrice());
        List<Car> listmanyQuery =carService.manyConditions(car);
        if(bid2!=0){
            Brand brand= brandService.getOneBrandById(bid2);
            List<Cardseries> cardserieslist= brand.getCardseries();
            model.addAttribute("brand",brand);
            session.setAttribute("cardserieslist",cardserieslist);
        }
        model.addAttribute("listmanyQuery",listmanyQuery);
        System.out.println("多条件查询共"+listmanyQuery.size()+"条数据");
        return listmanyQuery;
    }

    @RequestMapping("/jiangcardseries")
    @ResponseBody
    public List<Cardseries> getcardseries(Integer pageindex,Model model, Car car,String bid,HttpSession session) {
        System.out.println(" --------查询品牌的车系"+bid+"--------- ");
        if(bid==null){
            bid="0";
        }
        int bid2 =Integer.parseInt(bid);
        List<Cardseries> cardserieslist=null;
        if(bid2!=0){
            Brand brand= brandService.getOneBrandById(bid2);
            cardserieslist= brand.getCardseries();
        }
        //输出集合
        if(cardserieslist!=null){
            cardserieslist.forEach(System.out::println);
        }

        return cardserieslist;
    }

    /**
     * 模糊查询总页数
     * @return
     */
    @RequestMapping("/getSearchPageCount")
    @ResponseBody
    public String getSearchPageCount(String search,String pageindex){
        System.out.println("模糊查询总页数");
        Car car=carService.searchCarPageCount(search);
        int count= car.getCarage();
        int pageSize=8;
        if(count%pageSize==0){
            count=count/pageSize;
        }else{
            count=count/pageSize+1;
        }
        if(pageindex.equals("0")){
            pageindex="1";
        }
        System.out.println("总页数："+count+"页码"+pageindex);
        String str=pageindex+"~"+count;

        return str;
    }

    //模糊查询
    @RequestMapping("/searchCarByPage")
    @ResponseBody
    public List<Car> searchCarByPage(String search,String pageindex, Model model) {
        System.out.println(" --------进入模糊查询("+search+")("+pageindex+")--------- ");
        if(pageindex==null){
            pageindex="1";
        }
        int first1=Integer.parseInt(pageindex);
        int pageSize=8;
        int first=0;
        if(first1!=0){
            first=(first1-1)*pageSize;
        }

        List<Car> carlist= carService.searchCarByPage(search,first,pageSize);
        carlist.forEach(System.out::println);
        return carlist;
    }





    /**
     * 查询一辆车的详细信息
     * 并且加一条浏览记录
     * @param model
     * @param car
     * @param session
     * @param images
     * @return
     */
    @RequestMapping("/getCarone")
        public String getCarone(Model model, Car car, HttpSession session,Images images,int cid,String uid,History history){
        System.out.println("车的id"+cid);
        car.setCid(cid);
        Car getone = carService.getCarone(car);
        model.addAttribute("getone",getone);
        System.out.println("车的id"+car.getCid());
        images.setCid(car.getCid());
        List<Images> listimages = imagesService.getimgesone(images);
        String string1 =listimages.get(0).getSrc();
        String string2 =listimages.get(1).getSrc();
        String string3 =listimages.get(2).getSrc();
        String string4 =listimages.get(3).getSrc();
        String string5 =listimages.get(4).getSrc();
        String string6 =listimages.get(5).getSrc();

        model.addAttribute("string1",string1);
        model.addAttribute("string2",string2);
        model.addAttribute("string3",string3);
        model.addAttribute("string4",string4);
        model.addAttribute("string5",string5);
        model.addAttribute("string6",string6);
        //model.addAttribute("listimages",listimages);


        Car carone1 = carService.getCarinfo(car);
        Car carinfomax =carService.getCardinfomax(car);
      // System.out.println("共1"+carone+"条数据");
        //基本数据类型长宽高
        model.addAttribute("carinfo1",carone1);
        //详细


        model.addAttribute("carinfomax",carinfomax);
        //System.out.println(carone1.getCarinfo().getLength());
        /**
         * 判断用户是否登录
         * 加一条浏览记录
         */


          User user= (User) session.getAttribute("list2");
          if(user==null){
              return "infor";

          }else {
           int uid5= user.getUid();
           uid=""+uid5;


         int uid2 = Integer.parseInt(uid);

            history.setUid(uid2);
            history.setCid(cid);
            int num = historyService.insertHistory(history);
            if (num > 0) {
                System.out.println("插入数据成功");
            }
            history.setUid(uid2);
            List<History> listHistory= historyService.selectHistory(history);
            session.setAttribute("listHistory",listHistory);
            System.out.println("查询浏览记录有"+listHistory.size());
        }
        return "infor";
    }
/**
 * 查询该用户买的车
 */
@RequestMapping("/selectTranction")
   public String  selectTranction(Transaction transaction,Model Model,int uid){
    System.out.println("买车交易记录查询");
    transaction.setBuyer(uid);
    List<Car> transactionlist = carService.selectTranction(transaction);
    Model.addAttribute("transactionlist",transactionlist);
    System.out.println("交易记录有"+transactionlist.size());
    transaction.setSeller(uid);
    List<Car> transactionlistseller = carService.selectTranctionseller(transaction);
    Model.addAttribute("transactionlistseller",transactionlistseller);
    return "user_bus";
}
    @RequestMapping("/selectTranctionseller")
    public String  selectTranctionseller(Transaction transaction,Model Model,int uid){
        System.out.println("卖车交易记录查询");
        transaction.setSeller(uid);
        List<Car> transactionlistseller = carService.selectTranctionseller(transaction);
        Model.addAttribute("transactionlistseller",transactionlistseller);
        System.out.println("交易记录有"+transactionlistseller.size());
        return "user_bus";
    }
    public double toDouble(double num) {
        DecimalFormat dFormat = new DecimalFormat("#.00");
        String yearString = dFormat.format(num);
        Double temp = Double.valueOf(yearString);
        return temp;
    }
    /**
     * 买车控制器
     */
    @Transactional
    @RequestMapping("/buyCar")
    public String buyCar(Car car,int uid,double money,int cid,int cuid,User user,Double umoney,Double cmoney,Transaction transaction,Model model){
    System.out.println("进入买车");
    System.out.println("买家id"+uid);
    System.out.println(money);
    System.out.println(car);
    System.out.println(cuid);
    System.out.println(cid);
    System.out.println("用户余额"+umoney);
    System.out.println("车主余额"+cmoney);
    //给买家减少钱
   Double money1 = umoney-money;
   money1=toDouble(money1);
    User user1 = new User();
    user1.setUid(uid);
    user1.setMoney(money1);
    int num=userService.updateMoney(user1);
    System.out.println("用户减少金额"+num);


    Double cmoney2=cmoney+money;
        cmoney2=toDouble(cmoney2);
    User user2 = new User();
    user2.setUid(cuid);
    user2.setMoney(cmoney2);
    int num2=userService.updateMoney(user2);
    System.out.println("车主增加金额"+num2);

    /**
     * 添加交易记录
     */
    transaction.setCid(cid);
    transaction.setBuyer(uid);
    transaction.setSeller(cuid);
    transaction.setTmoney(money);
     int num3 = transactionService.insertTransaction(transaction);
    System.out.println("交易表插入"+num3);
    /**
     * 车下架
     */

    car.setCid(cid);
    car.setPutstate(0);
    int num4=carService.updateCarputstate(car);
    System.out.println("车辆下架"+num4);
    if(cuid==uid){
        return "404";
    }


    return "success";

}
    /**
     * 卖车页面
     */
    @RequestMapping("/carall")
    @ResponseBody
    public String carall(HttpSession Session,int bid,int csid,int corolid,String uname ,Double oprice,Double price,int addressid,int carage,String img,Double pailiang,String youtype,int youname,String dangtype,int length,int width,int height,int mass){
        System.out.println("进入");
        //添加信息
        User uids= userService.selectuid(uname);
        String uids1=uids.getUid()+"";
        int uid=Integer.parseInt(uids1);

        String num=carService.carall(bid,csid,corolid,uid,oprice,price,addressid,carage,img);
        //添加src
        Car Cid = carService.carcid();
        int cid=Cid.getCid();
        String carim=carService.carimg(cid,img);
        //添加高级配置
        int max= cardinfomaxService.infomax(cid,pailiang,youtype,youname,dangtype);
        int  info=carinfoService.addinfo(cid,length,width, height, mass);
        System.out.println("uid="+uid);
        System.out.println("cid="+cid);
        int addas=assessmentService.addass(uid,cid);
        if (num !=null && max<=0&&info<=0&&addas<=0) {
            System.out.println("插入数据成功");
            return "sell";
        }
        return "no";
    }
    @RequestMapping("/ifshow")
    @ResponseBody
    public  String ifshow(Buyershow buyershow,int cid){
        System.out.println("车的id"+cid);
        buyershow.setCid(cid);
        Buyershow buyershow2= buyershowService.selectBuyershowCid(buyershow);
        System.out.println("是否存在"+buyershow2);
        if(buyershow2!=null){
            return "yes";
        }
        return "no";


    }

}
