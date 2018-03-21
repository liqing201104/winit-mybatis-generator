package com.winit.generator.model;


public class MapperInfo {
    
	/**
     * 包路径
     */
    private String packageStr;
    
    /**
     * 需要导入的包
     */
    private String importStr;
    
    /**
     * 类名（类名）
     */
    private String className;
	
    
    private DaoInterfaceInfo daoInfo;
    
    private EntityInfo entityInfo;

    public DaoInterfaceInfo getDaoInfo() {
        return daoInfo;
    }

    
    public void setDaoInfo(DaoInterfaceInfo daoInfo) {
        this.daoInfo = daoInfo;
    }

    
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


	public String getImportStr() {
		return importStr;
	}


	public void setImportStr(String importStr) {
		this.importStr = importStr;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}
}
