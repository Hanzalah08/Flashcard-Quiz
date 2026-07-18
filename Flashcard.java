package flashcardquiz;

public class Flashcard {

    private String question;
    private String answer;

   
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Getter
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    // Setter
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}