package as.athen.provarecrutamento.config.validation.cpf;

public class CpfFormatter {

	public static String formatarCpf(String cpf) {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
				+ cpf.substring(9, 11));
	}

}
