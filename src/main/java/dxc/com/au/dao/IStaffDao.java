package dxc.com.au.dao;

import dxc.com.au.domain.Staff;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

    void saveStaff(Staff staff);

}
