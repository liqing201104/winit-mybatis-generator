package com.winit.generator.task;

import java.util.List;

import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.DaoImplHandler;
import com.winit.generator.model.DaoImplInfo;

public class DaoImplTask extends AbstractApplicationTask {
    private static String DAO_FTL = "template/DaoImpl.ftl";
    
    private List<DaoImplInfo> daoInfos;
    
    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成dao impl");
        
        daoInfos = (List<DaoImplInfo>) context.getAttribute("daoImplInfoList");
        
        BaseHandler<DaoImplInfo> handler = null;
        for (DaoImplInfo daoInfo : daoInfos) {
            handler = new DaoImplHandler(DAO_FTL, daoInfo);
            handler.execute();
        }
        
        logger.info("生成dao impl完成");
        return false;
    }
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
    }

}
