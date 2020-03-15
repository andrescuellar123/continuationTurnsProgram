package model;

public class ClockDate {
	private Turn tu;
	private float hora;
	public static float DELAY = 0.25f;

	public ClockDate(Turn tu, float hora) {
		super();
		this.tu = tu;
		this.hora = hora;
	}

	public Turn getTu() {
		return tu;
	}

	public void setTu(Turn tu) {
		this.tu = tu;
	}

	public float getHora() {
		return hora;
	}

	public void setHora(float hora) {
		this.hora = hora;
	}


	public String theTime(Turn t) {
		String msg="";
		if(t.getType().getTime() == t.getType().PREFERENCIAL) {
			msg="la hora de llegada es: "+ t.getType().getTime() + "la hora de salida es: "+ (t.getType().getTime() +  t.getType().PREFERENCIAL); 
		}
		else {
			msg="la hora de llegada es: "+ t.getType().getTime() + "la hora de salida es: "+ (t.getType().getTime() +  t.getType().NORMAL);
		}

		return msg ;
	}
	
	public String theNextCan(Turn t ) {
		String msg ="";
		if(t.getType().getTime() == t.getType().PREFERENCIAL) {
			msg="La hora de salida: "+ (t.getType().getTime() +  t.getType().PREFERENCIAL + DELAY); 
		}
		else {
			msg="La hora de salida: "+ (t.getType().getTime() +  t.getType().NORMAL + DELAY); 
		}
		return msg;
	}


}
