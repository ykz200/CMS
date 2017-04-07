package com.cms.dao;


import com.cms.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 获取ARTICLE 所有数据
     * @param article
     * @return
     */
    List<Article> selectArticleAll(Article article);
}