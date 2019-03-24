package org.huija.jpa.dao;

import org.huija.jpa.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 相当于mybatis的dao或者mapper接口
 */
public interface GradeRepository extends JpaRepository<Grade,String> {
}
