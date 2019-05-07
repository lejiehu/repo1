package com.itheima;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCdruid {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getdatasource());

    @Test
    public void test() {
        //创建Tem对象对象
        String sql = "update emp set salary= ? where id = ?";
        int update = template.update(sql, 18000, 1007);
        System.out.println(update);
    }

    //查
    @Test
    public void test1() {
        String sql = "select * from dept";
        List<Dept> list = template.query(sql, new BeanPropertyRowMapper<>(Dept.class));
        for (Dept dept : list) {
            System.out.println(dept);
        }
    }

    @Test
    public void test2() {
        String sql = "select * from dept WHERE id = ?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 10);
        System.out.println(stringObjectMap);
    }

    @Test
    public void test3() {
        String sql = "select * from dept ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test4() {
        String sql = "select count(id) from dept ";
        Long l = template.queryForObject(sql, Long.class);
        System.out.println(l);
    }
}

