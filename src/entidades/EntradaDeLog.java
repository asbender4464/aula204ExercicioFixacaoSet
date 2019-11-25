package entidades;

import java.util.Date;

public class EntradaDeLog {

	private String nomeDoUsuario;
	private Date momento;
	
	public EntradaDeLog(String nomeDoUsuario, Date momento) {
		this.nomeDoUsuario = nomeDoUsuario;
		this.momento = momento;
	}
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}
	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}
	public Date getMomento() {
		return momento;
	}
	public void setMomento(Date momento) {
		this.momento = momento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoUsuario == null) ? 0 : nomeDoUsuario.hashCode());
		return result;
	}
	
	//A seleção será pelo campo nomeDoUsuario
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaDeLog other = (EntradaDeLog) obj;
		if (nomeDoUsuario == null) {
			if (other.nomeDoUsuario != null)
				return false;
		} else if (!nomeDoUsuario.equals(other.nomeDoUsuario))
			return false;
		return true;
	}
}
