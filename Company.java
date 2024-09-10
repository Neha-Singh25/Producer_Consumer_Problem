class Company {
    private int n;
    private boolean f = false;

    // f = false means it's the producer's turn
    synchronized public void produce_item(int n) {
        while (f) { // Changed to while loop for proper handling of spurious wakeups
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        this.n = n;
        System.out.println("Produced: " + this.n);
        f = true;
        notify(); // Notify the consumer
    }

    synchronized public int consume_item() {
        while (!f) { // Changed to while loop for proper handling of spurious wakeups
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        System.out.println("Consumed: " + this.n);
        f = false;
        notify(); // Notify the producer
        return this.n;
    }
}
