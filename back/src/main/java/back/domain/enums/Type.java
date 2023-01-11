package back.domain.enums;

public enum Type {
	MOVIE(0, "MOVIE"), TV(1, "TV");
	
	private Integer code;
	private String description;
	private Type(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	public Integer getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	public static Type toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(Type x : Type.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Opção não Listada");
	}
}
