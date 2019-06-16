package wojciechowska.grzejszczak.slub


import static wojciechowska.grzejszczak.slub.Goście.lepiej_przynieść_karmę_lub_żwirek_dla_zwierzaków_z_mińska

class Ślub {

	static void main(String[] args) {
		def małgorzata = new Narzeczona()
		def marcin = new Narzeczony()
		def ślub = [
				gdzie: "Urząd Stanu Cywilnego Warszawa Białołęka",
				adres: "ul. Modlińska 197, 03-122, Warszawa",
				data : "2019-09-21",
				czas : "14:00"
		]
		def narzeczeni = małgorzata + marcin
		println "Narzeczeni $małgorzata i $marcin serdecznie zapraszają"
		def małżeństwo = narzeczeni.biorą ślub
		małżeństwo.zawarte()
		if (new Goście().chcą_dać_kwiaty()) {
			lepiej_przynieść_karmę_lub_żwirek_dla_zwierzaków_z_mińska()
		}
	}

}

class Narzeczony {

	@Override String toString() {
		return "Marcin Grzejszczak"
	}
}

class Narzeczona {

	Narzeczeni plus(Narzeczony narzeczony) {
		return new Narzeczeni()
	}

	@Override String toString() {
		return "Małgorzata Wojciechowska"
	}
}

class Narzeczeni {
	Małżeństwo biorą(Map daneŚlubu) {
		println "\nNa ślub \n${daneŚlubu.entrySet().join("\n")}"
		return new Małżeństwo()
	}
}

class Małżeństwo {
	void zawarte() {
		print "\nI jako małżeństwo "
		new ZdarzenieMiłości("będą żyli długo i szczęśliwie!")
	}
}

class ZdarzenieMiłości {
	ZdarzenieMiłości(String skutek) {
		print skutek
	}
}

class Goście {
	boolean chcą_dać_kwiaty() {
		print "\n\nJeśli chcesz przynieść kwiaty,"
		return true
	}

	static void lepiej_przynieść_karmę_lub_żwirek_dla_zwierzaków_z_mińska() {
		print " lepiej przynieść karmę lub żwirek dla 'Zwierzaków z Mińska', które są cześcią Fundacji Międzynarodowego Ruchu na Rzecz Zwierząt - Viva!"
	}
}