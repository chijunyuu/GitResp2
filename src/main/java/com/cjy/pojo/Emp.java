package com.cjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {

    private Integer EMPNO;

    private String ENAME;

    private String JOB;

    private Integer MGR;

    private Date HIREDATE;

    private Double SAL;

    private Double COMM;

    private Integer DEPTNO;

}
