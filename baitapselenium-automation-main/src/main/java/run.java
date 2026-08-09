import org.example.airbnbHomePage;
import org.example.amazonSearchResultPage;
import org.example.hrmAdminPage;

public class run {
    public static void main(String[] args) {
        try {
            amazonSearchResultPage.main(args);
            System.out.println("Done page Amazon");

        } catch (Exception e) {
            System.out.println("Loi chuong trinh");
        }
        System.out.println("------------------------------");
        try {
            airbnbHomePage.main(args);
            System.out.println("Done page Airbnb");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------");
        try {
            hrmAdminPage.main(args);
            System.out.println("Done page HRM Admin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
