package cn.itcast.web;


import cn.itcast.domain.Items;
import cn.itcast.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class itemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("find")
    public String findcontroller(Model model){

        Items items = itemsService.findbyid(1);

        model.addAttribute("item",items);

        return "itemDetail";
    }
}
