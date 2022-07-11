import java.util.Arrays;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-23:45
 * @Description
 */
public class BookLost extends Lost{

    private OneLost[] lostArray;

    public BookLost() {
    }

    /*
    由于从数据库中获取丢失物品数组，
    故该地方以设置代码块给数组赋值
    代替从数据库中获取数组的操作
     */
    {
        lostArray = new OneLost[]{
                new OneLost("《基督山伯爵》","2022-07-09 10:12:34"),
                new OneLost("《欧也妮-葛朗台》","2022-07-08 12:23:32"),
                new OneLost("《平凡的世界》","2022-07-13 05:43:10"),
                new OneLost("《活着》","2022-07-03 20:19:12"),
        };
    }

    @Override
    public void sortLost(){
        Arrays.sort(lostArray);
    }

    @Override
    public void showInfo() {
        for (int i = 0; i < lostArray.length; i++) {
            System.out.println(lostArray[i]);
        }
    }

    @Override
    public OneLost selectByKeyword(String lostName) {
        for (int i = 0; i < lostArray.length; i++) {
            if (lostArray[i].getLostName().equals(lostName)){
                return lostArray[i];
            }
        }
        throw new RuntimeException("未找到该物品");
    }


}
