package bowling.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static String name() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return SCANNER.nextLine();
	}

	public static int score(int round) {
		try {
			System.out.print(String.format("%d프레임 투구 : ", round));
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("숫자만 입력할 수 있습니다.");
		}
	}

}
