package cn.test.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

	private Integer id;
	private String name;
	private String type ; 
	private Integer count;
	private Double price;
	private String content;
	private String url;
	
}
