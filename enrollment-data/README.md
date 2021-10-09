# CSCI 1102 Computer Science 2

### Spring 2021

------

## Problem Set 2 : Visualizing Data

### 15 Points

### Due Monday February 15, 2021 Midnight

---

In the early meetings of this course we've been working with snapshots of the enrollment data for sections 04 and 05 of CSCI 1102. A (slightly dated) snapshot of the enrollment data can be found in the text file `/src/enrolled0405.csv`. Each line of that file has three items: a **school**, a **major** and a **graduation year**. The first part of the file looks like this:

```
MCAS    CSBA    2023
MCAS    CSBA    2024
MCAS    CSBA    2024
MCAS    CSBA    2022
MCAS    PHIL    2022
MCAS    CSBS    2024
MCAS    CSBA    2023
MCAS    MATH    2022
CSOM    ISYS    2023
...
```

We've written (and posted) code to *count* the number of lines in the data and we've written (and posted) code to compute a *frequency table* of the data by majors. The first part of the frequency table printing looked like this:

```
BIOC = 3
ISYS = 5
PSYC = 1
MATH = 8
CSBA = 17
NEUR = 2
...
```

For this latter app, we used a `java.util.HashMap<String, Integer>` -- a data structure that we understood to be of type `java.util.Map<String, Integer>`. 

In this problem set, you'll use the **algs4** `StdDraw` library to create a graphical visualization of the enrollment frequency (by major) in sections 04 and 05 of this course. The visualization should display circles with centered text labels identifying the major. The *areas* of the circles should be proportional to the percentage of students with that major enrolled in the course. The output of the program might look as follows:

![fix](./img/bubbles.png)

#### The StdDraw Graphics Display

The graphics display managed by `StdDraw` uses the familiar Cartesian coordinate system with *unit* scale: (x, y) = (0.0, 0.0) at lower left and (x, y) = (1.0, 1.0) at upper right. The coordinate scale and the physical size of the graphics window (in pixels) can be set independently. For example, a window with unit scale (from (0.0, 0.0) to (1.0, 1.0)) might be 500 pixels by 500 pixels (the default) or it might be 500 pixels by 1000 pixels. The physical size of the graphics window (in pixels) can be set using the `StdDraw.setCanvasSize` function. The example above depicts a square graphics window that is 700 pixels by 700 pixels, i.e., arising from a call `StdDraw.setCanvasSize(700, 700)`.

In addition to `StdDraw.setCanvasSize`, you'll want to learn about and use `StdDraw.circle`, `StdDraw.setPenColor` and `StdDraw.text`. You should stick with the default scale 0.0 - 1.0, but choose whatever square physical window size you'd like.  

Choose a fixed area of a 100% reference circle, I recommend 0.1. That is, if 100% of the students were ECON majors, the area of that circle would be 0.1. Then you can determine the area of circle for data N proportionally. For example, N = 20 of the 102 enrolled are ECON majors. This is roughly 20%: 20.0 / 102.0 = 0.196. So the area of the circle for ECON would be 0.1 * 0.196. = 0.0196. 

The `StdDraw.circle` function requires a *radius* as input. Given the area $a$ we can compute the radius $r = \sqrt{a/\pi}$. (Use`Math.sqrt` and `Math.PI`.)

##### What is Required

1. All circles should have proportionally correct areas.
2. The circumference line and the text label of each circle should be colored with a matching *randomly* chosen color. Use the 3-argument function `StdDraw.setPenColor(red, green, blue)` where the inputs`red`, `green` and `blue` are computed using calls to the integer version of `StdRandom.uniform`.
3. All circles should be placed with their centers at randomly chosen (x, y) coordinates **but the circles must be completely contained within the graphics area**. Refer to the `StdRandom` class to see how to generate random x and y coordinates.

##### What is Not Required

1. Circles are not required to be non-overlapping;
2. The text label on a circle may extend beyond the circumference of the circle.

#### Accessing Frequency Data

Feel free to borrow as you like from the frequency table code developed in class. That code employed a `java.util.Map<String, Integer>` mapping `String`s (i.e., majors) to `Integer`s (i.e., number of enrolled students with that major). You'll need one circle for each major. You may want to consider using the `Map.keys` function in conjunction with a `for`-loop. 

### Project Structure

**Heads Up!** Things will go better if we avoid cloning our problem sets using IntelliJ's `Get from Version Control`  splash-page feature. Don't use it. Clone this problem set and all that follow using the GitHub Desktop App or using the command shell. The cloned problem set repo, e.g., `ps2-BenFranklin/`  will have the following files/folders:

```bash
README.md img/ src/
```

The folder `ps2-BenFranklin/` is a git repo but it is **not** an IntelliJ project and it should not be opened from IntelliJ. **The subdirectory `src/` is the IntelliJ project.** So once you've cloned the repo (using something other than IntelliJ's `Get from Version Control` option), you can fire up IntelliJ and then use IntelliJ's `Open or import` splash-page item to navigate to the IntelliJ project at `ps2-BenFranklin/src/` **NOTE THE src/!!** 

If you follow the above conventions you should be able to open, edit, compile, run, debug, commit and push your code to your master repo with no issues.

### 3 Points Extra Credit

Instead of using `StdDraw.cirlce`, use `StdDraw.filledCircle` (with `StdDraw.WHITE` lettering for the labels). Place the circles randomly as before but make the circles non-overlapping.

---

Don't forget! Your final commit message should be something like: **Final: Ben Franklin**.

The TAs will review your code and post comments in the grade book on Canvas.

Start soon, Good luck!