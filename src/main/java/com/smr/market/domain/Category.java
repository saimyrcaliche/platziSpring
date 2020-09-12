package com.smr.market.domain;

public class Category {
    private int categioryId;
    private String category;
    private boolean active;

    public int getCategioryId() {
        return categioryId;
    }

    public void setCategioryId(int categioryId) {
        this.categioryId = categioryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
