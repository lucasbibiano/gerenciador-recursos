package pojo;

import java.util.Arrays;

import dal.annotations.Storeable;

@Storeable(tableName = "PlaceResources")
public class PlaceResource extends Resource {
	public String code;
	public int length;
	public int width;
	public int capacity;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(PlaceResource.class.getFields()));
	}
}
