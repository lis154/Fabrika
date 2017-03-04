import java.nio.file.WatchEvent;
import java.util.Date;

/**
 * Created by i.lapshinov on 04.03.2017.
 */
public class Fabrika {

    public static void main(String[] args)
    {
        Watch watch = new DigitalWatch();
        watch.showTime();

        Watch watch3 = new RomeWatch();
        watch3.showTime();


        WatchMaker maker = new DigitalWatchMaker(); // производитель часов
        //WatchMaker maker1 = new RomeWatchMaker();
        WatchMaker maker1 = getMakerByName("R45me");
        Watch watch1 = maker.createWatch();
        Watch watch2 = maker1.createWatch();

        watch1.showTime();
        watch2.showTime();


    }

    public static WatchMaker getMakerByName(String maker)
    {
        if (maker.equals("Digital"))
                return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
                return new RomeWatchMaker();

        throw new RuntimeException("не поддерживается производственная линия часов: " + maker);

    }

}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch
{
    public void showTime()
    {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch
{
    public void showTime()
    {
       // System.out.println(new Date("VII-XX"));
        System.out.println("Rome Time");
    }
}

/**
 * возвращает экземпляр часов
 */
interface WatchMaker
{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker
{
    public Watch createWatch()
    {
        return new DigitalWatch();
    }
}


class RomeWatchMaker implements WatchMaker
{
    public Watch createWatch()
    {
        return new RomeWatch();
    }
}


