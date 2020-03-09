package cn.test.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class Page<T> {

	private List<T> data;
	private Integer pageCurrent = 1;
	private Integer pageSize = 10;
	private Integer pageTotal = 1;
	private Integer countTotal = 0;

	public Page(List<T> data, Integer pageCurrent, Integer pageSize, Integer countTotal) {
		this.data = data;
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.countTotal = countTotal;
		this.countTotal = (countTotal - 1) / pageSize + 1;
	}
}
