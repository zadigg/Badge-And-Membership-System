package com.group2.badgeandmembershipclient.enums;

public enum LocationType {
    DINING_HALL, MEDITATION_HALL, FLYING_HALL,
    CLASSROOM, GYMNASIUM, DORMITORY,LIBRARY;

    private String locationType;

    public String getType(){
        return locationType;
    }
}
