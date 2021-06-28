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
@Table("fnol")
public class Fnol {


    @Id
    @Column("id")
    private Integer id;

    @Column("policyholderName")
    private String policyholderName;

    @Column("policyNumber")
    private String policyNumber;

    @Column("product")
    private String product;

    @Column("insuredName")
    private String insuredName;

    @Column("relation")
    private String relation;

    @Column("email")
    private String email;

    @Column("phoneNo")
    private String phoneNo;

    @Column("communication")
    private String communication;

    @Column("locationOfAccident")
    private String locationOfAccident;

    @Column("dateOfAccident")
    private String dateOfAccident;

    @Column("categoryOfHospital")
    private String categoryOfHospital;

}
