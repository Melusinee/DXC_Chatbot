package dxc.com.au.dao;

import dxc.com.au.domain.Meeting;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IMeetingDao {

    @Select("select * from meeting")
    @Results(id = "meetingMap",value = {
            @Result(id=true,column = "meetingId",property = "meetingId"),
            @Result(column = "location",property = "location"),
            @Result(column = "time",property = "time"),
            @Result(column = "description",property = "description")
    })
    List<Meeting> findAll();

    @Select("select * from meeting where id = #{id}")
    List<Meeting> findMeetingById(Integer id);
}
