package hotelManagement;

import java.util.*;

class Review {
    String username;
    String hotelName;
    String comment;
    int rating;

    public Review(String username, String hotelName, String comment, int rating) {
        this.username = username;
        this.hotelName = hotelName;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel: " + hotelName + " | User: " + username + " | Rating: " + rating + " | Comment: " + comment;
    }
}

class HotelReviewSystem {
    List<Review> reviews = new ArrayList<>();

    public void addReview(String username, String hotelName, String comment, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }
        reviews.add(new Review(username, hotelName, comment, rating));
        System.out.println("Review added successfully.");
    }

    public void displayReviews() {
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    public void sortReviewsByRating() {
        reviews.sort(Comparator.comparingInt(r -> -r.rating));
        System.out.println("Reviews sorted by rating.");
    }

    public void filterReviewsByHotel(String hotelName) {
        for (Review review : reviews) {
            if (review.hotelName.equalsIgnoreCase(hotelName)) {
                System.out.println(review);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReviewSystem system = new HotelReviewSystem();

        while (true) {
            System.out.println("1. Add Review");
            System.out.println("2. Display Reviews");
            System.out.println("3. Sort Reviews by Rating");
            System.out.println("4. Filter Reviews by Hotel");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    System.out.print("Enter comment: ");
                    String comment = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    system.addReview(username, hotelName, comment, rating);
                    break;
                case 2:
                    system.displayReviews();
                    break;
                case 3:
                    system.sortReviewsByRating();
                    break;
                case 4:
                    System.out.print("Enter hotel name to filter: ");
                    String filterHotel = scanner.nextLine();
                    system.filterReviewsByHotel(filterHotel);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

