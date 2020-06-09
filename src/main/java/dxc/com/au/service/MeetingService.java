package dxc.com.au.service;

import dxc.com.au.domain.Meeting;

import java.util.List;

public interface MeetingService {
    void init() throws Exception;
    void destory() throws Exception;
    List<Meeting> findAllMeetings();
}
