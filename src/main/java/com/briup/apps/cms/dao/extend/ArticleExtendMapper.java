package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.extend.ArticleExtend;
/**
 * 
 * @ClassName: AriticleExtendMapper
 * @Description: Article dao层扩展接口
 * @Author zhangcg
 * @DateTime 2019年11月15日 上午11:27:17
 */
public interface ArticleExtendMapper {

	List<ArticleExtend> selectAll();
	
	ArticleExtend selectById(long id);
}
