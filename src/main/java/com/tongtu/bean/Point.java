package com.tongtu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    /// <summary>
    /// 纬度
    /// </summary>
    public Double lat;

    /// <summary>
    /// 经度
    /// </summary>
    public Double lon;

    /// <summary>
    /// 高程
    /// </summary>
    public Double alt;

    /// <summary>
    /// 时间
    /// </summary>
    public Date time;

    public Double distance;

}
