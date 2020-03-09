package cn.test.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.runtime.internal.CFlowCounter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.test.pojo.po.Item;

@Service
public class ItemService {

	static List<Item> items;

	static {
		String[] imgs = { "https://i.loli.net/2020/02/04/Gr5KnVaTeRPOdNY.jpg",
				"https://i.loli.net/2020/02/04/5q7uRyFhKrsJBNL.jpg",
				"https://catbox.moe/pictures/qts/14350958102351.png" };
		String[] types = { "phone", "book", "computer", "clothing", "daily-supply", "adult", "CD", "virtual" };
		items = new LinkedList<Item>() ;
		int num = 1000;
		for (int i = 0; i < num; i++) {
			Integer id = i;
			String name = "item-" + i;
			String type = types[i % types.length];
			name += "_" + type;
			Integer count = i * 2;
			Double price = i * 10 / 3.1;
			String content = "item-content-" + i;
			String url = imgs[i % imgs.length];
			Item item = new Item(id, name, type, count, price, content, url);
			items.add(item);
		}
	}

	public List<Item> getItems(Integer startIndex, Integer limit, String type) {
		List<Item> list;
		if (StringUtils.isEmpty(type)) {
			list = items;
		} else {
			list = new LinkedList<Item>();
			for (Item item : items) {
				if (type.equals(item.getType())) {
					list.add(item);
				}
			}
		}
		Integer cor = list.size() -  startIndex; 
		if(cor<=0) return null ; 
		if(cor<=limit) return list.subList(startIndex, startIndex + cor);
		return list.subList(startIndex, startIndex + limit);
	}

	public Integer getCountTotal() {
		return items.size();
	}

}
