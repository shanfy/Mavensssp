package com.yang.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: shanfy
 * @Date: 2019/8/3 15:15
 */
@Data
@Entity
@Table(name = "t_pic")
public class Pic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Integer id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_url")
    private String url;


    public void setUrl(String url) {
        this.url = url;
    }
    public Pic(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Pic() {
    }
}
