package dxc.com.au.controller;

import dxc.com.au.dao.IMeetingDao;
import dxc.com.au.dao.IStaffDao;
import dxc.com.au.domain.Meeting;
import dxc.com.au.service.MeetingService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.ibatis.io.Resources;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

@Controller
public class DatabaseController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAllMeeting() throws Exception {
        meetingService.init();
        List<Meeting> meetings = meetingService.findAllMeetings();
        meetingService.destory();
        return meetings.toString();
    }
}
