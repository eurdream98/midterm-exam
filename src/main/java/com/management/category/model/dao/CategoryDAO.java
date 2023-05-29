package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

    // * 주석을 지우고 Mapper interface(= DAO class) 역할을 하도록 내용을 작성하세요.
    // (조건 1) java 어노테이션을 활용하여 CategoryDTO 객체와 PRODUCT_CATEGORY 테이블을 매핑시키는 ResultMap을 작성하세요.
    // (조건 2) java provider어노테이션을 활용하여 작성하세요.
    @Results(id = "CategoryResultMap", value = {
            @Result(id = true, property = "code", column = "PRODUCT_CODE"),
            @Result(property = "name", column = "PRODUCT_NAME"),
            @Result(property = "originCost", column = "ORIGIN_COST"),
            @Result(property = "releaseDate", column = "RELEASE_DATE"),
            @Result(property = "discountRate", column = "DISCOUNT_RATE"),
            @Result(property = "salesQuantity", column = "SALES_QUANTITY"),
            @Result(property = "productionStatus", column = "PRODUCTION_STATUS"),
            @Result(property = "stockQuantity", column = "STOCK_QUANTITY"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE")

            // Add more @Result mappings for other properties
    })
    @Select("SELECT CategoryResultMap\n " +
            "PRODUCT_CODE\n," +
            "PRODUCT_NAME\n," +
            "ORIGIN_COST\n," +"RELEASE_DATE\n," +
            "DISCOUNT_RATE\n," +
            "SALES_QUANTITY\n," +
            "PRODUCTION_STATUS\n," +
            "STOCK_QUANTITY\n," +
            "CATEGORY_CODE\n," +
            "FROM PRODUCT_INFO\n,"
            )
    List<CategoryDTO> selectCategoryList();

    @Insert("INSERT\n" +
            "  INTO PRODUCT_INFO\n" +
            "(\n" +
            "PRODUCT_CODE\n," +
            "PRODUCT_NAME\n," +
            "ORIGIN_COST\n," +"RELEASE_DATE\n," +
            "DISCOUNT_RATE\n," +
            "SALES_QUANTITY\n," +
            "PRODUCTION_STATUS\n," +
            "STOCK_QUANTITY\n," +
            "CATEGORY_CODE\n," +
            ")\n" +
            "VALUES\n" +
            "(\n" +
            "  #{ name }\n" +
            ", #{ price }\n" +
            ", #{ categoryCode }\n" +
            ", 'Y'\n" +
            ")")
    int insertCategory(CategoryDTO category);

    @Update("UPDATE\n" +
            "        PRODUCT_INFO\n" +
            "   SET PRODUCT_NAME = #{ name }\n" +
            " WHEREPRODUCT_NAME = #{ name }")
    int modifyCategoryName(CategoryDTO category);

    @Delete("DELETE\n" +
            "  FROM PRODUCT_INFO\n" +
            " WHERE MENU_CODE = #{ code }")
    int deleteCategory(Map<String, String> parameter );

}
