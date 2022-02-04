package com.jove.demo.models;

import java.util.List;

public class RoomService {
	
	private int serviceId;
	private int categoryId;
	private String serviceName;
	private String serviceShortName;
	private List<RoomProduct> roomProducts;
	
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceShortName() {
		return serviceShortName;
	}
	public void setServiceShortName(String serviceShortName) {
		this.serviceShortName = serviceShortName;
	}
	public List<RoomProduct> getRoomProducts() {
		return roomProducts;
	}
	public void setRoomProducts(List<RoomProduct> roomProducts) {
		this.roomProducts = roomProducts;
	}
}
