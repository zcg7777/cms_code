package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;

/**
 * 
 * @ClassName: ArticleExtend
 * @Description: 文章的扩展类
 * @Author 张晨光
 * @DateTime 2019年11月15日 上午11:08:32
 */
public class ArticleExtend extends Article{
	public static final String STATUS_UNCHECK="未审核";
	public static final String STATUS_CHECK_PASS="审核通过";
	public static final String STATUS_CHECK_NOPASS="审核未通过";

	private Category category;
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
