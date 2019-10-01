package com.jungle.repository;

import com.jungle.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jungle on 2019/2/22.
 */
public interface BoyRepository extends JpaRepository<Boy,Integer> {
    //通过年龄来查询
   public List<Boy> findByAge(Integer age);
}
