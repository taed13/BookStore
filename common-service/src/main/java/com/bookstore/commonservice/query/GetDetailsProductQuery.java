package com.bookstore.commonservice.query;



public class GetDetailsProductQuery {

    private String id;

    public GetDetailsProductQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
