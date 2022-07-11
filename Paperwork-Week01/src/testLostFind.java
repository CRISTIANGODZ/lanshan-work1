import org.junit.Test;

/**
 * @author 张丁野
 * @version v1.0
 * @time 2022-07-11-22:16
 * @Description
 */
public class testLostFind {

    @Test
    public void test1(){
        BookLost bookLost = new BookLost();

        bookLost.sortLost();
        bookLost.showInfo();
        System.out.println();

        OneLost lost= bookLost.selectByKeyword("《基督山伯爵》");
        System.out.println(lost);

    }

    @Test
    public void test2(){
        CardLost cardLost = new CardLost();

        cardLost.sortLost();
        cardLost.showInfo();
        System.out.println();

        OneLost lost= cardLost.selectByKeyword("《基督山伯爵》");
        System.out.println(lost);

    }

}
