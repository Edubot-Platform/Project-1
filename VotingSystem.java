import java.util.Scanner;

public class VotingSystem {
    private Election election;

    public VotingSystem() {
        election = new Election();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Candidate");
            System.out.println("2. Add Voter");
            System.out.println("3. Vote");
            System.out.println("4. View Results");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidateName = scanner.nextLine();
                    System.out.print("Enter candidate party: ");
                    String candidateParty = scanner.nextLine();
                    election.addCandidate(new Candidate(candidateName, candidateParty));
                    break;
                case 2:
                    System.out.print("Enter voter name: ");
                    String voterName = scanner.nextLine();
                    System.out.print("Enter voter age: ");
                    int voterAge = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter voter ID: ");
                    String voterId = scanner.nextLine();
                    election.addVoter(new Voter(voterName, voterAge, voterId));
                    break;
                case 3:
                    System.out.print("Enter voter ID: ");
                    String votingVoterId = scanner.nextLine();
                    System.out.print("Enter candidate name to vote: ");
                    String votingCandidateName = scanner.nextLine();
                    election.vote(votingVoterId, votingCandidateName);
                    break;
                case 4:
                    System.out.println("Election Results:");
                    for (Candidate candidate : election.getCandidates()) {
                        System.out.println(candidate);
                    }
                    Candidate winner = election.getWinner();
                    if (winner != null) {
                        System.out.println("Winner: " + winner.getName() + " (" + winner.getParty() + ")");
                    } else {
                        System.out.println("No votes cast yet.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
