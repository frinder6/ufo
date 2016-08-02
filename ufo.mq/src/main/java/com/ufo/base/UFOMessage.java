package com.ufo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by frinder_liu on 2016/7/31.
 */
@Setter
@Getter
public class UFOMessage implements Serializable {

    private MsgHeader msgHeader;

    private String context;

}
