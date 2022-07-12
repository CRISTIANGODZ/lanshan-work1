import java.util.Arrays;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-23:00
 * @Description
 * 对于Lost和其子类的说明：
 * 通常情况下，我们应用数据库连接池读取相应数据
 * 但由于工作室进度，我在此用代码块的形式显式将数据赋值给lostArray数组中
 * 这就导致如果Lost中不赋值，其子类继承它的实例方法时，Lost中没有数据而报空指针异常
 * 故将Lost两个方法抽象化，令其子类实现，但这种方式代码复用率高，故不提倡
 * 但是目前阶段解决问题我采用这种方式，等进度到之后会优化。
 */
public class Lost {
    private OneLost[] lostArray;

    public Lost() {
    }

    /*
    添加数据，模拟从数据库读数据的过程
     */
    {
        lostArray = new OneLost[]{
                new BookLost("book","2022-07-09 08:46:45","《基督山伯爵》"),
                new BookLost("book","2022-07-03 14:12:35","《活着》"),
                new BookLost("book","2022-07-13 21:23:51","《瓦尔登湖》"),
                new BookLost("book","2022-07-09 22:21:16","《行者无疆》"),
                new CardLost("Card","2022-07-12 18:23:16","姆巴佩"),
                new CardLost("Card","2022-07-04 14:39:07","哈兰德"),
                new CardLost("Card","2022-07-07 07:56:23","本泽马"),
                new CardLost("Card","2022-07-08 13:53:51","C罗"),
        };
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
    public void showInfo(){
        for (int i = 0; i < lostArray.length; i++) {
            System.out.println(lostArray[i]);
        }
    }
    public OneLost selectByKeyword(String lostName){
        for (int i = 0; i < lostArray.length; i++) {
            if (lostArray[i].getLostName().equals(lostName)){
                return lostArray[i];
            }
        }
        throw new RuntimeException("未找到该物品");
    }

}
