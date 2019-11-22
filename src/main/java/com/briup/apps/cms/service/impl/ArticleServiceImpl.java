package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Override
	public List<Article> findAll() {
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public List<ArticleExtend> categoryFindAll() {
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id);
	}

	@Override
	public void saveOrUpdate(Article article) {
		if(article.getId()!=null) {
			System.out.println(article.getContent()+"00000");
			//更新
			articleMapper.updateByPrimaryKey(article);
		}else {
			//标题不能重名
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			
			List<Article> articles = articleMapper.selectByExample(example);
			if(articles.size()>0) {
				throw new CustomerException("标题不能重复");
			}
			
			//初始化
			//发布时间
			article.setPublishTime(new Date().getTime());
			//设计状态
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			//点赞数
			article.setThumbDown(0L);
			article.setThumbUp(0L);
			articleMapper.insert(article);
		}
	}

}













