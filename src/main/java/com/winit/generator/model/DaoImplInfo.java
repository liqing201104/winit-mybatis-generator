package com.winit.generator.model;


public class DaoImplInfo {
    /**
     * 包路径
     */
    private String packageStr;
    
    /**
     * 需要导入的包
     */
    private String importStr;
    
    private String intefaceImportStr;
    private String importMapperStr;
    private String autowiredMapperClass;
    
    /**
     * 类名
     */
    private String className;
    private String interfaceClassName;
    
    
    
    /**
    * 实体信息
    */
    private EntityInfo entityInfo;

    
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

    public String getInterfaceClassName() {
		return interfaceClassName;
	}


	public void setInterfaceClassName(String interfaceClassName) {
		this.interfaceClassName = interfaceClassName;
	}


	public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    
    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }


	public String getImportMapperStr() {
		return importMapperStr;
	}


	public void setImportMapperStr(String importMapperStr) {
		this.importMapperStr = importMapperStr;
	}


	public String getAutowiredMapperClass() {
		return autowiredMapperClass;
	}


	public void setAutowiredMapperClass(String autowiredMapperClass) {
		this.autowiredMapperClass = autowiredMapperClass;
	}

	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getIntefaceImportStr() {
		return intefaceImportStr;
	}


	public void setIntefaceImportStr(String intefaceImportStr) {
		this.intefaceImportStr = intefaceImportStr;
	}
}
