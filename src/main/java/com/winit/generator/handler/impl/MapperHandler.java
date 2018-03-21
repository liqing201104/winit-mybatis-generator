package com.winit.generator.handler.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import com.winit.generator.config.Constants;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.MapperInfo;

public class MapperHandler extends BaseHandler<MapperInfo> {
    public MapperHandler(String ftlName, MapperInfo info) {
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Constants.LOCAL_PATH 
                + File.separator + "mapper"
                + File.separator + info.getClassName() + ".java";
        
    }
    
    @Override
    public void combileParams(MapperInfo info) {
      //<result column="SU_ROUTE_CODE" jdbcType="VARCHAR" property="suRouteCode" />
    	
    	this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("className", info.getClassName());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
    	
        this.param.put("entityType", info.getEntityInfo().getPackageClassName());
        this.param.put("tableName", info.getEntityInfo().getTableName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        
        StringBuilder baseColumn = new StringBuilder();
        StringBuilder insertBatchColumns = new StringBuilder();
        StringBuilder insertBatchProps = new StringBuilder();
        StringBuilder updateBatchColProps = new StringBuilder();
        //resultMap
        Map<String, String> propJdbcTypes = info.getEntityInfo().getPropJdbcTypes();
        for (Entry<String, String> entry : info.getEntityInfo().getPropNameColumnNames().entrySet()) {
            String propName = entry.getKey();
            String columnName = entry.getValue();
            
            if (!("id".equals(propName))) {
                if ((!("created".equals(propName))) && !("createdby".equals(propName))) {
                    /**
                     * <if test="isDelete != null">
                        IS_DELETE = #{item.isDelete,jdbcType=VARCHAR},
                      </if>
                     */
                    updateBatchColProps.append("        \"<if test=\\\"item.").append(propName).append(" != null\\\">\",\r\n          ")//
                    .append("\"").append(columnName).append("=#{item.").append(propName).append(",jdbcType=").append(propJdbcTypes.get(propName)).append("},\",\r\n")
                    .append("        \"</if>\",\r\n");
                }
               
            }
            baseColumn.append(columnName).append(",");
            
            if (!("updated".equals(propName)) && !("updatedby".equals(propName))) {
                insertBatchColumns.append(columnName).append(",");
                
                /**
                 * #{item.id,jdbcType=BIGINT},
                 */
                insertBatchProps.append("#{item.")
                .append(propName).append(",jdbcType=").append(propJdbcTypes.get(propName)).append("},");
            }
            
        }
        this.param.put("baseColumn", baseColumn.substring(0, baseColumn.length() - 1).toLowerCase());
        this.param.put("insertBatchColumns", insertBatchColumns.substring(0, insertBatchColumns.length() - 1).toLowerCase());
        this.param.put("insertBatchProps", insertBatchProps.substring(0, insertBatchProps.length() - 1));
        this.param.put("updateBatchColProps", updateBatchColProps.toString());
    }

}
