package com.ballistic.haleemghr.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Nabeel on 10/10/2017.
 */
public class PrintItem {

    @ApiModelProperty(notes = "Give Some Description")
    private String description;

    public String getDescription() {
       return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
