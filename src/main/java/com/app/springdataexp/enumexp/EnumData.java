package com.app.springdataexp.enumexp;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "ENUM_DATA")
public class EnumData {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "STUDENT_TYPE")
    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Column(name = "CATEGORY_TYPE")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
