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
                + File.separator + info.getInterfaceClassName() + ".java";
        
    }
    
    @Override
    public void combileParams(DaoInterfaceInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("interfaceClassName", info.getInterfaceClassName());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
    }

}
