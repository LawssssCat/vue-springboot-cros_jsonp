package cn.test.pojo.po;

import java.util.UUID;

import cn.test.common.vo.Page;
import lombok.Data;

@Data
public class Home {

	private String id;
	private String title;
	private Page page;
	private String url;

	public Home(String title , Page page, String url   ) {
		this.title = title ; 
		this.page = page ; 
		this.url = url ; 
		
		String  name = title + url  ;
		this.id = UUID.nameUUIDFromBytes(name.getBytes() ).toString()  ; 
	}
}
