package ${basePath}.vo;

import java.io.Serializable;
${importStr}

/**
 * 
 * ${entityDesc}vo
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
public class ${entityName}VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
${propertiesStr}
${methodStr}
}