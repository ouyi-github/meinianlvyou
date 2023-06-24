package com.atguigu.dao;

import com.atguigu.pojo.TravelGroup;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TravelGroupDao {
    void add(TravelGroup travelGroup);

    void addTravelGroupAndTravelItem(Map<String, Integer> paramData);

    Page findPage(@Param("queryString") String queryString222);

    TravelGroup getById(Integer id);

    List<Integer> getTravelitemIdsByTravelGroupId(Integer travelGroupId);

    void edit(TravelGroup travelGroup);

    // 根据跟团游id 删除跟团游自由行关联表中的数据
    void delete(Integer travelGroupId);

    List<TravelGroup> findAll();

    /**
     * 帮助封装套餐对象的travelGroups属性方法
     * @return
     */
    List<TravelGroup> findTravelGroupById(Integer id);

    // 根据跟团游id 查询跟团游自由行关联表中的数据记录数
    Integer findCountBytravelGroupId(@Param("travelGroupId") Integer travelGroupId);

    // 根据跟团游id 查询跟团游套餐游关联表中的数据记录数
    Integer findCountBytravelGroupIdWithSetmeal(@Param("travelGroupId") Integer travelGroupId);

    // 根据跟团游id，删除跟团游表数据
    void deleteTravelGroupById(@Param("travelGroupId") Integer travelGroupId);
}
