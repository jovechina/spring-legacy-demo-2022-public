package com.jove.demo.models;

import java.util.List;

public class RoomCategory {
	
	private int categoryId;
	private String categoryName;
	private List<RoomService> roomServices;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<RoomService> getRoomServices() {
		return roomServices;
	}
	public void setRoomServices(List<RoomService> roomServices) {
		this.roomServices = roomServices;
	}
}
