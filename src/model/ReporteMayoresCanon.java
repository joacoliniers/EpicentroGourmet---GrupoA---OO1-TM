package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReporteMayoresCanon {
	
	private UnidadDeVenta unidadesConMayorCanon;
	private List<UnidadDeVenta>lstMasGastaron;
	
	public ReporteMayoresCanon(UnidadDeVenta unidadesConMayorCanon) {
		super();
		this.unidadesConMayorCanon = unidadesConMayorCanon;
		this.lstMasGastaron = new ArrayList<UnidadDeVenta>();
	}

	public UnidadDeVenta getUnidadesConMayorCanon() {
		return unidadesConMayorCanon;
	}

	public void setUnidadesConMayorCanon(UnidadDeVenta unidadesConMayorCanon) {
		this.unidadesConMayorCanon = unidadesConMayorCanon;
	}

	public List<UnidadDeVenta> getLstMasGastaron() {
		return lstMasGastaron;
	}

	public void setLstMasGastaron(List<UnidadDeVenta> lstMasGastaron) {
		this.lstMasGastaron = lstMasGastaron;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lstMasGastaron, unidadesConMayorCanon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReporteMayoresCanon other = (ReporteMayoresCanon) obj;
		return Objects.equals(lstMasGastaron, other.lstMasGastaron)
				&& Objects.equals(unidadesConMayorCanon, other.unidadesConMayorCanon);
	}
	
	

}
