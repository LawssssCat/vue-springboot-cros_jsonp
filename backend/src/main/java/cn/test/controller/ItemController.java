package cn.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.pojo.po.Order;
import cn.test.utils.JsonResult;

@RequestMapping("/item-server")
@RestController
public class ItemController {

	private static List<Order> items;
	static {
		items = Order.fakers() ;
	}

	@GetMapping("/list")
	public JsonResult<List<Order>> getOrderList() {
		return JsonResult.ok(this.items);
	}
	
}
