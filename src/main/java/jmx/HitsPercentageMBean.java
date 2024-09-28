package jmx;

import models.Point;

import java.util.List;

public interface HitsPercentageMBean {
    void updatePoints(List<Point> points, Integer clickCounter);
    void updateClickCounter();
    double getPercentage();
}
