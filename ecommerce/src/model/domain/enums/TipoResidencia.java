package model.domain.enums;

public enum TipoResidencia {
	Casa(1),
	Apartamento(2);

	int codigo;

	private TipoResidencia(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public static TipoResidencia getByCodigo(int id) {
		for (TipoResidencia tipoResidencia : values()) {
			if (tipoResidencia.getCodigo() == id) {
				return tipoResidencia;
			}
		}
		return null;
	}

}
