package validarErros;

public class TratamentoErros {

	private String campo;
	private String erros;


	public TratamentoErros(String campo, String erros) {
		this.campo = campo;
		this.erros = erros;
	}


		public String getCampo() {
		return campo;
	}

	public String getErros() {
		return erros;
	}

}
