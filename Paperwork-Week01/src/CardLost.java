import java.util.Arrays;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-23:44
 * @Description
 * 对于Lost和其子类的说明：
 * 通常情况下，我们应用数据库连接池读取相应数据
 * 但由于工作室进度，我在此用代码块的形式显式将数据赋值给lostArray数组中
 * 这就导致如果Lost中不赋值，其子类继承它的实例方法时，Lost中没有数据而报空指针异常
 * 故将Lost两个方法抽象化，令其子类实现，但这种方式代码复用率高，故不提倡
 * 但是目前阶段解决问题我采用这种方式，等进度到之后会优化。
 */
public class CardLost extends Lost {

    private OneLost[] lostArray;

    public CardLost() {
    }


    /*
    由于从数据库中获取丢失物品数组，
    故该地方以设置代码块给数组赋值
    代替从数据库中获取数组的操作
     */
    {
        lostArray = new OneLost[]{
                new OneLost("姆巴佩","2022-07-09 10:12:34"),
                new OneLost("本泽马","2022-07-08 12:23:32"),
                new OneLost("哈兰德","2022-07-13 05:43:10"),
                new OneLost("C罗","2022-07-03 20:19:12"),
        };
    }

    @Override
    public void sortLost(){
        for (int i = 0; i < lostArray.length-1; i++) {
            for (int j = i+1; j < lostArray.length; j++) {
                if (lostArray[i].compareTo(lostArray[j]) > 0){
                    OneLost oneLost = lostArray[i];
                    lostArray[i] = lostArray[j];
                    lostArray[j] = oneLost;
                }
            }
        }
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
