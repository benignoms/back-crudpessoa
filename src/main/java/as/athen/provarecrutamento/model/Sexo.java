package as.athen.provarecrutamento.model;

public enum Sexo {
	M("Masculino") {
		@Override
		public double calcularPesoIdeal(double altura) {
			return 72.7D * altura - 58;			
		}
	},F("Feminino") {
		@Override
		public double calcularPesoIdeal(double altura) {
			return 62.1D * altura - 44.7;
		}
	};
	
	public abstract double calcularPesoIdeal(double altura);
	
	private Sexo(String descricao) {
	}
}
