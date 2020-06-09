package dxc.com.au.controller;

import dxc.com.au.service.MeetingService;
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

@Controller
public class ChabotController {

    private static final boolean TRACE_MODE= false;
    static String botName = "super";
    Chat chatSession = null;
    Bot bot = null;

    @Autowired
    private MeetingService meetingService;

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
                    meetingService.init();
                    String meetings = meetingService.findAllMeetings().toString();
                    meetingService.destory();
                    response = "--  Finding " + meetings + " for you now ";
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
