package com.example.Alpha.Controller.AdminController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.ArticalBean;
import com.example.Alpha.Dao.ArticalDao;
import com.example.Alpha.Service.AdminService.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/admin")
public class ArticalController {
    @Autowired
    ArticalService articalService;

    @Autowired
    ArticalDao articalDao;


    @RequestMapping(value = "/articalupload")
    @ResponseBody
    public JSONObject upLoadArtical(@RequestBody JSONObject artical ){
        JSONObject out=new JSONObject();
        ArticalBean articalBean=new ArticalBean();
        Integer status;
        if (artical.getString("body")!=null){
            articalBean.setArtical_htmlTag(artical.getString("body"));
            articalBean.setArtical_title(artical.getString("title"));
            articalBean.setArtical_kindOf(artical.getString("kindOf"));
            articalBean.setArtical_kindOfTag(artical.getString("kindoftag"));
            articalBean.setArtical_markdownCode(artical.getString("text"));
            status=articalService.articalUpload(articalBean);

            out.put("status",status);
            if (status==1){
                out.put("msg","文章上传成功");
            }
            else {
                out.put("msg","文章上传失败");
            }


        }
        return out;
    }

    @RequestMapping(value = "/getallartical",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getAllArtical(HttpServletRequest request){

        JSONObject out=new JSONObject();

        List list= articalService.getAllArtical();

        if (list!=null){
            out.put("dataArtical",list);
            out.put("status","1");
        }else {
            out.put("status","0");
            out.put("msg","请求失败");
        }
        return out;
    }


    @RequestMapping(value = "/deletearticalbyid")
    @ResponseBody
    public JSONObject delateArticalById(@RequestParam("id") Integer id){
        JSONObject out=new JSONObject();

        Integer status=articalService.delateArticalById(id);

        if (status==1){
            out.put("msg","删除成功");
            out.put("status",status);
        }else {
            out.put("msg","删除失败");
            out.put("status",status);
        }

        return out;
    }


    @RequestMapping(value = "/getarticalbyid",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getAllArticalById(@RequestParam("id")Integer id){
        JSONObject out=new JSONObject();

        ArticalBean list= articalService.getArticalById(id);

        if (list!=null){
            out.put("status",1);
            out.put("msg","获取成功");
            out.put("list",list);
        }else {
            out.put("status",0);
            out.put("msg","获取失败");
        }


        return out;
    }


    @RequestMapping(value = "/getarticalbykindof",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getAllArticalByKindOf(@RequestParam("str")String str){
        JSONObject out=new JSONObject();

       List<ArticalBean> list= articalService.getArticalByKindOf(str);

        if (list!=null){
            out.put("status",1);
            out.put("msg","获取成功");
            out.put("list",list);
        }else {
            out.put("status",0);
            out.put("msg","获取失败");
        }


        return out;
    }



    @RequestMapping(value = "/changeartical",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateArticalById(@RequestBody ArticalBean articalBean){
        JSONObject out=new JSONObject();

        Integer status= articalService.updateArticalById(articalBean);

        if (status==1){
            out.put("status",status);
            out.put("msg","文章修改成功");
        }else {
            out.put("status",status);
            out.put("msg","文章上传失败");
        }
        return out;
    }


    @RequestMapping(value = "/getarticalkindofinfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getArticalKindOfInfo(){
        JSONObject out=new JSONObject();

        List<Map<String,String>> map=articalDao.getArticalKindOfInfo();

        out.put("result",map);

        return out;
    }






}
