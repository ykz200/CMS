package com.cms.controller;

import com.cms.entity.Article;
import com.cms.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ykz on 2017/4/6.
 */
@Controller
@RequestMapping("/")
public class ManageController {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章数据并且跳转后台 index页面
     *
     * @param request
     * @param model
     * @param article
     * @return
     */
    @RequestMapping("/manage/index")
    public String index(HttpServletRequest request, Model model, Article article) {

        List<Article> articleList = articleService.selectArticleAll(article);
        model.addAttribute("articleList", articleList);
        return "manage/index";
    }

    /**
     * 获取唯一的文章信息 跳转到更新页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/articleUpdate")
    public String articleUpdate(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return "error/404";
        }
        Article article = articleService.selectByPrimaryKey(Integer.parseInt(id));
        model.addAttribute("article", article);
        return "manage/articleEdit";
    }

    /**
     * 跳转到后台新增文章页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/articleAdd")
    public String articleAdd(HttpServletRequest request, Model model) {

        return "manage/articleEdit";
    }
}
