package cn.test.pojo.po;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import sun.font.TrueTypeFont;

@Accessors(chain = true)
@Data
public class Order {

	private Integer id;
	private String name;
	private Integer count;
	private Double price;

	public static List<Order> fakers() {
		List<Order> list = new LinkedList<Order>();
		int num = (int) (Math.random() * 50);
		for (int i = 0; i < num; i++) {
			list.add(Order.faker(i));
		}
		return list;
	}

	public static Order faker(Integer id) {
		Order order = new Order();
		Integer count = (int) (Math.random() * 100);
		Double price = Math.random() * 200;
		return order.setId(id).setName("item-" + id).setCount(count).setPrice(price);
	}

}
