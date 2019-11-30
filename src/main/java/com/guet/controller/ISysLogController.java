package com.guet.controller;

import com.github.pagehelper.PageInfo;
import com.guet.domain.SysLog;
import com.guet.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/28 12:16
 */
@Controller
@RequestMapping("/sysLog")
@RolesAllowed("A")
public class ISysLogController {
    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogs);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
