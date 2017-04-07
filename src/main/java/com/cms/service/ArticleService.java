package com.cms.service;

import com.cms.entity.Article;
import com.cms.util.ExecuteResult;

import java.util.List;

/**
 * Created by ykz on 2017/4/5.
 */
public interface ArticleService {

    /**
     * 查询全部数据
     * @return
     */
    List<Article> selectArticleAll(Article article);

    /**
     * 获取详细的文章
     * get article detail
     * @param i
     * @return
     */
    Article selectByPrimaryKey(int i);

    /**
     * 更新文章
     * update article
     * @param article
     */
    ExecuteResult<Article> updateByPrimaryKeySelective(Article article);

    /**
     * 新增文章
     * add article
     * @param article
     * @return
     */
    ExecuteResult articleAdd(Article article);
}
