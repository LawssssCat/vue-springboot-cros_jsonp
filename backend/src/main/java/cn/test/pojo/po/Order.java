package cn.test.pojo.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Order {

	private Integer id;
	private String name;
	private Integer count;
	private Double price;

}
