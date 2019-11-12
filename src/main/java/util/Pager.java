package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页的页数据类
 * 泛型编程
 * @author s
 *
 */
public class Pager<T> extends ArrayList<T>{
	
	private List<T> data;    //数据
	private int total;		//总页数
	
	
	public Pager(List<T> data, int total) {
		super();
		this.data = data;
		this.total = total;
	}
	public Pager() {
		super();
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
