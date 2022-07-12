import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-21:58
 * @Description
 */
public class OneLost implements Comparable{
    private String lostName;
    private Date lostTime;

    public OneLost() {
    }

    public OneLost(String lostName) {
        this.lostName = lostName;
    }

    public OneLost(String lostNameClass, String lostTime) {
        this.lostName = lostNameClass;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            this.lostTime = sdf.parse(lostTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getLostName() {
        return lostName;
    }

    public void setLostName(String lostName) {
        this.lostName = lostName;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            this.lostTime = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "OneLost{" +
                "lostName='" + lostName + '\'' +
                ", lostTime=" + lostTime +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof OneLost){
            OneLost lost = (OneLost) o;

            long thisObjectTime = this.lostTime.getTime();
            long lostObjectTime = lost.lostTime.getTime();
            return -Long.compare(thisObjectTime,lostObjectTime);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }

}
