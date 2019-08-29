import java.util.concurrent.CompletableFuture;

public class SyncThread {
	static String s="";
	public void send(String msg) {
		s+="..";
		System.out.println("Sending\t" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Thread interrupted.");
		}
		System.out.println("\n" + msg + "Sent");
	}

	public static void main(String args[]) {
		SyncThread snd = new SyncThread();
		SyncThread snd1 = new SyncThread();

		// Start two threads of ThreadedSend type
		snd.send("hi");
		snd.send("hello");
		// wait for threads to end
	}
}
