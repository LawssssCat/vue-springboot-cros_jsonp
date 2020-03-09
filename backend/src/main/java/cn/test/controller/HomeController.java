package cn.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.test.pojo.po.Home;
import cn.test.service.HomeService;
import cn.test.utils.JsonResult;

@RequestMapping("/home")
@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	@GetMapping("/multidata")
	public JsonResult getMultidata(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(name = "type", defaultValue = "CD", required = false) String type) {
		Home multidata = homeService.getMultidata(page, type);
		return JsonResult.ok(multidata);
	}

}
