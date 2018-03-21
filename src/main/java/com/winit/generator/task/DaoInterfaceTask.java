package com.winit.generator.task;

import java.util.List;

import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.DaoHandler;
import com.winit.generator.model.DaoInterfaceInfo;

public class DaoInterfaceTask extends AbstractApplicationTask {
    private static String DAO_FTL = "template/DaoInterface.ftl";
    
    private List<DaoInterfaceInfo> daoInfos;
    
    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成dao");
        
        daoInfos = (List<DaoInterfaceInfo>) context.getAttribute("daoInterfaceInfoList");
        
        BaseHandler<DaoInterfaceInfo> handler = null;
        for (DaoInterfaceInfo daoInfo : daoInfos) {
            handler = new DaoHandler(DAO_FTL, daoInfo);
            handler.execute();
        }
        
        logger.info("生成dao完成");
        return false;
    }
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
    }

}
