package com.javareactive.ecsapimain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("person")
public class Person {

    @Id
    @Column("id")
    private Integer id;

    @Column("first_name")
    private String first_name;

    @Column("last_name")
    private String last_name;

    @Column("email")
    private String email;

    @Column("gender")
    private String gender;

    @Column("ip_address")
    private String ip_address;
}
