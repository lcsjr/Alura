package estudos_java.estudos_java;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class MapaDePara {

	private HashMap<Integer, String> mapTrbRef = new HashMap<Integer, String>();

	public MapaDePara() {
		this.mapTrbRef.put(6, "DS_NOME");
		this.mapTrbRef.put(7, "DS_IDADE");
		this.mapTrbRef.put(8, "DS_NASC");
		this.mapTrbRef.put(9, "DS_SALARIO");
	}
	
	public MapaDePara(HashMap<Integer, String> mapTrbRef) {
		super();
		this.mapTrbRef = mapTrbRef;
	}
	
}
