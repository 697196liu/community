package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request , HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getContextPath());
        Enumeration enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = (String) enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name +":"+value );
        }
        System.out.println(request.getParameter("code"));
        response.setContentType("text/html;charset=utf-8");
        try(
                PrintWriter printWriter = response.getWriter()
                ) {

            printWriter.print("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Get
    //students?current=1&limit=10
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false ,defaultValue ="1")int current,
            @RequestParam(name = "limit",required = false ,defaultValue ="10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students!";
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id")int id){
        System.out.println(id);
        return "a student!";
    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name ,int age){
        System.out.println(name+":"+age );
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView findteacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","王五");
        modelAndView.addObject("age",25);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getschool(Model modelAndView){
        modelAndView.addAttribute("name","西安理工大学") ;
        modelAndView.addAttribute("age",70) ;
        return "/demo/view";
    }
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getemp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",25);
        map.put("salary",8000);
        return map;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getemps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",25);
        map.put("salary",8000);
        list.add(map);

        map.put("name","李四");
        map.put("age",28);
        map.put("salary",12000);
        list.add(map);
        return list ;
    }
}
