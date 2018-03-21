package ${packageStr};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ${importStr};
import ${importMapperStr};
import ${intefaceImportStr};
/**
 * 
 * ${entityDesc}Dao
 * 
 * ${author} 	1.0  		${time} 	Created
 *
 */
@Repository
public class ${className} implements ${interfaceClassName}{
    
    @Autowired
	${autowiredMapperClass} ${autowiredMapperName};
    
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