#namespace("blog")
  #sql("searchBlog")
    select * from blog order by id
  #end
   #sql("searchBlogById")
    select * from blog where id = #para(id) order by id
  #end
  #sql("test")
    select RPAD(UNIX_TIMESTAMP(NOW()),13,rand_num(0,999))from dual
  #end
#end