package bowling.domain;

public class Name {

	private static final int NAME_SIZE = 3;

	private final String name;

	public Name(String name) {
		valid(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void valid(String name) {
		if (name == null || name.isEmpty()) {
			throw new NullPointerException("이름은 빈 값일 수 없습니다.");
		}

		if (name.length() != NAME_SIZE) {
			throw new IllegalArgumentException(String.format("이름 길이는 %d 이어야 합니다.", NAME_SIZE));
		}
	}

}
