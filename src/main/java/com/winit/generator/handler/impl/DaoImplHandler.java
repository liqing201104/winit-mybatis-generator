package com.winit.generator.handler.impl;

import java.io.File;

import com.winit.generator.config.Constants;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoImplInfo;


public class DaoImplHandler extends BaseHandler<DaoImplInfo> {
	
	
    public DaoImplHandler(String ftlName, DaoImplInfo info) {
    	this.entityName = info.getEntityInfo().getEntityName();
        this.ftlName = ftlName;
        this.info = info;
		this.savePath = Constants.LOCAL_PATH 
				+ File.separator + "dao"
				+ File.separator + "impl"
                + File.separator + this.entityName + "DaoImpl.java";
        
    }
    
    @Override
    public void combileParams(DaoImplInfo info) {
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        
        String mapperClassName = this.entityName.substring(0, 1).toLowerCase() + this.entityName.substring(1) + "Mapper";
        
        this.param.put("autowiredMapperName", mapperClassName);
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        this.param.put("basePath", Constants.PACKAGE_PREFIX);
    }

}
