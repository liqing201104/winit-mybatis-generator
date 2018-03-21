package ${basePath}.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ${basePath}.entity.${entityName}Entity;
import ${basePath}.mapper.${entityName}Mapper;
import ${basePath}.dao.I${entityName}Dao;
/**
 * 
 * ${entityDesc}Dao
 * 
 * ${author} 	1.0  		${time} 	Created
 *
 */
@Repository
public class ${entityName}DaoImpl implements I${entityName}Dao {
    
    @Autowired
	${entityName}Mapper ${autowiredMapperName};
    
    public Long insertBatch(List<${entityClassName}> list) {
    	return ${autowiredMapperName}.insertBatch(list);
    }
    
    public long updateBatch(List<${entityClassName}> list) {
    	return ${autowiredMapperName}.updateBatch(list);
    }
    
    public long deleteBatch(List<${entityClassName}> list) {
    	return ${autowiredMapperName}.deleteBatch(list);
    }
    
    public List<${entityClassName}> findList(List<${entityClassName}> list) {
    	return ${autowiredMapperName}.findList(list);
    }
    
    public ${entityClassName} get${entityName}(${entityClassName} entity) {
    	return ${autowiredMapperName}.get${entityName}(entity);
    }
}