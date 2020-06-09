package dxc.com.au.service;

import dxc.com.au.domain.Meeting;
import dxc.com.au.domain.Staff;

import java.util.List;


public interface StaffService {
    void init() throws Exception;
    void destory() throws Exception;
    List<Staff> findAllStaffs() throws Exception;
}
