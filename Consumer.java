class Consumer extends Thread {
    private Company c;
    private volatile boolean running = true; // Added flag to control thread execution

    Consumer(Company c) {
        this.c = c;
    }

    public void run() {
        while (running) { // Check the flag to control the loop
            c.consume_item();
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.out.println("Consumer thread interrupted: " + e);
            }
        }
    }

    public void stopConsumer() {
        running = false; // Method to stop the consumer thread
    }
}
