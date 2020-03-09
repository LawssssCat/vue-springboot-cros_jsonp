package cn.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.common.vo.Page;
import cn.test.pojo.po.Home;
import cn.test.pojo.po.Item;

@Service
public class HomeService {

	@Autowired
	private OrderService orderService;  
	
	public Home getMultidata(Integer pageCurrent, String type) {
		Page<Item> page = orderService.getPage(pageCurrent, 10, type); 
		String title = type+"-"+pageCurrent;
		String url = "https://files.catbox.moe/op6a2l.jpg";
		return new Home(title, page, url) ; 
	}
	
	
}
