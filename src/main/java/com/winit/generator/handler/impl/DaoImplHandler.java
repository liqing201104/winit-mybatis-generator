package com.winit.generator.handler.impl;

import java.io.File;

import com.winit.generator.config.Constants;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoImplInfo;


public class DaoImplHandler extends BaseHandler<DaoImplInfo> {
    public DaoImplHandler(String ftlName, DaoImplInfo info) {
        this.ftlName = ftlName;
        this.info = info;
		this.savePath = Constants.LOCAL_PATH 
				+ File.separator + "dao"
				+ File.separator + "impl"
                + File.separator + info.getClassName() + ".java";
        
    }
    
    @Override
    public void combileParams(DaoImplInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("importMapperStr", info.getImportMapperStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("className", info.getClassName());
        
        String mapperClass = info.getAutowiredMapperClass();
        this.param.put("autowiredMapperClass", mapperClass);
        
        String mapperClassName = mapperClass.substring(0, 1).toLowerCase() + mapperClass.substring(1);
        
        this.param.put("autowiredMapperName", mapperClassName);
        this.param.put("interfaceClassName", info.getInterfaceClassName());
        this.param.put("intefaceImportStr", info.getIntefaceImportStr());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
    }

}
