package com.winit.generator.handler.impl;

import java.io.File;

import com.winit.generator.config.Constants;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoInterfaceInfo;


public class DaoHandler extends BaseHandler<DaoInterfaceInfo> {
    public DaoHandler(String ftlName, DaoInterfaceInfo info) {
        this.ftlName = ftlName;
        this.info = info;
		this.savePath = Constants.LOCAL_PATH 
				+ File.separator + "dao"
                + File.separator + "I"+ info.getEntityInfo().getEntityName() + "Dao.java";
        
    }
    
    @Override
    public void combileParams(DaoInterfaceInfo info) {
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        this.param.put("basePath", Constants.PACKAGE_PREFIX);
    }

}
