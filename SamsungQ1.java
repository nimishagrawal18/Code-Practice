
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SamsungQ1 {
    static HashMap<Integer,ArrayList<Lecture>> overlaps;
    public static void main(String[] args) {
        runCode();
    }

    public static void runCode() {
        Scanner sc = new Scanner(System.in);

        int T= sc.nextInt();
        for (int x = 0; x < T; x++) {
            int n = sc.nextInt();
            // String t = sc.nextLine();
            Lecture[] arr = new Lecture[n];
            // double[] end = new double[n];
            // String sub[] = new String[n];
            // double[] start = new double[n];2
            
            for (int i = 0; i < n; i++) {
                
                String[] inp = sc.nextLine().split(" ");
                arr[i] = new Lecture(inp[0], timeToNum(inp[1]), timeToNum(inp[2]));
            }
            ArrayList<Lecture> selected = new ArrayList<Lecture>();
            // selected.add()
            overlaps = new HashMap<Integer,ArrayList<Lecture>>();
            System.out.println(getMaxSchedule(0, selected, arr));


        }

        sc.close();
    }
    private static int getMaxSchedule(int index, List<Lecture> selected, Lecture[] classes) {
        // check if we reached the end of the array
        if (index >= classes.length) {
            return 0;
        }

        Lecture current = classes[index];

        // check if taking this class doesn't conflict with the
        // previously-selected set of classes
        boolean canTakeThisClass = true;
        for (Lecture other : selected) {
            if (overlaps.containsKey(index) && overlaps.get(index).contains(other)) {
                canTakeThisClass = false;
                break;
            }
            else if (current.overlapsWith(other)) {
                if (!overlaps.containsKey(index)) overlaps.put(index, new ArrayList<Lecture>());
                overlaps.get(index).add(other);
                canTakeThisClass = false;
                break;
            }
        }

        // check best schedule if we don't take this class
        int best = getMaxSchedule(index + 1, selected, classes);
        // System.out.println("Best = "+best);
        // check best schedule if we take this class (if such is possible)
        if (canTakeThisClass) {
            selected.add(current);
            best = Math.max(best, 1 + getMaxSchedule(index + 1, selected,classes));
            selected.remove(current);
        }
        // System.out.println("Final Best = "+best);
        return best;
    }

    private static double timeToNum(String time) {
        String[] inp = time.split(":");
        double out = Integer.parseInt(inp[0]);
        int mm = Integer.parseInt(inp[1]);
        if (mm==30) out += 0.5;
        else if (mm==15) out += 0.25;
        else if (mm==45) out += 0.75;
        return out;
    }
}
class Lecture {
    String subject;
    double start;
    double end;
    public Lecture(String subject, double start, double end) {
        this.subject = subject;
        this.start = start;
        this.end = end;
    }
    public boolean overlapsWith(Lecture other) {
        return this.end>other.start && this.start<other.end;
    }
    // public String getSubject() {
    //     return subject;
    // }
    // public void setSubject(String subject) {
    //     this.subject = subject;
    // }
    // public double getStart() {
    //     return start;
    // }
    // public void setStart(double start) {
    //     this.start = start;
    // }
    // public double getEnd() {
    //     return end;
    // }
    // public void setEnd(double end) {
    //     this.end = end;
    // }
    
}


// Scheduling Classes
// Andy studies at the University of California is very studious. He wants to take as many subjects as possible without any class overlap.
// The University doesn’t impose any restriction on the number of classes taken during the semester.

// He really doesn’t care about what subject he takes; he likes them all! However, he wants to maximize the number of subjects he can take.

// Input Format

// The first line of input consists of an integer t. This is the number of days.

// For each day, the first line contains an integer n which gives the number of subjects offered on that day.
// Then next n lines follow containing the subject name (which is a string) followed by the start and end time for that subject in 24-hour format: hh: mm
// For eg: Maths 10:00 11:00

// Note: The timings are given in 24-hour format and the subject names do not have spaces between them.

// Output Format

// The output should contain t lines and each line has a number representing the maximum number of classes Andy can choose.

// Constraints

// * 1 <= t <= 5000
// * 2 <= n <= 100
// * start time of a class < end time of class
// Sample Input

// 2
// 4
// Maths 16:00 18:00
// ComputerScience 12:00 13:00
// Physics 12:30 14:00
// Chemistry 14:00 16:30
// 5
// Geography 14:00 16:00
// History 12:00 14:30
// Arts 14:00 16:30
// Literature 12:30 13:30
// German 13:30 15:00
// Sample Output

// 2
// 2
// Explanation

// For the 1st day, ComputerScience starts the earliest and ends the earliest, so we take it first. After that, we cannot take Physics because it starts before ComputerScience is over. So we will take the next class, that is, Chemistry. But after Chemistry we cannot take Maths as Maths class starts before Chemistry class ends. So we can schedule a maximum of 2 classes for the first day.
// Similarly, we schedule for the second day.
// Environment
// Read from STDIN and write to STDOUT.

// Please check the sample program below which prints the sum of two numbers received as input

// C https://goo.gl/4zRfEC
// C++ https://bitly.com/2Io1VND
// Java goo.gl/QUZhgb (Remove package declarations and keep the class name as “solution”

