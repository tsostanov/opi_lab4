package jmx;

import models.Point;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;
import java.util.List;


public class PointStatistics extends NotificationBroadcasterSupport implements PointStatisticsMBean {
    private List<Point> points;
    private int totalPoints = 0;
    private int pointsInArea = 0;
    private int seqCounter;

    public PointStatistics(List<Point> points) {
        this.points = points;
    }

    @Override
    public void updateStatistics() {
        totalPoints = points.size();
        pointsInArea = (int) points.stream().filter(Point::getSuccess).count();
    }

    @Override
    public void updatePoints(List<Point> points){
        this.points = points;
    }

    @Override
    public int getTotalPoints() {
        updateStatistics();
        return totalPoints;
    }

    @Override
    public int getPointsInArea() {
        updateStatistics();
        return pointsInArea;
    }

    @Override
    public void checkOutOfBounds(Point point) {
        double x = point.getX() * point.getR();
        double y = point.getY() * point.getR();
        if (Math.abs(x) > 5 || Math.abs(y) > 5) {
            sendNotification(new AttributeChangeNotification(this,
                    seqCounter++,
                    System.currentTimeMillis(),
                    "Координаты точки вышли за пределы отображаемой области",
                    "coordinates",
                    "Point",
                    null, null));
        }
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return super.getNotificationInfo();
    }
}
