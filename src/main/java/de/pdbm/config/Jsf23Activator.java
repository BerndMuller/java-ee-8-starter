package de.pdbm.config;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3) // Sorgt dafür, dass JSF im 2.3-Modus läuft.
public class Jsf23Activator {

	public String versionMessage() {
		Package pack = FacesContext.class.getPackage();
		return String.format("You are using %s %s", pack.getSpecificationTitle(), pack.getSpecificationVersion());
	}
}
