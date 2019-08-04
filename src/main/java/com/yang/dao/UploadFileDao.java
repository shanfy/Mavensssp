package com.yang.dao;

import com.yang.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: shanfy
 * @Date: 2019/8/3 15:23
 */
@Repository("uploadFileDao")
public interface UploadFileDao extends JpaRepository<Pic,Integer> {

}
