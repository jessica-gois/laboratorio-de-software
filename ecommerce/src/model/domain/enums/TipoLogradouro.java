package model.domain.enums;

public enum TipoLogradouro {
	Rua(1),
	Avenida(2),
	Rodovia(3);

	int codigo;

	private TipoLogradouro(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public static TipoLogradouro getByCodigo(int id) {
		for (TipoLogradouro tipoLogradouro : values()) {
			if (tipoLogradouro.getCodigo() == id) {
				return tipoLogradouro;
			}
		}
		return null;
	}

}
