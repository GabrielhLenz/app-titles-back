package back.domain.enums;

public enum Situation {
	FAVORITE(0, "FAVORITE"), WATCHLIST(1, "WATCHLIST"), WATCHED(2, "WATCHED");
	
	private Integer code;
	private String description;
	private Situation(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	public Integer getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	public static Situation toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(Situation x : Situation.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Opção não Listada");
	}
	
}
