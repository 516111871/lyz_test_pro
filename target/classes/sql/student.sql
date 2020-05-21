#namespace("student")
  #sql("queryByName")
    select * from  student where stuname like concat('%',#para(name),'%')
  #end
#end


