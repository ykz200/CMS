package com.cms.controller;

import com.cms.entity.Article;
import com.cms.entity.User;
import com.cms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kzyuan on 2017/5/17.
 */
@Controller
@RequestMapping("/")
public class UserControler {

    private static Logger logger = LoggerFactory.getLogger(UserControler.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, Article article) {
        return "login";
    }

    @RequestMapping("/api_login")
    public String  apiLogin(HttpServletRequest request, HttpServletResponse response, Model model, User user) {

        User userInfo = new User();
        //userInfo = userService.selectByUser(user);
        userInfo.setUserName("leo@nj-gh.com");
        userInfo.setPassWord("f92452e8d");
        ModelAndView mv = null;
        if(null != userInfo) {

            if (user.getPassWord().equals(userInfo.getPassWord()))  {
                //使用request对象的getSession()获取session，如果session不存在则创建一个
                HttpSession session = request.getSession();
                //将数据存储到session中
                session.setAttribute("user", userInfo);
//                mv = new ModelAndView("/index");//默认为forward模式
                return "index";
//                try {
//                    response.sendRedirect(request.getContextPath() + "/login");
//                } catch (IOException e) {
//                    logger.error("IOException", e);
//                }
            } else {
//                mv = new ModelAndView("/login");//默认为forward模式
                return "login";
            }
        }

        return "login";
    }
}