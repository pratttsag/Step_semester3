import java.time.LocalDate;
import java.util.*;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, SubscriptionPlan> plans = new HashMap<>();
        plans.put("BASIC", new BasicPlan());
        plans.put("STANDARD", new StandardPlan());
        plans.put("PREMIUM", new PremiumPlan());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            SubscriptionPlan plan = plans.get(type);

            LocalDate renewalDate =
                    plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}