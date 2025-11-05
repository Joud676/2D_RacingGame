import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<>();
        addQuestions();
        shuffleQuestions();
    }

    private void addQuestions() {
        // Singleton
        questions.add(new Question(
                "A hospital system needs to manage patient records. Only one instance of the " +
                        "RecordManager should exist to prevent data conflicts. Multiple doctors accessing " +
                        "records simultaneously should use the same manager instance.",
                "Singleton"
        ));

        // Prototype
        questions.add(new Question(
                "A game studio creates enemy characters with complex stats (health, armor, weapons). " +
                        "Creating enemies from scratch is expensive. When spawning 100 similar zombies, " +
                        "you want to copy an existing zombie and modify only position and ID.",
                "Prototype"
        ));

        // Builder
        questions.add(new Question(
                "You're designing a vacation booking system. A vacation package can include: " +
                        "hotel (optional), flight (optional), car rental (optional), activities (multiple), " +
                        "and travel insurance. Customers want to build their package step-by-step, " +
                        "choosing only what they need.",
                "Builder"
        ));

        // Factory Method
        questions.add(new Question(
                "A notification system sends alerts via Email, SMS, or Push. The main application " +
                        "doesn't know which notification type to create until runtime. Subclasses should " +
                        "decide which concrete notification class to instantiate based on user preferences.",
                "Factory Method"
        ));

        // Abstract Factory
        questions.add(new Question(
                "A UI framework needs to create Button, Checkbox, and TextField components. " +
                        "The application has two themes: Modern and Classic. Each theme requires " +
                        "a complete family of matching components. You want to ensure all components " +
                        "in use belong to the same theme.",
                "Abstract Factory"
        ));

        // Adapter
        questions.add(new Question(
                "Your payment system expects a PaymentProcessor interface with a processPayment() method. " +
                        "You need to integrate a third-party StripeAPI that uses chargeCard() instead. " +
                        "You cannot modify the StripeAPI code, but need it to work with your existing system.",
                "Adapter"
        ));

        // Bridge
        questions.add(new Question(
                "You're building a media player that can play Audio and Video. Each can be played " +
                        "on Desktop or Mobile platforms. Instead of creating AudioDesktop, AudioMobile, " +
                        "VideoDesktop, VideoMobile classes, you want media types and platforms to " +
                        "vary independently.",
                "Bridge"
        ));

        // Composite
        questions.add(new Question(
                "A file system contains both Files and Folders. Folders can contain Files or other Folders. " +
                        "You want to calculate total size by calling getSize() on any item, whether it's " +
                        "a single file or an entire folder hierarchy, using the same interface.",
                "Composite"
        ));

        // Decorator
        questions.add(new Question(
                "A coffee shop sells basic Coffee. Customers can add Milk, Sugar, or Whipped Cream. " +
                        "Each addition changes the price and description. You want to add these features " +
                        "dynamically at runtime without creating a class for every possible combination.",
                "Decorator"
        ));

        // Facade
        questions.add(new Question(
                "A home theater system involves DVD Player, Projector, Sound System, and Lights. " +
                        "Watching a movie requires: dimming lights, turning on projector, starting DVD, " +
                        "and adjusting sound. You want a simple watchMovie() method that handles all " +
                        "these complex subsystem interactions.",
                "Facade"
        ));

        // Flyweight
        questions.add(new Question(
                "A text editor displays thousands of characters on screen. Each character has " +
                        "font, size, and color (which rarely change), plus position (which is unique). " +
                        "Storing full character objects for each position consumes too much memory. " +
                        "You want to share font data across characters.",
                "Flyweight"
        ));

        // Proxy
        questions.add(new Question(
                "Your application loads high-resolution images that take time to fetch from a server. " +
                        "You want to display a placeholder immediately, load the real image in the background, " +
                        "and show it when ready. The client code should interact with images " +
                        "the same way regardless.",
                "Proxy"
        ));
    }

    private void shuffleQuestions() {
        Collections.shuffle(questions);
    }

    public Question getRandomQuestion() {
        int randomIndex = (int) (Math.random() * questions.size());
        return questions.get(randomIndex);
    }


}