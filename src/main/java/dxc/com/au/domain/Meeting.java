package dxc.com.au.domain;

import java.io.Serializable;
import java.util.Date;

public class Meeting implements Serializable {
    private Integer meetingId;
    private String location;
    private Date time;
    private String description;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", description='" + description + '\'' +
                '}';
    }
}
