package com.sushant.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "Guardian_Name")),
        @AttributeOverride(name = "email", column = @Column(name = "Guardian_Email")),
        @AttributeOverride(name = "mobNo", column = @Column(name = "Guardian_MobNo"))

        })
public class Guardian {

    @Column(name = "Guardian_Name", nullable = false)
    private String name;
    @Column(name = "Guardian_Email", nullable = true)
    private String email;
    @Column(name = "Guardian_MobNo", nullable = false)
    private String mobNo;
}
