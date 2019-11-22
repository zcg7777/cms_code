package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: ArticleController
 * @Description: 文章控制器类
 * @Author zhangcg
 * @DateTime 2019年11月15日 上午10:31:24
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;

	@ApiOperation(value = "查询所有文章")
	@GetMapping("findAll")
	public Message findAll() {
		List<Article> list = articleService.findAll();
		return MessageUtil.success("scusess", list);
	}

	@ApiOperation(value = "级联查询文章", notes = "级联所属栏目，作者")
	@GetMapping("categoryFindAll")
	public Message categoryFindAll() {
		List<ArticleExtend> list = articleService.categoryFindAll();
		return MessageUtil.success("scusess", list);
	}

	/*
	 * @ApiOperation给swager添加描述信息
	 */
	@ApiOperation(value = "通过id查询")
	@ApiImplicitParams(@ApiImplicitParam(name = "id", value = "文章主键", paramType = "query"))
	// 需要指定前端传递数据回来为字符串格式，因为get方式，参数格式一定是查询字符串。
	@GetMapping("findById")
	public Message findById(long id) {
		ArticleExtend articleExtend = articleService.findById(id);
		return MessageUtil.success("scusess", articleExtend);
	}

	@ApiOperation(value = "保存或更新文章信息", notes = "如果参数中包含id后端认为是更新操作；如果参数中不包含id认为是插入操作")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "id", value = "编号", paramType = "form", required = false),
			@ApiImplicitParam(name = "title", value = "标题", paramType = "form", required = true),
			@ApiImplicitParam(name = "content", value = "内容", paramType = "form", required = true),
			@ApiImplicitParam(name = "source", value = "源内容", paramType = "form", required = false),
			@ApiImplicitParam(name = "categoryId", value = "所属栏目id", paramType = "form", required = true),
			@ApiImplicitParam(name = "authorId", value = "所属作者id", paramType = "form", required = false) 
			}

	)
	@PostMapping("saveOrUpdate")
	// 这里不能接受对象，因为需要在swagger指定必选项和有效内容
	public Message saveOrUpdate(Long id, String title, String content, String source, long categoryId, Long authorId) {
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setCategoryId(categoryId);
		article.setAuthorId(authorId);

		articleService.saveOrUpdate(article);
		return MessageUtil.success("success");
	}

}
