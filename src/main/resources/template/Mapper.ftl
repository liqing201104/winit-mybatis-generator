package ${packageStr};

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import ${importStr};


public interface ${className} {

  // 基本列 
  String baseColumn = "${baseColumn}";
  
  @Insert({
    "<script>",
      "INSERT INTO ${tableName}",
        "(${insertBatchColumns})",
      "VALUES",
      "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">",
         "(${insertBatchProps})",
      "</foreach>",
    "</script>"
  })
  Long insertBatch(@Param("list")List<${entityClassName}> list);
  
  // 批量更新 
  @Update({
   "<script>",
      "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\";\">  ",
          "UPDATE ${tableName}",
          "<set>",
  		  ${updateBatchColProps}
          "</set>",
          "WHERE ID = <#noparse>#{item.id,jdbcType=BIGINT}</#noparse>",
      "</foreach> ",
    "</script>"
  })
  long updateBatch(@Param("list")List<${entityClassName}> list);
  
  
  // 批量删除 
  @Update({
   "<script>",
      "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\";\">  ",
          "update ${tableName}",
          "set UPDATED = <#noparse>#{item.updated,jdbcType=TIMESTAMP}</#noparse>,UPDATEDBY = <#noparse>#{item.updatedby,jdbcType=VARCHAR}</#noparse>, IS_DELETE = 'Y'",
          "where ID = <#noparse>#{item.id,jdbcType=BIGINT}</#noparse>",
      "</foreach>",
    "</script>"
  })
  long deleteBatch(@Param("list")List<${entityClassName}> list);
  
  // 分页查询 
  @Select({
    "<script>",
      "SELECT",
        baseColumn,
      "FROM ${tableName} ",
    "</script>"
  })
  List<${entityClassName}> findList(List<${entityClassName}> searchable);
  
  // 单个查询 
  @Select({
    "<script>",
      "SELECT",
        baseColumn,
      "FROM ${tableName} ",
      "WHERE IS_DELETE = 'N'",
      "<if test=\"id != null\">",
        "AND id = <#noparse>#{id, jdbcType=BIGINT}</#noparse>",
      "</if>",
    "</script>"
  })
  ${entityClassName} get${entityName}(${entityClassName} entity);
}
