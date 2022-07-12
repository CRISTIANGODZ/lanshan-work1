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
public class CardLost extends OneLost {
    private String ownerName;

    public CardLost(String lostNameClass, String lostTime) {
        super(lostNameClass, lostTime);
    }

    public CardLost(String lostNameClass, String lostTime, String ownerName) {
        super(lostNameClass, lostTime);
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "CardLost{" +
                "ownerName='" + ownerName + '\'' +
                '}' + ", " + super.toString();
    }
}
