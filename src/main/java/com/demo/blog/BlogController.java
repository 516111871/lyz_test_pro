package com.demo.blog;

import com.demo.common.model.Blog;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;

import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */

/**
 * blog
 * @author jjh
 * @date 2019年5月29日11:30:09
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	
	@Inject
	BlogService service;
	
	public void index(Integer id) {
	//	List<Record> testsql = Db.find(sqlpa);
	//	System.err.println("test----------"+sqlpa);
	//	System.err.println("test----------"+testsql);
			setAttr("blogPage", service.paginate(getParaToInt(0, 1), 3,id));
			render("/page/blog/blog.html");

	}


	public void add() {
		render("/page/blog/add.html");
	}
	

	 @Before(BlogValidator.class)
	public void save() {
		service.saveBlog(getBean(Blog.class));
		redirect("/blog");
	}
	
	public void edit(int id) {
		setAttr("blog", service.findById(id));
		render("/page/blog/edit.html");
	}
	
	@Before(BlogValidator.class)
	public void update() {
		service.updateBlog(getBean(Blog.class));
		redirect("/blog");
	}
	
	public void delete(int id) {
		service.deleteById(id);
		redirect("/blog");
	}

	public void test(){
	    String sql = Db.getSql("blog.searchBlog");
	    renderText(sql);

    }


    /**
     * demo方法
     * @param str 参数1
     * @param integer 参数2
     */
    public void demo(String str,Integer integer){
        String newStr = service.demo(str,integer);
    }
}


