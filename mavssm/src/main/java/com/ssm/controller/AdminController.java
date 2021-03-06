package com.ssm.controller;


import com.ssm.biz.AdminBiz;
import com.ssm.po.Admin;
import com.ssm.utils.JsonUtils;
import com.ssm.utils.ListObject;
import com.ssm.utils.ResponseUtils;
import com.ssm.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    @Qualifier("adminBiz")
    private AdminBiz adminBiz;

    /*
     * 获取指定id的用户
     */
    @RequestMapping(value = "/adminLogin")
    public void adminLogin(String ad_name, String ad_password, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(100);
        Admin admin = adminBiz.adminLogin(ad_name, ad_password);
        List<Admin> list = new ArrayList<Admin>();
        list.add(admin);
        ListObject listObject = new ListObject();
        listObject.setData(list);
        if (null == admin) {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setDesc("登录失败");
        } else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setDesc("登录成功");
        }
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
    }

    /*
     * 获取指定id的用户
     */
    @RequestMapping(value = "/adminchangepwd")
    public void adminchangepwd(String ad_name, String ad_password, String new_pwd, HttpServletRequest request, HttpServletResponse response) {

        int admin = adminBiz.adminchangepwd(ad_name, ad_password, new_pwd);
        List<String> list = new ArrayList<String>();
        list.add("修改密码");
        ListObject listObject = new ListObject();
        listObject.setData(list);
        if (admin < 1) {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setDesc("修改失败");
        } else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setDesc("修改成功");
        }


        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
    }


}
