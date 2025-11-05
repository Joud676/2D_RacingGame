import java.util.*;

public class QuestionBank {
    private final List<Map<String, String>> questions = new ArrayList<>();

    public QuestionBank() {
        addQuestions();
        Collections.shuffle(questions);
    }

    private void addQuestions() {
        questions.add(Map.of(
                "scenario", "A hospital system needs to manage patient records. Only one instance of the RecordManager should exist to prevent data conflicts. Multiple doctors accessing records simultaneously should use the same manager instance.",
                "answer", "Singleton"
        ));

        questions.add(Map.of(
                "scenario", "A game studio creates enemy characters with complex stats (health, armor, weapons). Creating enemies from scratch is expensive. When spawning 100 similar zombies, you want to copy an existing zombie and modify only position and ID.",
                "answer", "Prototype"
        ));

        questions.add(Map.of(
                "scenario", "You're designing a vacation booking system. A vacation package can include: hotel (optional), flight (optional), car rental (optional), activities (multiple), and travel insurance. Customers want to build their package step-by-step.",
                "answer", "Builder"
        ));

        questions.add(Map.of(
                "scenario", "A notification system sends alerts via Email, SMS, or Push. The main application doesn't know which notification type to create until runtime. Subclasses should decide which concrete notification class to instantiate.",
                "answer", "Factory Method"
        ));

        questions.add(Map.of(
                "scenario", "A UI framework needs to create Button, Checkbox, and TextField components. The application has two themes: Modern and Classic. Each theme requires a complete family of matching components.",
                "answer", "Abstract Factory"
        ));

        questions.add(Map.of(
                "scenario", "Your payment system expects a PaymentProcessor interface with a processPayment() method. You need to integrate a third-party StripeAPI that uses chargeCard() instead.",
                "answer", "Adapter"
        ));

        questions.add(Map.of(
                "scenario", "You're building a media player that can play Audio and Video. Each can be played on Desktop or Mobile platforms. You want media types and platforms to vary independently.",
                "answer", "Bridge"
        ));

        questions.add(Map.of(
                "scenario", "A file system contains both Files and Folders. Folders can contain Files or other Folders. You want to calculate total size by calling getSize() on any item, whether it's a single file or an entire folder hierarchy.",
                "answer", "Composite"
        ));

        questions.add(Map.of(
                "scenario", "A coffee shop sells basic Coffee. Customers can add Milk, Sugar, or Whipped Cream. Each addition changes the price and description. You want to add these features dynamically at runtime.",
                "answer", "Decorator"
        ));

        questions.add(Map.of(
                "scenario", "A home theater system involves DVD Player, Projector, Sound System, and Lights. You want a simple watchMovie() method that handles all these complex subsystem interactions.",
                "answer", "Facade"
        ));

        questions.add(Map.of(
                "scenario", "A text editor displays thousands of characters on screen. Each character has font, size, and color (shared), plus position (unique). You want to share font data across characters.",
                "answer", "Flyweight"
        ));

        questions.add(Map.of(
                "scenario", "Your application loads high-resolution images that take time to fetch from a server. You want to display a placeholder immediately, load the real image in the background, and show it when ready.",
                "answer", "Proxy"
        ));
    }

    public Map<String, String> getRandomQuestion() {
        return questions.get((int) (Math.random() * questions.size()));
    }
}
