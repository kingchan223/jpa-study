package hellojpa.prac2;

import javax.persistence.Embeddable;
import java.time.Duration;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /*현재까지 근무한 시간을 String으로 알려주는 메서드*/
    public String CalWorkTime(){
        Duration duration = Duration.between(startTime, endTime);
        return duration.toString();
    }

    public Period(){ }

    public Period(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
