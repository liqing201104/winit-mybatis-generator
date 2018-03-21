package com.winit.generator.task;

import java.util.ArrayList;
import java.util.List;

import com.winit.generator.config.Constants;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.MapperHandler;
import com.winit.generator.model.DaoImplInfo;
import com.winit.generator.model.DaoInterfaceInfo;
import com.winit.generator.model.MapperInfo;

public class MapperTask extends AbstractApplicationTask {
    private static String MAPPER_FTL = "template/Mapper.ftl";

    private List<MapperInfo> mapperInfo;
    
    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成Mapper");
        
        mapperInfo = (List<MapperInfo>) context.getAttribute("mapperInfos");
        
        List<DaoInterfaceInfo> daoInterfaceInfoList = new ArrayList<>();
        DaoInterfaceInfo daoInterfaceInfo = null;
        
        List<DaoImplInfo> daoImplInfoList = new ArrayList<>();
        DaoImplInfo daoImplInfo = null;
        
        BaseHandler<MapperInfo> handler = null;
        for (MapperInfo mapperInfo : mapperInfo) {
            handler = new MapperHandler(MAPPER_FTL, mapperInfo);
            
            daoInterfaceInfo = new DaoInterfaceInfo();
            daoInterfaceInfo.setEntityInfo(mapperInfo.getEntityInfo());
            daoInterfaceInfo.setImportStr(mapperInfo.getImportStr());
            daoInterfaceInfo.setInterfaceClassName("I"+ mapperInfo.getEntityInfo().getEntityName() + Constants.DAO_SUFFIX);
            daoInterfaceInfo.setPackageStr(Constants.DAO_PACKAGE);
            
            daoInterfaceInfoList.add(daoInterfaceInfo);
            
            
            daoImplInfo = new DaoImplInfo();
            String autowiredMapperName = mapperInfo.getClassName();
            String interfaceClassName = "I" + mapperInfo.getEntityInfo().getEntityName() + Constants.DAO_SUFFIX;
            
            daoImplInfo.setAutowiredMapperClass(autowiredMapperName);
            daoImplInfo.setClassName(mapperInfo.getEntityInfo().getEntityName() + Constants.DAO_SUFFIX + "Impl");
            daoImplInfo.setEntityInfo(mapperInfo.getEntityInfo());
            daoImplInfo.setImportMapperStr(mapperInfo.getPackageStr() + "." + autowiredMapperName);
            daoImplInfo.setImportStr(mapperInfo.getImportStr());
            daoImplInfo.setInterfaceClassName(interfaceClassName);
            daoImplInfo.setPackageStr(Constants.DAO_PACKAGE + ".impl");
            daoImplInfo.setIntefaceImportStr(Constants.DAO_PACKAGE + "." + interfaceClassName);
            
            daoImplInfoList.add(daoImplInfo);
            
            handler.execute();
        }
        
        context.setAttribute("daoInterfaceInfoList", daoInterfaceInfoList);
        context.setAttribute("daoImplInfoList", daoImplInfoList);
        
        logger.info("生成Mapper完成");
        return false;
    }
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
    }
}
