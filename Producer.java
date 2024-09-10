class Producer extends Thread {
    private Company c;
    private volatile boolean running = true; // Added flag to control thread execution

    Producer(Company c) {
        this.c = c;
    }

    public void run() {
        int i = 1;
        while (running) { // Check the flag to control the loop
            c.produce_item(i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.out.println("Producer thread interrupted: " + e);
            }
            i++;
        }
    }

    public void stopProducer() {
        running = false; // Method to stop the producer thread
    }
}
