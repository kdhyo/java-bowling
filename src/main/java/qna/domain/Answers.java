package qna.domain;

import qna.CannotDeleteException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Answers {
    private List<Answer> answers;

    public Answers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answers() {
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void checkRemovable(User user) throws CannotDeleteException {
        boolean isOther = answers.stream()
                .anyMatch(answer -> !answer.isOwner(user));

        if (isOther) {
            throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
        }
    }

    public List<DeleteHistory> delete() {
        answers.forEach(Answer::delete);

        return getDeleteHistories();
    }

    private List<DeleteHistory> getDeleteHistories() {
        return answers.stream()
                .filter(Answer::isDeleted)
                .map(Answer::toDeleteHistory)
                .collect(Collectors.toList());
    }
}