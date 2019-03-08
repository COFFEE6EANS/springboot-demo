package com.schedule.quartz.entity;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：guojianfeng.
 * @ Date       ：Created in 16:59 2018/9/19
 * @ Description：${description}
 */

public interface ConfigRepository extends JpaRepository<Config, Integer> {
    Config findConfigById(Long id);
}
