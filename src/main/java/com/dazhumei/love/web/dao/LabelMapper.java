package com.dazhumei.love.web.dao;

import java.util.List;

import com.dazhumei.love.web.entity.Label;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(Label record);

    /**
     * 添加书签
     * @param label
     * @return
     */
    public int addLabel(Label label);

    /**
     * 查询某人的所以书签
     * @param userId
     * @return
     */
    public List<Label> selectAllLabelByUserId(Integer userId);
    
    /**
     * 查询某人的所以主题
     * @param userId
     * @return
     */
    public List<Label> selectAllThemeByUserId(Integer userId);
    
    /**
     * 查询某人的所以地址
     * @param userId
     * @return
     */
    public List<Label> selectAllUrlByUserId(Integer userId);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
    
}