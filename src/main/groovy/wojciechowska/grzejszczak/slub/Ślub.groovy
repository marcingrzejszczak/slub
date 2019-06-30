package wojciechowska.grzejszczak.slub

import groovy.transform.Canonical
import groovy.transform.CompileStatic

class Ślub {

	static void main(String[] args) {
		def małgorzata = new Narzeczona()
		def marcin = new Narzeczony()
		def ślub = [
				gdzie: "Urząd Stanu Cywilnego Warszawa Białołęka",
				adres: "ul. Modlińska 197, 03-122, Warszawa",
				data : "21-09-2019",
				czas : "14:00"
		]
		def narzeczeni = małgorzata + marcin
		println "Narzeczeni $małgorzata i $marcin serdecznie zapraszają"
		def małżeństwo = narzeczeni.biorą ślub
		małżeństwo.zawarte()
		if (new Goście().chcą_dać_kwiaty()) {
			Goście.lepiej_przynieście_karmę_lub_żwirek_dla_zwierzaków_z_mińska()
		}
	}

}

@CompileStatic
class Narzeczony {

	@Override String toString() {
		return "Marcin Grzejszczak"
	}
}

@CompileStatic
class Narzeczona {

	Narzeczeni plus(Narzeczony narzeczony) {
		return new Narzeczeni(this, narzeczony)
	}

	@Override String toString() {
		return "Małgorzata Wojciechowska"
	}
}

@Canonical
class Narzeczeni {

	final Narzeczona narzeczona
	final Narzeczony narzeczony

	Małżeństwo biorą(Map daneŚlubu) {
		println "\nNa ślub \n${daneŚlubu.entrySet().join("\n")}"
		return new Małżeństwo()
	}
}

@CompileStatic
class Małżeństwo {
	void zawarte() {
		print "\nI jako małżeństwo "
		new ZdarzenieMiłości("będą żyli długo i szczęśliwie!")
	}
}

@CompileStatic
class ZdarzenieMiłości {
	ZdarzenieMiłości(String skutek) {
		print skutek
	}
}

@CompileStatic
class Goście {
	boolean chcą_dać_kwiaty() {
		print "\n\nJeśli chcesz przynieść kwiaty,"
		return true
	}

	static void lepiej_przynieście_karmę_lub_żwirek_dla_zwierzaków_z_mińska() {
		print " lepiej przynieść karmę lub żwirek dla 'Zwierzaków z Mińska', które są cześcią Fundacji Międzynarodowego Ruchu na Rzecz Zwierząt - Viva!"
	}
}