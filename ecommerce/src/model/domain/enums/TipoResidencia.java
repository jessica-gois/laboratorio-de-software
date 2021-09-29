package model.domain.enums;

public enum TipoResidencia {
	Casa,
	Apartamento,
	Flat,
	Kitnet,
	Loft;
	
	
	@Override
	public String toString() {
		return this.name();
	}

}
