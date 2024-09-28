package jmx;


import models.Point;

import java.util.List;

public interface PointStatisticsMBean {
    void updateStatistics();
    void updatePoints(List<Point> points);
    int getTotalPoints();
    int getPointsInArea();
    void checkOutOfBounds(Point point);
}
