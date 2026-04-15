public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT gatsby = new MiniGPT("science.txt", 12);
        gatsby.readData();
        gatsby.generateText("greatgatsby2.txt", 10000);
    }
}
