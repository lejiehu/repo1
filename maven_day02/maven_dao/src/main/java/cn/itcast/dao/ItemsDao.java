package cn.itcast.dao;

import cn.itcast.domain.Items;
import org.apache.ibatis.annotations.Select;


public interface ItemsDao {



    //查询

    @Select("select * from items where id = #{id}")
    Items findbyid(Integer id);

}
