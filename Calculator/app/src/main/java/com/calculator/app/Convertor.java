package com.calculator.app;

/**
 * Created by Monstr on 10.03.14.
 */

public class Convertor {

	final static double[] mas = { 1, 1000, 1000 };

	public static String convert(int number1, int number2, String first,
			String second, boolean chek) {

		String answer = null;
		double ans = 0;

		double a = Double.valueOf(first);
		double b = Double.valueOf(second);

		if (number1 != number2) {

			if (chek) {
				ans = b;

				if (number1 > number2) {

					for (int i = number1; number2 <= i; i--)
						ans /= mas[i];

				} else {

					for (int i = number1; i <= number2; i++)
						ans *= mas[i];
				}

			} else {

				ans = a;
				if (number1 < number2) {

					for (int i = number1; number2 <= i; i--)
						ans /= mas[i];

				} else {

					for (int i = number1; i <= number2; i++)
						ans *= mas[i];
				}
			}

		} else {
			if (chek) {
				ans = b;
			} else {
				ans = a;
			}

		}

		answer = Double.toString(ans);
		return answer;
	}

}
