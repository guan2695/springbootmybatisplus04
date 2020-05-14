package com.zt.service.impl;

import com.zt.entity.Assessment;
import com.zt.mapper.AssessmentMapper;
import com.zt.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-14 9:34
 */
@Service
public class AssessmentServiceImpl implements AssessmentService {
    @Autowired
    private AssessmentMapper assessmentMapper;
    @Override
    public List<Assessment> getAllAssessmet() {
        return assessmentMapper.getAllAssessmet();
    }

    @Override
    public int updAssessState(int assstate, int aid) {
        return assessmentMapper.updAssessState(assstate,aid);
    }

    @Override
    public int addAssessOver(int aid, String because) {
        return assessmentMapper.addAssessOver(aid,because);
    }
}
