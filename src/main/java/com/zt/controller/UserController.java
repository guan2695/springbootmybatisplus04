package com.zt.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zt.entity.*;

import com.zt.mapper.AssessoverMapper;
import com.zt.mapper.LoansassesMapper;

import com.zt.mapper.UsersMapper;
import com.zt.service.*;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.lang.UsesJava7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author guan
 * @create 2020-04-24 14:54
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private LoansService loansService;
    @Autowired
    private BanksService banksService;


    @Autowired
    private BrandService brandService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private LoansassesMapper loansassesMapper;
    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private AssessoverMapper assessoverMapper;
    @Autowired
    private CarseriesService carseriesService;

    @Autowired
    private CorolService corolService;


    /**
     * 得到所有用户
     *
     * @param modelmap
     * @return
     */
    @RequestMapping("/selectAll")
    public String testfreemake(Model modelmap) {
        System.out.println(" --------Select--------- ");
        List<User> list = userService.selectall();
        for (User users : list) {
        }
        modelmap.addAttribute("list", list);
        return "succes";

    }

    /**
     * 用户登录
     *
     * @param
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, User user,History history,Model model) {
        System.out.println(" --------login--------- ");
        System.out.println("phone" + user.getPhone());
        User userlist2 = userService.selectlogin(user);
        if(userlist2==null){
            return "404";
        }
        session.setAttribute("list2", userlist2);
        int uid2 = userlist2.getUid();
        System.out.println("该用户id"+uid2);
        history.setUid(uid2);
        List<History> listHistory= historyService.selectHistory(history);
        session.setAttribute("listHistory",listHistory);
        System.out.println("查询浏览记录有"+listHistory.size());
        return "forward:index";
    }
    @RequestMapping("/login2")
    public String login2(HttpSession session, User user,History history,Model model,String phone,String upwd) {
        System.out.println(" --------login2--------- ");
        if(phone==null){
            phone="11111111111";
        }
        if(upwd==null){
            upwd="123";
        }
        user.setPhone(phone);
        user.setUpwd(upwd);
        User userlist2 = userService.selectlogin(user);
        session.setAttribute("list2", userlist2);
        int uid2 = userlist2.getUid();
        history.setUid(uid2);
        List<History> listHistory= historyService.selectHistory(history);
        model.addAttribute("listHistory",listHistory);
        System.out.println("查询浏览记录有"+listHistory.size());
        return "forward:index";
    }

    /**
     * 退出账号走的方法
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/remove")
    public String login2(HttpSession session, User user) {
        session.setAttribute("list2",null);
        return "forward:index2";
    }

    /**
     * 后台进入用户页面
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/userinfo2")
    public String userinfo2(HttpSession session, User user,Model model) {
      User list2= userService.selectlogin(user);
      session.setAttribute("list2",list2);
        return "user";
    }
    @RequestMapping("/userinfo")
    public String userinfo(HttpSession session, User user,Model model) {

        return "user";
    }
    @RequestMapping("/userinfoCar")
    public String userinfoCar(HttpSession session, User user) {
        return "user_bus";
    }
    @RequestMapping("/userinfoPwd")
    public String userinfoPwd(HttpSession session, User user) {
        return "user_account";
    }
    @RequestMapping("/userloan")
    public  String userloan(User user,Model model,int uid){
        Loans loans = new Loans();
        loans.setUid(uid);
        System.out.println("用户di为"+user.getUid());
       List<Loans> loansList= loansService.getUserone(loans);
       model.addAttribute("loansList",loansList);
        return "user_loans";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    /**
     * 进入购买页面
     * @param model
     * @param user
     * @param car
     * @return
     */
    @RequestMapping("/peynow")
    public String loans(Model model, User user,Car car) {
        System.out.println(car);
        Car getone = carService.getCarone(car);
        model.addAttribute("getone",getone);
        System.out.println("进入购买页面");
        return "peynow";
    }

    /**
     * 进入贷款页面
     * @param model
     * @param car
     * @param cid
     * @return
     */
    @RequestMapping("/loans")
    public String loans(Model model,Car car,int cid){
        System.out.println("进入贷款页面");
        System.out.println(car);
        car.setCid(cid);
        Car getone2 = carService.getCarone(car);
        model.addAttribute("getoneloans",getone2);
        System.out.println("进入贷款页面");
       List<Banks> banksList= banksService.getAllBanks();
        model.addAttribute("banksList",banksList);
        return "loans";
    }


    /**
     * 查询失败原因
     * @param
     * @return
     */
    @RequestMapping("/selecterrorLoansasses")
    @ResponseBody
    public String    selecterrorLoansasses(Loansasses loansasses,int lid,Model model){
        loansasses.setLid(lid);
        Loansasses loansasses1 =loansassesMapper.selecterrorLoansasses(loansasses);
        model.addAttribute("loansasses1",loansasses1);
       String Lmsgstate=  loansasses1.getLmsgbecause();
        return Lmsgstate;
    }

    /**
     * 进入用户车辆审核页面
     * @param
     * @return
     */
    @RequestMapping("/selectUserAssessment")
    public  String selectUserAssessment(Assessment assessment,int uid,Model model){
        assessment.setUid(uid);
        List<Assessment> assessmentList= assessmentService.selectUserAssessment(assessment);
        model.addAttribute("assessmentList",assessmentList);

        for (Assessment assessment1 : assessmentList) {
           int cid= assessment1.getCid();
//           Car car = new Car();
//           car.setCid(cid);
//          Car getCar= carService.getCarone(car);
//          model.addAttribute("getCar",getCar);
        }
        return "user_car";
    }

    /**
     * 查看车辆审核失败原因
     * @param
     * @return
     */
    @RequestMapping("/selectOver")
    @ResponseBody
    public String selectOver(Assessover assessover,int aid){
        assessover.setAid(aid);
        Assessover assessover1 = assessoverMapper.selectOver(assessover);
       String because= assessover1.getBecause();
    return because;
    }


    public double toDouble(double num) {
        DecimalFormat dFormat = new DecimalFormat("#.00");
        String yearString = dFormat.format(num);
        Double temp = Double.valueOf(yearString);
        return temp;
    }
    /**
     * 添加贷款信息
     * @param
     * @param
     * @return
     */


    @RequestMapping("/insertbanks")
    public String insertbanks(Model model, Loans loans,int bankid,int cuid,Double cmoney,int uid,String idcard,Double lmoney,int ishavehouse){
        loans.setUid(uid);
        loans.setLmoney(lmoney);
        loans.setIdcard(idcard);
        loans.setIshavehouse(ishavehouse);
        loans.setBankid(bankid);
        System.out.println(loans);
        loans.setBankid(bankid);
        //车钱
         Double money= loans.getLmoney();
         //卖车的加钱uid
        System.out.println("车主的余额"+cmoney);
        Double money3 =cmoney+money;
        money3=toDouble(money3);
        int cuid2=cuid;
        int num= loansService.insertloans(loans);
        System.out.println("插入贷款信息"+num);


//        User user2 = new User();
//        user2.setUid(cuid);
//        user2.setMoney(money3);
//        int num2=userService.updateMoney(user2);
//        System.out.println("车主增加金额"+num2);


        if(num==0){
            return "404";
        }


        return "userloan?uid="+uid;

    }

    @RequestMapping("/wymchtml")
    public String wymchtml(HttpSession session, User user) {
        return "wymc";
    }

    /**
     * 用户注册
     * @param user
     * @param
     * @return
     */

    @RequestMapping("/register")
    @ResponseBody
    public String add(User user,String phone,String upwd,String uname,String verify,HttpSession session) {
        user.setPhone(phone);
        user.setUname(uname);
        user.setUpwd(upwd);

       String validateCode= (String) session.getAttribute("validateCode");
        System.out.println("生成的验证码："+validateCode+"用户输入的验证码："+verify);

        if(validateCode.equalsIgnoreCase(verify)){
          System.out.println("页面传送的uname是" + user.getUname());
          int num = userService.userregister(user);
          System.out.println("num的值为" + num);
          return "yes";
        }else{
            System.out.println("验证码错误");
            return "error";
        }
    }
    /**
     * 注册前判断phone是否存在
     */
    @RequestMapping("/Userphone")
    @ResponseBody
     public  String Userphone(String phone,User user){
        user.setPhone(phone);
          User user1= userService.userphone(user);
          if(user1!=null){
              //存在不能执行注册
              return "yes";
          }
        return "no";
    }

    /**
     * 修改用户密码
     */
    @RequestMapping("/updatepwd")
    public String  updateUpwd(Model model, User user,int uid,String upwd){
        if(upwd==null){
            System.out.println("upwd无参数");
        }
        user.setUpwd(upwd);
        user.setUid(uid);
        int num = usersMapper.updateUserpwd(user);
        if(num==0){
            return "forward:userinfo";
        }
        return "remove";
    }
    @RequestMapping("/updateuser")
    public String updateuser(Model model, User user,int uid,HttpSession session){
        System.out.println(user);
        user.setUid(uid);
        int num = userService.updateuser(user);
       User list2= userService.selectlogin(user);
       session.removeAttribute("list2");
       session.setAttribute("list2",list2);
        if(num==0){
            return "forward:userinfo";
        }
        return "user";

    }

    /**
     *
     */
    /**
     *
     */
    @RequestMapping("/selllogin")
    public String selllogin(HttpSession session,Model model,User user){
        System.out.println(" --------selllogin--------- ");
        System.out.println("phone" + user.getPhone());
        User user1=userService.selllogin(user);
        System.out.println("userlist" + user1);
        model.addAttribute("userlist",user1);
        List<Brand> brandList= brandService.getAllBrand();
        List<Address>addressList=addressService.getAllAddress();
        System.out.println("brandlist="+brandList);
        System.out.println("brandlist="+brandList);
        model.addAttribute("brandlist",brandList);
        model.addAttribute("addresslist",addressList);
        List<Corol> corolList=corolService.getAllcorol();
        System.out.println("corolList="+corolList);
        model.addAttribute("corolList",corolList);
        if(user1!=null){
            return "sell";
        }else {
            System.out.println("查询方法失败");
        }
        return "wymc";
    }
    @RequestMapping("/selllogin01")
    @ResponseBody
    public String selllogin01(HttpSession session,Model model,User user){
        System.out.println(" --------selllogin01--------- ");
        System.out.println("phone" + user.getPhone());
        User user1=userService.selllogin(user);
        if(user1!=null){
            return "wymc";
        }else {
            System.out.println("查询方法失败");
        }
        return "sell";
    }


    @RequestMapping("/selllogin02")
    @ResponseBody
    public List<Cardseries> selllogin02(HttpSession session,Model model,String bid){
        System.out.println(" --------selllogin02--------- ");
        System.out.println("bid="+bid);
        if(bid==null){
            bid="0";
        }
        List<Cardseries> cardseriesList=carseriesService.getCardSeriesByBrand((Integer.parseInt(bid)));
        cardseriesList.forEach(System.out::println);
        return cardseriesList;

    }
//    //分页
//    @RequestMapping("fenye")
//    public String fentye(Integer pageindex,Model model){
//   int  pagesize=3;
//        Page<Users> page;
//if(pageindex==null){
//    pageindex=1;
//    page=new Page<>(pageindex,pagesize);
//}
//        page=new Page<>(pageindex,pagesize);
//        IPage iPage=usersmapper.selectPage(page,null);
//        System.out.println("总ge数"+iPage.getTotal());
//    long total=iPage.getTotal();
//    int count= (int) (total%pagesize==0?total/pagesize:total/pagesize+1);
//        System.out.println("总页数为"+count);
//    List<Users> listu=   iPage.getRecords();
//        model.addAttribute("count",count);
//        model.addAttribute("pageindex",pageindex);
//        model.addAttribute("listu",listu);
//    return "fenye";
//
//    }

}
