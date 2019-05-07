package cn.itcast.serviceimpl;

import cn.itcast.dao.ItemsDao;
import cn.itcast.domain.Items;
import cn.itcast.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemsService")
public class ItemsServiceimpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;



    public Items findbyid(Integer id) {

        Items items = itemsDao.findbyid(id);


        return items;
    }
}
