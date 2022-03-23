package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReturnReason implements Serializable {
    private Integer reasonId;
    private String reasonName;
    private Integer status;
}
