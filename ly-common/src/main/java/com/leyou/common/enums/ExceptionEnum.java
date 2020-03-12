package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"商品分类没有查到"),
    BRAND_NOT_FOUND(404,"品牌没有查到"),
    BRAND_SAVE_ERROR(500,"品牌新增失败"),
    CATEGORY_BRAND_SAVE_ERROR(500,"新增中间表失败"),
    FILE_UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(500, "文件类型不匹配"),
    SPEC_GROUP_NOT_FOUND(404,"商品规格组不存在"),
    ;
    private int code;
    private String msg;
}
