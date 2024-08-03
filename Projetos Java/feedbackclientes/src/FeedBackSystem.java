import java.util.Scanner;

public class FeedBackSystem {
    private FeedBackStorage storage = new FeedBackStorage();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Deixar feedback");
            System.out.println("2. Ver feedbacks");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (choice) {
                case 1:
                    coletarFeedback();
                    break;
                case 2:
                    exibirFeedbacks();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void coletarFeedback() {
        System.out.print("----------------------------"+"\n"+"Nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Comentário: ");
        String comentario = scanner.nextLine();
        System.out.print("Avaliação (1 a 5): ");
        int avaliacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("------------------------------- ");

        Feedback feedback = new Feedback(cliente, comentario, avaliacao);
        storage.addFeedback(feedback);
        System.out.println("\n"+"Feedback enviado com sucesso!");
    }

    private void exibirFeedbacks() {
        System.out.println("\n"+"Feedbacks recebidos:");
        for (Feedback feedback : storage.getFeedbacks()) {
            System.out.println(feedback);
        }
    }

    public static void main(String[] args) {
        FeedBackSystem system = new FeedBackSystem();
        system.run();
    }
}
