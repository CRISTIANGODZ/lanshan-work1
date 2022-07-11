import java.util.Arrays;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-23:00
 * @Description
 */
public abstract class Lost {
    private OneLost[] lostArray;

    public Lost() {
    }

    @Override
    public String toString() {
        return "Lost{" +
                "lostArray=" + Arrays.toString(lostArray) +
                '}';
    }

    public OneLost[] getLostArray() {
        return lostArray;
    }

    public abstract void sortLost();
    public abstract void showInfo();
    public abstract OneLost selectByKeyword(String lostName);

}
