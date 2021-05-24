package devideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ShortestDistance {

    public static void main(String[] args) {
        Coordinate[] points = new Coordinate[7];

        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(1, 9);
        points[2] = new Coordinate(2, 5);
        points[3] = new Coordinate(3, 1);
        points[4] = new Coordinate(4, 4);
        points[5] = new Coordinate(5, 8);
        points[6] = new Coordinate(6, 2);

        Arrays.sort(points, new Comparator<Coordinate>()
        {
            @Override
            public int compare(Coordinate p1, Coordinate p2)
            {
                return (p1.x > p2.x) ? 1 : (p1.x == p2.x) ? 0 : -1;
            }
        });
        ShortestDistance shortestDistance = new ShortestDistance();
        System.out.println(shortestDistance.calculate(points, 7));
    }

    public static double distance(Coordinate p1, Coordinate p2) {
        return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
    }

    public double calculate(Coordinate a[], int num) {
        return divide(a, 0, num - 1);
    }

    public double divide(Coordinate a[], int s, int e) {
        if (s == e) {
            return 1e20;
        }

        if (e - s == 1) {
            return distance(a[s], a[e]);
        }
        int mid = (s + e) / 2;
        double leftDistance = divide(a, s, mid);
        double rightDistance = divide(a, mid + 1, e);

        double curMinDistance = (leftDistance < rightDistance) ? leftDistance : rightDistance;

        List<Integer> list = new ArrayList<>();
        for (int i = s; i < e; i++) {
            if (Math.abs(a[s].getX() - a[s].getX()) <= curMinDistance) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.abs(a[list.get(i)].getY() - a[list.get(j)].getY()) > curMinDistance) {
                    continue;
                }
                double tmpDistance = distance(a[list.get(i)], a[list.get(j)]);
                curMinDistance = (curMinDistance < tmpDistance) ? curMinDistance : tmpDistance;
            }
        }

        return curMinDistance;
    }

}

class Coordinate {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

   Coordinate(int x, int y)  {
        this.x = x;
        this.y = y;
   }
}


