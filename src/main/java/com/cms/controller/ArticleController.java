package com.cms.controller;

import com.cms.entity.Article;
import com.cms.service.ArticleService;
import com.cms.util.ExecuteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ykz on 2017/4/5
 */
@Controller
@RequestMapping("/")
public class ArticleController {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章数据并且跳转index页面
     *
     * @param request
     * @param model
     * @param article
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model, Article article) {

        List<Article> articleList = articleService.selectArticleAll(article);
        model.addAttribute("articleList", articleList);
        return "index";
    }

    @RequestMapping("/")
    public String ueditor(HttpServletRequest request, Model model, Article article) {
        List<Article> articleList = articleService.selectArticleAll(article);
        model.addAttribute("articleList", articleList);
        return "index";
    }

    /**
     * 获取唯一的文章信息 跳转到详细页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/articleDetail")
    public String articleDetail(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return "error/404";
        }
        Article article = articleService.selectByPrimaryKey(Integer.parseInt(id));
        model.addAttribute("article", article);
        return "articleDetail";
    }

    /**
     * 将前台传输到后台的数据，更新到数据库中
     *
     * @param request
     * @param article
     * @return
     */
    @RequestMapping("/api/articleUpdate")
    @ResponseBody
    public ExecuteResult<Article> apiArticleUpdate(HttpServletRequest request, Article article) {
        ExecuteResult executeResult = new ExecuteResult();

        if (StringUtils.isEmpty(article.getTitle())) {
            executeResult.addErrorMessage("标题不可为空!");
            return executeResult;
        }
        if (StringUtils.isEmpty(article.getInfo())){
            executeResult.addErrorMessage("内容不可为空!");
            return executeResult;
        }
        if (StringUtils.isEmpty(article.getImage())){
            executeResult.addErrorMessage("请上传图片!");
            return executeResult;
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (article.getUpdateTime() == "" || null == article.getUpdateTime()) {
                article.setTime(new Date());
            } else {
                article.setTime(format.parse(article.getUpdateTime()));
            }
            article.setStats("Y");
        } catch (ParseException e) {
            logger.error("ParseException", e);
        }

        executeResult = articleService.updateByPrimaryKeySelective(article);
        return executeResult;
    }

    /**
     * 保存文章到数据库中
     *
     * @param request
     * @param article
     * @return
     */
    @RequestMapping("/api/articleAdd")
    @ResponseBody
    public ExecuteResult<Article> apiArticleAdd(HttpServletRequest request, Article article) {
        ExecuteResult executeResult = new ExecuteResult();

        if (StringUtils.isEmpty(article.getTitle())) {
            executeResult.addErrorMessage("标题不可为空!");
            return executeResult;
        }
        if (StringUtils.isEmpty(article.getInfo())){
            executeResult.addErrorMessage("内容不可为空!");
            return executeResult;
        }
        if (StringUtils.isEmpty(article.getImage())){
            executeResult.addErrorMessage("请上传图片!");
            return executeResult;
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (article.getUpdateTime() == "" || null == article.getUpdateTime()) {
                article.setTime(new Date());
            } else {
                article.setTime(format.parse(article.getUpdateTime()));
            }
            article.setStats("Y");
        } catch (ParseException e) {
            logger.error("ParseException", e);
        }

        executeResult = articleService.articleAdd(article);
        return executeResult;
    }

}
