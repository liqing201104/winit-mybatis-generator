package ${packageStr};

import java.util.List;

import ${importStr};

/**
 * 
 * ${entityDesc}Dao
 * 
 * ${author} 	1.0  	${time} 	Created
 *
 */
public interface ${interfaceClassName} {
    
    Long insertBatch(List<${entityClassName}> list);
    
    long updateBatch(List<${entityClassName}> list);
    
    long deleteBatch(List<${entityClassName}> list);
    
    List<${entityClassName}> findList(List<${entityClassName}> searchable);
    
    ${entityClassName} get${entityName}(${entityClassName} entity);
}