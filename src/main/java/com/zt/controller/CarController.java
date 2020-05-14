package com.zt.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.*;
import com.zt.mapper.CarMapper;
import com.zt.mapper.CorolMapper;
import com.zt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        session.setAttribute("brandList",brandList);
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



    /**
     *
     */
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
        car.setFirst(1);
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
        String str=first2+"-"+count+"-"+JSONArray.toJSONString(listmanyQuery);
        System.out.println(str);

        return str;
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
        car.setFirst(1);
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
        cardserieslist.forEach(System.out::println);

        return cardserieslist;
    }

    /**
     * 查询一辆车的详细信息
     * @param model
     * @param car
     * @param session
     * @param images
     * @return
     */
    @RequestMapping("/getCarone")
        public String getCarone(Model model, Car car, HttpSession session,Images images,int cid){
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
        System.out.println(carone1.getCarinfo().getLength());
        return "infor";
    }


}
