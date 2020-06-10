package dxc.com.au.service.impl;

import dxc.com.au.dao.IMeetingDao;
import dxc.com.au.dao.IStaffDao;
import dxc.com.au.domain.Meeting;
import dxc.com.au.domain.Staff;
import dxc.com.au.service.StaffService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IStaffDao iStaffDao;

    @Override
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        iStaffDao = session.getMapper(IStaffDao.class);
    }

    @Override
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Override
    public List<Staff> findAllStaffs() throws Exception {
        init();
        List<Staff> staffs = iStaffDao.findAll();
        destory();
        return staffs;
    }

    @Override
    public void saveStaff(Staff staff) throws Exception {
        System.out.println("service: save all staff...");
        init();
        iStaffDao.saveStaff(staff);
        destory();
    }

}
