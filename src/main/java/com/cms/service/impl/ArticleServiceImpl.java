package com.cms.service.impl;

import com.cms.dao.ArticleMapper;
import com.cms.entity.Article;
import com.cms.service.ArticleService;

import com.cms.util.ExecuteResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ykz on 2017/4/5.
 */
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

 
    public List<Article> selectArticleAll(Article article) {

        return articleMapper.selectArticleAll(article);
    }


    public Article selectByPrimaryKey(int id) {

        return articleMapper.selectByPrimaryKey(id);
    }

    public ExecuteResult<Article> updateByPrimaryKeySelective(Article article) {
        ExecuteResult<Article> executeResult = new ExecuteResult<Article>();
        int i =  articleMapper.updateByPrimaryKeySelective(article);
         if (i <= 0) {
             executeResult.addErrorMessage("更新失败！");
         }
        return executeResult;
    }

    public ExecuteResult articleAdd(Article article) {
        ExecuteResult<Article> executeResult = new ExecuteResult<Article>();
        int i =  articleMapper.insert(article);
        if (i <= 0) {
            executeResult.addErrorMessage("新增失败！");
        }
        return executeResult;
    }
}
