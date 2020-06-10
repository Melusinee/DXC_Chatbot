package dxc.com.au.dao;

import dxc.com.au.domain.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStaffDao {

    @Select("select * from staff")
    @Results(id = "staffMap", value = {
            @Result(id=true,column ="id",property = "id"),
            @Result(column ="name",property = "name"),
            @Result(column ="meetingId",property = "meetingId")
        }
    )
    List<Staff> findAll();

    @Insert("insert into staff (name,id,meetingId) values (#{name},#{id},#{meetingId})")
    void saveStaff(Staff staff);

}
