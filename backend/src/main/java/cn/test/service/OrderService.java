package cn.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.common.vo.Page;
import cn.test.pojo.po.Item;

@Service
public class OrderService {

	@Autowired
	private ItemService itemService;

	public Page<Item> getPage(Integer pageCurrent, Integer pageSize , String type ) {
		List<Item> items = itemService.getItems(pageCurrent, pageSize, type);
		Integer countTotal = itemService.getCountTotal();
		return new Page<Item>(items, pageCurrent, pageSize, countTotal ) ;
	}
}
