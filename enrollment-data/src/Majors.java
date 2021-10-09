import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/******************************************************************************
 *  Compilation:  javac-algs4 Majors.java
 *  Execution:    java-algs4 Majors filename
 *
 *  Render a frequency table of majors in CS2.
 *
 ******************************************************************************/

public class Majors {

  private static final double MAXAREA = 0.1;

  private static void circles(Map<String, Integer> frequency) {
    for (String major : frequency.keySet()) {
      int count = frequency.get(major);
      double percent = (double) count / (double) frequency.size();
      double area = percent * MAXAREA;
      double radius = Math.sqrt(area / Math.PI);

      double x = StdRandom.uniform(radius, (1.0 - radius));
      double y = StdRandom.uniform(radius, (1.0 - radius));

      int red = StdRandom.uniform(255);
      int green = StdRandom.uniform(255);
      int blue = StdRandom.uniform(255);
      StdDraw.setPenColor(red, green, blue);
      StdDraw.text(x, y, major);
      StdDraw.circle(x, y, radius);

    }
  }

  public static void main(String[] args) {
    StdDraw.setCanvasSize(700, 700);

    int count = 0;
    Map<String, Integer> frequency = new HashMap<String, Integer>();
    In in = new In(args[0]);
    try {
      while (true) {
        String school = in.readString();
        String major = in.readString();
        if (frequency.containsKey(major))
          frequency.put(major, frequency.get(major) + 1);
        else
          frequency.put(major, 1);
        int year = in.readInt();
        count++;
      }
    }
    catch (NoSuchElementException e) {
      in.close();
    }

    circles(frequency);

  }
}
