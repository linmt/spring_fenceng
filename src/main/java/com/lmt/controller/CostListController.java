package com.lmt.controller;

import com.lmt.dao.CostDao;
import com.lmt.entity.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 热带雨林 on 2018/11/4.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/cost")
public class CostListController{
    private CostDao costDao;
    @Autowired
    //由于用的是自动扫描，所以找不到bean，但是能正常运行
    public void setCostDao(CostDao costDao){
        this.costDao=costDao;
    }

    @RequestMapping("/list.form")
    public String findCost(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {
        int page;
        if(request.getParameter("page")==null){
            page=1;
        }else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        int pageSize=3;

        int totalPage=costDao.findTotalPage(pageSize);

        int nextMin = page*pageSize + 1;
        int lastMax = (page-1)*pageSize;
        Map fenyeMap=new HashMap<String, Integer>();
        fenyeMap.put("nextMin",nextMin);
        fenyeMap.put("lastMax",lastMax);
        List<Cost> costList=costDao.findByPage((HashMap) fenyeMap);

        model.put("page", page);
        model.put("totalPage", totalPage);
        model.put("costs", costList);
        return "cost/cost_list";
    }
}
