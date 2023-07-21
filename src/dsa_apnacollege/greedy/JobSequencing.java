package dsa_apnacollege.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/* 
    Q: Given array of jobs with deadlines and profit, a job can be done in 1 day, maximise profit
    input: Job(id, deadline, profit) -> {{a, 2, 100}, {b, 1, 19}, {c, 2, 27}, {d, 1, 25}, {e, 3, 15}}
    output: a, c, e
*/
public class JobSequencing {

    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void jobSchedule(ArrayList<Job> jobs) {
        int n = jobs.size();
        Collections.sort(jobs, (a, b) -> {
            return a.deadline - b.deadline;
        });
        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        for (int i = n - 1; i > -1; i--) {
            int slot_available;
            if (i == 0) {
                slot_available = jobs.get(i).deadline;
            } else {
                slot_available = jobs.get(i).deadline - jobs.get(i - 1).deadline;
            }
            maxHeap.add(jobs.get(i));
            while (slot_available > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);
            }
        }
        Collections.sort(result, (a, b) -> a.deadline - b.deadline);
        for (Job job : result) {
            System.out.print(job.id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        jobSchedule(jobs);
    }
}
