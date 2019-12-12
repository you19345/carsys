package com.du.car.user.entity;

import lombok.Data;

@Data
public class MemberProfile {
    private Long id;

    private String nickname;

    private String name;

    private Byte gender;

    private Integer level;

    private String avatarUrl;

    private String mobileCode;

    private String mobile;

    private String email;

    private String description;

    private Integer country;

    private Integer province;

    private Integer city;

    private Integer district;

    private String address;

    private Integer registerTime;

    private Integer point;

}