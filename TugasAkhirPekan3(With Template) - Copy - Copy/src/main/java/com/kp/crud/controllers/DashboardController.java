/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employees;
import com.kp.crud.entities.History;
import com.kp.crud.entities.Request;
import com.kp.crud.services.EmployeeService;
import com.kp.crud.services.HistoryService;
import com.kp.crud.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dhanuaji Pratama
 */
@Controller
public class DashboardController {
    @Autowired
    RequestService requestService;
    
    @Autowired
    HistoryService historyService;
    
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping("dashboard")
    public String dashboardview(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("requests", requestService.getAll());
        model.addAttribute("history", new History());
        model.addAttribute("histories", historyService.showHistory());
        model.addAttribute("employee", new Employees());
//        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("employees", employeeService.employeeLeaveView());
        return "dashboard";
    }
    
}
