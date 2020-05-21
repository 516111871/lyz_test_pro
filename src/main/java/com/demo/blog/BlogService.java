package com.demo.blog;

import com.demo.common.model.Blog;
import com.demo.common.model.base.TestBlog;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;

import java.util.List;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogService
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
public class BlogService {
	
	/**
	 * 所有的 dao 对象也放在 Service 中，并且声明为 private，避免 sql 满天飞
	 * sql 只放在业务层，或者放在外部 sql 模板，用模板引擎管理：
	 * 			http://www.jfinal.com/doc/5-13
	 */
	private Blog dao = new Blog().dao();


	public Page<Blog> paginate(int pageNumber, int pageSize, Integer id) {
		Kv par = Kv.by("id", id);
		SqlPara sqlpar = Db.getSqlPara("blog.searchBlogById", par);
		if (id==null){
			return dao.paginate(pageNumber, pageSize, "select *", "from blog  order by id asc");
		}else{
			return dao.paginate(pageNumber, pageSize, sqlpar);
		}

	}
	
	public Blog findById(int id) {

		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public void saveBlog(Blog blog){
		blog.save();
	}

	public void updateBlog(Blog blog) {
		blog.update();
	}

	/**
	 * demo方法
	 * @param str 参数1
	 * @param i 参数2
	 * @return 返回值
	 */
	public String demo(String str,Integer i){
		return str;
	}
}
