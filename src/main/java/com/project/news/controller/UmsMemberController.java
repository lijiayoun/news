package com.project.news.controller;

import com.project.news.beans.UmsMember;
import com.project.news.service.UmsMemberService;
import com.project.news.util.*;
import com.project.news.vo.AdminPo;
import com.project.news.vo.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UmsMemberController {

    public static Map<Token, UmsMember> map = new HashMap<Token, UmsMember>();

    @Autowired
    UmsMemberService umsMemberService;

    @CrossOrigin /*可以处理跨域请求，让你能访问不是一个域的文件。*/
    @ResponseBody  /*将响应的数据转化为json类型*/
    @RequestMapping("/user/login")
    public JsonResponse<Token> umsLogin(@RequestBody/*表明传入的是json数据*/ AdminPo adminPo) {

        UmsMember umsMember = umsMemberService.queryAdminByName(adminPo);
        if (umsMember != null) {
            JsonResponse<Token> jsonData = new JsonResponse<Token>();
            jsonData.setMessage("登陆成功！");
            for (Map.Entry<Token, UmsMember> entry : map.entrySet()) {
                if (umsMember.equals(entry.getValue())) {
                    jsonData.setData(entry.getKey());
                    return jsonData;
                }
            }
            Token token=new Token();
            jsonData.setData(token);
            map.put(token,umsMember);
            return jsonData;
        }


        return null;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/user/info")
    public JsonResponse<UmsInfo> umsInfo(@RequestHeader("authorization") /*将我们的请求头的值绑定到参数上*/String account) {
        if (account != null) {
            for (Token token : map.keySet()) {
                if (account.contains(token.getToken())) {
                    JsonResponse<UmsInfo> json = new JsonResponse<UmsInfo>();
                    json.setMessage("获取用户信息");

                    UmsMember umsMember=map.get(token);

                    UmsInfo umsInfo=new UmsInfo();
                    umsInfo.setName(umsMember.getUsername());
                    umsInfo.setAvatar(umsMember.getIcon());
                    umsInfo.setNickName(umsMember.getNickname());
                    umsInfo.setRoles(new String[]{"admin"});
                    json.setData(umsInfo);
                    return json;
                }
            }
        }
        return null;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/profile/info/{username}")
    public JsonResponse<UserAdmin> ShowUserDetail(@PathVariable("username")String username){

        UmsMember umsMember=umsMemberService.queryUserByName(username);
        UserAdmin userAdmin=new UserAdmin();
        userAdmin.setId(umsMember.getId());
        userAdmin.setIcon(umsMember.getIcon());
        userAdmin.setUsername(umsMember.getEmail());
        userAdmin.setEmail(umsMember.getEmail());
        userAdmin.setNickName(umsMember.getNickname());
        userAdmin.setNote(umsMember.getPersonalizedSignature());
        userAdmin.setCreateTime(umsMember.getCreateTime());
        userAdmin.setLoginTime(umsMember.getLoginTim());
        userAdmin.setStatus(umsMember.getStatus());

        JsonResponse<UserAdmin> jsonData=new JsonResponse<UserAdmin>();
        jsonData.setMessage("成功");
        jsonData.setData(userAdmin);
        return jsonData;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/profile/update")
    public JsonResponse<UserAdmin> ModifyUserInfo(@RequestBody UserAdmin userAdmin){
        System.out.println("111111111");
        umsMemberService.modifyUserInfo(userAdmin);

        JsonResponse<UserAdmin> jsonData=new JsonResponse<UserAdmin>();
        jsonData.setMessage("成功");
        jsonData.setData(userAdmin);
        System.out.println(userAdmin.getNickName());
        return jsonData;
    }
}
