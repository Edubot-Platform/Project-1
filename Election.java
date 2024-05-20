import java.util.ArrayList;
import java.util.List;

public class Election {
    private List<Candidate> candidates;
    private List<Voter> voters;

    public Election() {
        candidates = new ArrayList<>();
        voters = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void removeCandidate(Candidate candidate) {
        candidates.remove(candidate);
    }

    public void addVoter(Voter voter) {
        voters.add(voter);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void vote(String voterId, String candidateName) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equalsIgnoreCase(candidateName)) {
                candidate.addVote();
                return;
            }
        }
        System.out.println("Candidate not found!");
    }

    public Candidate getWinner() {
        Candidate winner = null;
        int maxVotes = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getVotes() > maxVotes) {
                maxVotes = candidate.getVotes();
                winner = candidate;
            }
        }
        return winner;
    }
}
