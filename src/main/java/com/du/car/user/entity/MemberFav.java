package com.du.car.user.entity;

import lombok.Data;

@Data
public class MemberFav {
    private Long id;

    private Long memberId;

    private Byte favType;

    private Long contentId;

    private Integer favTime;

    private String favIp;

}