import java.util.*;

public class QuestionBank {
    private final Map<String, String> questions = new HashMap<>();

    public QuestionBank() {
        addQuestions();
    }

    private void addQuestions() {
        questions.put("Singleton",
                "A hospital system needs to manage patient records. Only one instance of the RecordManager should exist to prevent data conflicts. Multiple doctors accessing records simultaneously should use the same manager instance.");

        questions.put("Prototype",
                "A game studio creates enemy characters with complex stats (health, armor, weapons). Creating enemies from scratch is expensive. When spawning 100 similar zombies, you want to copy an existing zombie and modify only position and ID.");

        questions.put("Builder",
                "You're designing a vacation booking system. A vacation package can include: hotel (optional), flight (optional), car rental (optional), activities (multiple), and travel insurance. Customers want to build their package step-by-step.");

        questions.put("Factory Method",
                "A notification system sends alerts via Email, SMS, or Push. The main application doesn't know which notification type to create until runtime. Subclasses should decide which concrete notification class to instantiate.");

        questions.put("Abstract Factory",
                "A UI framework needs to create Button, Checkbox, and TextField components. The application has two themes: Modern and Classic. Each theme requires a complete family of matching components.");

        questions.put("Adapter",
                "Your payment system expects a PaymentProcessor interface with a processPayment() method. You need to integrate a third-party StripeAPI that uses chargeCard() instead.");

        questions.put("Bridge",
                "You're building a media player that can play Audio and Video. Each can be played on Desktop or Mobile platforms. You want media types and platforms to vary independently.");

        questions.put("Composite",
                "A file system contains both Files and Folders. Folders can contain Files or other Folders. You want to calculate total size by calling getSize() on any item, whether it's a single file or an entire folder hierarchy.");

        questions.put("Decorator",
                "A coffee shop sells basic Coffee. Customers can add Milk, Sugar, or Whipped Cream. Each addition changes the price and description. You want to add these features dynamically at runtime.");

        questions.put("Facade",
                "A home theater system involves DVD Player, Projector, Sound System, and Lights. You want a simple watchMovie() method that handles all these complex subsystem interactions.");

        questions.put("Flyweight",
                "A text editor displays thousands of characters on screen. Each character has font, size, and color (shared), plus position (unique). You want to share font data across characters.");

        questions.put("Proxy",
                "Your application loads high-resolution images that take time to fetch from a server. You want to display a placeholder immediately, load the real image in the background, and show it when ready.");
    }

    public Map.Entry<String, String> getRandomQuestion() {
        List<Map.Entry<String, String>> list = new ArrayList<>(questions.entrySet());
        return list.get(new Random().nextInt(list.size()));
    }
}
