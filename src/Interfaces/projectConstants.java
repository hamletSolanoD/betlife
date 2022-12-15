package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public interface projectConstants {
	public int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public String TypesOfMomios[] = { "Americano", "Decimal", "Fraccionario", "Probabilidad Implicita" };

	public Color background = new Color(208, 205, 215);
	public Color backgroundLigth = new Color(217, 219, 241);
	public Color backgroundDark = new Color(172, 176, 189);
	public Color details = new Color(65, 97, 101);
	public Color detailsDark = new Color(11, 57, 72);

	public Font titleFont = new Font("", 3, 30);

	public enum MomioType {// is mexican so in spanish
		Americano("Americano"), Decimal("Decimal"), Fraccionario("Fraccionario"),
		ProbabilidadImplicita("Probabilidad Implicita");

		String toString;

		MomioType(String s) {
			toString = s;

		}

		public static MomioType getTypeByString(String name) {

			switch (name) {
				case "Americano":
					return MomioType.Americano;
				case "Decimal":
					return MomioType.Decimal;
				case "Fraccionario":
					return MomioType.Fraccionario;
				case "Probabilidad Implicita":
					return MomioType.ProbabilidadImplicita;
				default:
					break;
			}
			return null;
		}

		public static double momio_to_decimal(double originalMomio, MomioType TypeOfMomio) {
			double finalDecimalMomio = 0;
			switch (TypeOfMomio) {
				case Americano:
					if (originalMomio > 0) {
						finalDecimalMomio = (originalMomio / 100) + 1;
					} else {
						finalDecimalMomio = (100 / Math.abs(originalMomio)) + 1;
					}
					break;
				case Decimal:
					finalDecimalMomio = originalMomio;
					break;
				case ProbabilidadImplicita:
					finalDecimalMomio = 1 / (originalMomio / 100);
					break;
				case Fraccionario:
					finalDecimalMomio = originalMomio + 1;
					break;
			}
			return finalDecimalMomio;
		}

		public static double momio_conversor(double originalMomio, MomioType OriginalMomio, MomioType toConvert) {
			double finalDecimalMomio = 0;
			switch (OriginalMomio) {
				case Americano:
					if (originalMomio > 0) {
						finalDecimalMomio = (originalMomio / 100) + 1;
					} else {
						finalDecimalMomio = (100 / Math.abs(originalMomio)) + 1;
					}
					break;
				case Decimal:
					finalDecimalMomio = originalMomio;
					break;
				case ProbabilidadImplicita:
					finalDecimalMomio = 1 / (originalMomio / 100);
					break;
				case Fraccionario:
					finalDecimalMomio = originalMomio + 1;
					break;
			}

			switch (toConvert) {
				case Americano:
					if (finalDecimalMomio >= 2) {
						return (finalDecimalMomio - 1) * 100;
					} else {
						return (-100) / (finalDecimalMomio - 1);
					}
				case Decimal:
					return finalDecimalMomio;
				case ProbabilidadImplicita:
					return (1 / finalDecimalMomio) * 100;
				case Fraccionario:
					return finalDecimalMomio - 1;
			}

			return 0;
		}

		public static int compare_momios(double momio1, MomioType momio1Type, double momio2, MomioType momio2Type) {
			double momio1Converted = momio_conversor(momio1, momio1Type, MomioType.Decimal);
			double momio2Converted = momio_conversor(momio2, momio2Type, MomioType.Decimal);
			return momio1Converted > momio2Converted ? 1 : -1;

		}

		@Override
		public String toString() {
			return toString;

		}
	}

	public enum statusComplexbet {
		IN_PROGRESS(new Color(40, 202, 202)), COMPLETED(new Color(40, 202, 1)), CANCELLED(new Color(202, 40, 1));

		private Color c;

		statusComplexbet(Color c) {
			this.c = c;
		}

		public Color getColor() {
			return c;
		}

	};

}
