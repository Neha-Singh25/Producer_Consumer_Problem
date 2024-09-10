public class Main {
    public static void main(String[] args) {
        Company comp = new Company();
        Producer p = new Producer(comp);
        Consumer c = new Consumer(comp);

        // Start the threads
        p.start();
        c.start();

        // Let them run for a while
        try {
            Thread.sleep(10000); // Let the producer and consumer run for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println("Main thread interrupted: " + e);
        }

        // Stop the threads gracefully
        p.stopProducer();
        c.stopConsumer();

        // Optionally wait for the threads to finish
        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println("Main thread interrupted while joining: " + e);
        }

        System.out.println("Producer and Consumer have stopped.");
    }
}
