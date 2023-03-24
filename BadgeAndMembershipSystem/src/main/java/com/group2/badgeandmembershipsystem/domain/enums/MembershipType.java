package com.group2.badgeandmembershipsystem.domain.enums;

public enum MembershipType {
    LIMITED("LIMITED"), UNLIMITED("UNLIMITED"), CHECKER("CHECKER");
    private String type;
    MembershipType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
