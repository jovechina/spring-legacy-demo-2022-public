package com.jove.demo.models;

import java.util.Date;

public class Estimation {

	private int estimationId;
	private int userId;
	private String userName;
	private int roomId;
	private String roomType;
	private String interiorDecoration;	
	private String paintWall;
	private String ceiling;
	private String wires;
	private String cable;
	private String floor;
	private String walltiles;
	private String tile;
	private String kitchenCabinet;
	private String rangeHood;
	private String waterPipe;
	private Date createDate;
	private Date updateDate;

	public int getEstimationId() {
		return estimationId;
	}
	public void setEstimationId(int estimationId) {
		this.estimationId = estimationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getInteriorDecoration() {
		return interiorDecoration;
	}
	public void setInteriorDecoration(String interiorDecoration) {
		this.interiorDecoration = interiorDecoration;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getPaintWall() {
		return paintWall;
	}
	public void setPaintWall(String paintWall) {
		this.paintWall = paintWall;
	}
	public String getCeiling() {
		return ceiling;
	}
	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
	}
	public String getWires() {
		return wires;
	}
	public void setWires(String wires) {
		this.wires = wires;
	}
	public String getCable() {
		return cable;
	}
	public void setCable(String cable) {
		this.cable = cable;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getWalltiles() {
		return walltiles;
	}
	public void setWalltiles(String walltiles) {
		this.walltiles = walltiles;
	}
	public String getTile() {
		return tile;
	}
	public void setTile(String tile) {
		this.tile = tile;
	}
	public String getKitchenCabinet() {
		return kitchenCabinet;
	}
	public void setKitchenCabinet(String kitchenCabinet) {
		this.kitchenCabinet = kitchenCabinet;
	}
	public String getRangeHood() {
		return rangeHood;
	}
	public void setRangeHood(String rangeHood) {
		this.rangeHood = rangeHood;
	}
	public String getWaterPipe() {
		return waterPipe;
	}
	public void setWaterPipe(String waterPipe) {
		this.waterPipe = waterPipe;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
}
