package com.winit.generator.model;

public class MapperInfo {

	/**
	 * 包路径
	 */
	private String packageStr;

	/**
	 * class 类名
	 */
	private String className;

	private EntityInfo entityInfo;

	public EntityInfo getEntityInfo() {
		return entityInfo;
	}

	public void setEntityInfo(EntityInfo entityInfo) {
		this.entityInfo = entityInfo;
	}

	public String getPackageStr() {
		return packageStr;
	}

	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
