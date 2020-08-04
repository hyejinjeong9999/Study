import java.util.*;

class Sort {
    public static void main(String[] args) {
        int[] numbers = { -3, -5, 1, 7, 4, -2 };
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] strings = { "a", "c", "b", "B", "A", "C" };
        for (String str : strings) {
            System.out.print(str + " ");
        }

        System.out.println();
        // Array.sort 일 경우 : 자연스러운 순서로 정렬이 가능
        // JAVA에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있기 때문
        Arrays.sort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        Arrays.sort(strings);
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
        // comparable 예제

        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(3, 4));
        pointList.add(new Point(8, 4));
        pointList.add(new Point(1, 4));
        pointList.add(new Point(1, 8));
        pointList.add(new Point(1, 3));

        // Collections.sort(pointList);

        // for (Point point : pointList) {
        // System.out.print("x : " + point.x + " y : " + point.y + " ");
        // System.out.println();
        // }

        // comparator 예제

        MyComparator myComparator = new MyComparator();
        Collections.sort(pointList, myComparator);

        for (Point point : pointList) {
            System.out.print("x : " + point.x + " y : " + point.y + " ");
            System.out.println();
        }

        // 익명클래스를 사용한 comparator

        Comparator<Point> myComparator2 = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y < o2.y) {
                        return 1;
                    }
                }

                return -1;
            }
        };

    }
}

// comparable interface를 이용한 정렬

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x > o.x) {
            return 1; // x에 대해서는 오름차순
        } else if (this.x == o.x) {
            if (this.y < o.y) {
                return 1; // y축에 대해서는 내림차순

            }

        }
        return -1;
    }
}

// Comparator interface

class MyComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {

        if (o1.x > o2.x) {
            return 1; // x에 대해서는 오름차순
        } else if (o1.x == o2.x) {
            if (o1.y < o2.y) { // y에 대해서는 내림차순
                return 1;
            }
        }

        return -1;
    }
}