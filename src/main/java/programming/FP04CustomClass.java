package src.main.java.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("Fullstack", "Fullstack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> isReviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> isReviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
        Predicate<Course> isReviewScoreLessThan85 = course -> course.getReviewScore() < 85;

        //allMatch - checks if all objects match the given predicate
        //e.g. checks if all courses have review score greater than 90
        System.out.println(courses.stream().allMatch(isReviewScoreGreaterThan90));
        //e.g. checks if all courses have review score greater than 95
        System.out.println(courses.stream().allMatch(isReviewScoreGreaterThan95));

        //noneMatch checks none of the courses should fall under the given criteria
        System.out.println(courses.stream().noneMatch(isReviewScoreGreaterThan95));
        System.out.println(courses.stream().noneMatch(isReviewScoreLessThan85));

        //anyMatch checks if any of the courses matches the predicate
        System.out.println(courses.stream().anyMatch(isReviewScoreGreaterThan95));
        System.out.println(courses.stream().anyMatch(isReviewScoreLessThan85));
        System.out.println("-----------------");
        Predicate<Course> areNoOfStudentsGreaterThan10000 = course -> course.getNoOfStudents() > 10000;
        Predicate<Course> areNoOfStudentsLessThan20000 = course -> course.getNoOfStudents() > 20000;
        Predicate<Course> areNoOfStudentsGreaterThan15000 = course -> course.getNoOfStudents() > 15000;
        Predicate<Course> areNoOfStudentsLessThan25000 = course -> course.getNoOfStudents() > 25000;
        Predicate<Course> areNoOfStudentsLessThan10000 = course -> course.getNoOfStudents() < 10000;

        System.out.println(courses.stream().allMatch(areNoOfStudentsGreaterThan10000));
        System.out.println(courses.stream().allMatch(areNoOfStudentsLessThan20000));

        System.out.println(courses.stream().noneMatch(areNoOfStudentsGreaterThan10000));
        System.out.println(courses.stream().noneMatch(areNoOfStudentsLessThan25000));

        System.out.println(courses.stream().anyMatch(areNoOfStudentsGreaterThan15000));
        System.out.println(courses.stream().anyMatch(areNoOfStudentsLessThan10000));

        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        Comparator<Course> compareByNoOfStudentsAndReviewScoreDecreasing = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(compareByNoOfStudentsAndReviewScoreDecreasing).collect(Collectors.toList()));

        //When using primitives for comparison, use primitive comparator methods for better performance
        Comparator<Course> comparingByNoOfStudentsIncreasingUpdated = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasingUpdated).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasingUpdated = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasingUpdated).collect(Collectors.toList()));

        Comparator<Course> compareByNoOfStudentsAndReviewScoreDecreasingUpdated = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(compareByNoOfStudentsAndReviewScoreDecreasingUpdated).collect(Collectors.toList()));

        //limit for putting a limit on the no. of elements returned
        //e.g. limit on the top 5 courses
        System.out.println(courses.stream().sorted(compareByNoOfStudentsAndReviewScoreDecreasingUpdated).limit(5).collect(Collectors.toList()));

        //skip for skipping the top x results
        //e.g. I want to skip the top 3 results
        System.out.println(courses.stream().sorted(compareByNoOfStudentsAndReviewScoreDecreasingUpdated).skip(3).collect(Collectors.toList()));

        //Can also combine skip and limit
        System.out.println(courses.stream().sorted(compareByNoOfStudentsAndReviewScoreDecreasingUpdated).skip(3).limit(2).collect(Collectors.toList()));

        //takeWhile - to take all the elements until they meet a particular criteria
        Comparator<Course> sortByReviewScoreIncreasing = Comparator.comparing(Course::getReviewScore);
        System.out.println(courses.stream().sorted(sortByReviewScoreIncreasing).takeWhile(course -> course.getReviewScore() < 95).collect(Collectors.toList()));

        //dropWhile - Opposite to takeWhile. It will keep on skipping the elements until they keep meeting a particular criteria
        System.out.println(courses.stream().sorted(sortByReviewScoreIncreasing).dropWhile(course -> course.getReviewScore() < 95).collect(Collectors.toList()));

        //Max - finds the maximum based on the comparator. If the comparator is decreasing, it will fetch the min value
        //Min - finds the minimum based on the comparator. If the comparator is decreasing, it will fetch the max value
        //Both of them return empty optional
        Comparator<Course> compareByNoOfStudentsAndReviewScore = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
        System.out.println(courses.stream().max(compareByNoOfStudentsAndReviewScore));
        System.out.println(courses.stream().min(compareByNoOfStudentsAndReviewScore));

        //This will return Optional.empty()
        System.out.println(courses.stream().filter(isReviewScoreLessThan85).min(compareByNoOfStudentsAndReviewScore));
        //orElse to return default value on empty Optional
        System.out.println(courses.stream().filter(isReviewScoreLessThan85).min(compareByNoOfStudentsAndReviewScore).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        //finaFirst - prints the first element that matches that criteria
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).findFirst()
        );
        //findFirst - also returns optional
        System.out.println(
                courses.stream().filter(isReviewScoreLessThan85).findFirst()
        );

        //findAny - finds any that matches this criteria. Also returns optional
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).findAny()
        );

        //To find total no. of students for courses whose review score is greater than 95.
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).sum()
        );

        //To find average no. of students for courses whose review score is greater than 95.
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).average()
        );

        //To find count of courses whose review score is greater than 95.
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).count()
        );

        //To find max no. of students for courses whose review score is greater than 95.
        System.out.println(
                courses.stream().filter(isReviewScoreGreaterThan95).mapToInt(Course::getNoOfStudents).max()
        );

        //Group By courses based on the category
        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course::getCategory))
        );
        //{Cloud=[Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}],
        // Fullstack=[Course{name='Fullstack', category='Fullstack', reviewScore=91, noOfStudents=14000}],
        // Microservices=[Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}],
        // Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}]}

        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        //group by with the course that has the highest review in that category
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())))
        );
    }

}
