package ${packageStr};

import java.io.Serializable;
${importStr}

/**
 * ${entityDesc}实体
 * 
 * ${author} 	1.0  ${time} Created
 *
 */
public class ${className} implements Serializable {
    private static final long serialVersionUID = 1L;
    
${propertiesStr}
${methodStr}
}