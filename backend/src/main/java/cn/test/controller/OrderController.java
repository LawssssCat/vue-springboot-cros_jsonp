package cn.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.test.common.vo.Page;
import cn.test.pojo.po.Item;
import cn.test.service.OrderService;
import cn.test.utils.JsonResult;

@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/data")
	public JsonResult getDataPage(@RequestParam(name = "type", defaultValue = "phone", required = false) String type,
			@RequestParam(name = "page", defaultValue = "1", required = false) Integer pageCurrent,
			@RequestParam(name = "size", defaultValue = "10", required = false) Integer pageSize) {
		Page<Item> page = orderService.getPage(pageCurrent, pageSize, type);
		return JsonResult.ok(page);
	}
}
