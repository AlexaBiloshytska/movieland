package com.alexa.movieland.entity;

public enum SortingEnum {
    RATING_ASC("rating","asc"),
    PRICE_DESC("price","desc"),
    PRICE_ASC("price","asc");

    private String field;
    private String type;

    SortingEnum(String field, String type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public String getType() {
        return type;
    }

    public static SortingEnum getSortEnum(String field,String type){
        for (SortingEnum value: values()){
            if (value.getField().equalsIgnoreCase(field)&&value.getType().equalsIgnoreCase(type)){
                return value;
            }
        }
        throw new RuntimeException("Invalid request param: sort strategy - field: " + field + " type: " + type);
    }
}
