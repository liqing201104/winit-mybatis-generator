package com.winit.generator.task;

import java.util.ArrayList;
import java.util.List;

import com.winit.generator.config.Constants;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.EntityHandler;
import com.winit.generator.model.EntityInfo;
import com.winit.generator.model.MapperInfo;
import com.winit.generator.model.VoInfo;

public class EntityTask extends AbstractApplicationTask {
    private static String ENTITY_FTL = "template/Entity.ftl";
    
    private List<EntityInfo> entityInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成实体");
        
        //获取实体信息
        entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");
        
        BaseHandler<EntityInfo> handler = null;
        for (EntityInfo entityInfo : entityInfos) {
            handler = new EntityHandler(ENTITY_FTL, entityInfo);
            handler.execute();
        }
        logger.info("生成实体类完成");
        return false;
    }
    
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
        
        List<MapperInfo> mapperInfos = new ArrayList<MapperInfo>();
        List<VoInfo> voList = new ArrayList<VoInfo>();

        //组装Dao信息、组装Vo信息
        MapperInfo mapperInfo = null;
        VoInfo voInfo = null;
        for (EntityInfo entityInfo : entityInfos) {
        	
            mapperInfo = new MapperInfo();
            mapperInfo.setEntityInfo(entityInfo);
            mapperInfo.setPackageStr(Constants.MAPPER_PACKAGE);
            
            mapperInfos.add(mapperInfo);
            
            voInfo = new VoInfo();
            voInfo.setPackageStr(Constants.VO_PACKAGE);
            voInfo.setEntityInfo(entityInfo);
            voList.add(voInfo);
        }
        
        context.setAttribute("mapperInfos", mapperInfos);
        context.setAttribute("voList", voList);
        
    }
}
