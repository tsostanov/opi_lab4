package jmx;


import models.Point;
import java.util.List;

public class HitsPercentage implements HitsPercentageMBean {
    private List<Point> points;
    private int pointsOutOfArea = 0;
    private int clickCounter;
    private Integer clickCounterInteger;

    public HitsPercentage(List<Point> points,Integer clickCounter) {
        this.points = points;
        this.clickCounterInteger = clickCounter;

    }

    @Override
    public void updatePoints(List<Point> points, Integer clickCounter){
        clickCounterInteger = clickCounter;
        this.points = points;
    }

    @Override
    public void updateClickCounter() {
        this.clickCounter = clickCounterInteger;
    }

    @Override
    public double getPercentage() {
        updateClickCounter();
        pointsOutOfArea = (int) ((int) points.size() - points.stream().filter(Point::getSuccess).count());
        return (double) pointsOutOfArea / clickCounter * 100;
    }


}
