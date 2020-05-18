package com.zt.service;

import com.zt.entity.Assessment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-14 9:34
 */
public interface AssessmentService {
    public List<Assessment> getAllAssessmet();
    public int updAssessState(int assstate,int aid);
    public int addAssessOver(int aid,String because);
    public List<Assessment> selectUserAssessment(Assessment assessment);
}
