public class Candidate {
    private String name;
    private String party;
    private int votes;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }

    @Override
    public String toString() {
        return name + " (" + party + ") - Votes: " + votes;
    }
}
