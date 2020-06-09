package dxc.com.au.controller;

import dxc.com.au.dao.IStaffDao;
import dxc.com.au.domain.Staff;
import dxc.com.au.service.MeetingService;
import dxc.com.au.service.StaffService;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.Socket;

@Controller
public class ChabotController {

    private static final boolean TRACE_MODE= false;
    static String botName = "super";
    Chat chatSession = null;
    Bot bot = null;

    @Autowired
    private MeetingService meetingService;
    @Autowired
    private StaffService staffService;
    private IStaffDao staffDao;

    @RequestMapping(value = "/botResponse",method = RequestMethod.GET)
    @ResponseBody
    public String botResponse(@RequestParam(value = "message", defaultValue = "") String message ){ // message is the user input
        System.out.println("print message below");
        System.out.println(message);

        try{
            String resourcePath = getResourcesPath();
            MagicBooleans.trace_mode = TRACE_MODE;

            // initialize the bot
            if(bot == null){
                bot = new Bot("super",resourcePath,"chat");
            }

            // initialize the chat session
            if(chatSession == null){
                chatSession = new Chat(bot);
            }

            if(message.length() < 1){
                bot.writeQuit();
                return "Please enter the message content";
            }else{
                String response = chatSession.multisentenceRespond(message);
                if(message.toLowerCase().startsWith("another")){
                    response = "I will ask another bot to help you";
                }
                if(message.toLowerCase().startsWith("find all meetings")){
                    String meetings = meetingService.findAllMeetings().toString();
                    response = "--  Finding " + meetings + " for you now ";
                }
                if(message.toLowerCase().startsWith("find all staffs")){
                    String staffs = staffService.findAllStaffs().toString();
                    response = "-- Finding " + staffs + "for you now ";
                }
                // intended to use "we have a new staff named Charles with id 2"
                if(message.toLowerCase().startsWith("we have a new staff")){
//                    System.out.println("enter add staff function");
                    String name = message.split(" ")[6];
                    Integer id = Integer.parseInt(message.split(" ")[9]);
                    Integer meetingId = 1;
                    Staff staff = new Staff();
                    staff.setName(name);
                    staff.setId(id);
                    staff.setMeetingId(meetingId);
                    staffDao.saveStaff(staff);
                    response = "Already saved staff" + staff.toString();
                }
                response = overWriteBotResponse(response);
                return response;
            }

        }catch (Exception e){
            e.printStackTrace();
        }   return "Sorry I broke!";

    }

    // overwrite the response
    public String overWriteBotResponse(String botResponse){
        String newResponse = botResponse;
        return newResponse;
    }

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0,path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
}
