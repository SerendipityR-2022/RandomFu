package cn.serendipityr.RandomFu;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RandomFu {
    public static void main(String[] args) {
        System.out.println(getTimeStr() + "==============-Made by SerendipityR-==============");
        System.out.println(getTimeStr() + " RandomFu (ver: 1.0.1) is loading...");
        System.out.println(getTimeStr() + "==================================================");
        System.out.println(getTimeStr() + "定时任务已激活，每日00:00自动生成生肖卡。");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                start();
            }
        }, time, 1000 * 60 * 60 * 24); // 延时一天执行
    }

    public static void start() {
        System.out.println(getTimeStr() + "随机生成中...");
        SecureRandom random = new SecureRandom();
        String[] chineseZodiacs = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
        String[] fiveBlessingCard = {"爱国福", "富强福", "和谐福", "友善福", "敬业福"};

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Integer integer_1 = new RandomFu().getRandomNumber(0, 11, random);
                System.out.println(getTimeStr() + "猜生肖: " + chineseZodiacs[integer_1]);
            } else {
                Integer integer_1 = new RandomFu().getRandomNumber(0, 4, random);
                Integer integer_2 = new RandomFu().getRandomNumber(0, 4, random);
                System.out.println(getTimeStr() + "猜福卡(组合" + i + "): " + fiveBlessingCard[integer_1] + " | " + fiveBlessingCard[integer_2]);
            }
        }

        System.out.println(getTimeStr() + "==================================================");
    }

    public Integer getRandomNumber(int min, int max, SecureRandom random) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String getTimeStr() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:sss");

        return "[" + df.format(date) + "] ";
    }
}
