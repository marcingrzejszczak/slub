package wojciechowska.grzejszczak.slub

class Ślub {

	static void main(String[] args) {
		def gosia = new Narzeczona()
		def marcin = new Narzeczony()
		def ślub = [
				gdzie: "Urząd Stanu Cywilnego Warszawa Białołęka",
				adres: "ul. Modlińska 197, 03-122, Warszawa",
				data : "2019-09-21",
				czas : "14:00"
		]
		def narzeczeni = gosia + marcin
		println "Narzeczeni $gosia i $marcin serdecznie zapraszają"
		def małżeństwo = narzeczeni.biorą ślub
		małżeństwo.zawarte()
		if (new Goście().chcąDaćKwiaty()) {

		}
	}

}

class Narzeczony {

	@Override
	String toString() {
		return "Marcin"
	}
}

class Narzeczona {

	Narzeczeni plus(Narzeczony narzeczony) {
		return new Narzeczeni()
	}

	@Override
	String toString() {
		return "Gosia"
	}
}

class Narzeczeni {
	Małżeństwo biorą(Map daneŚlubu) {
		println "Na ślub $daneŚlubu"
		return new Małżeństwo()
	}
}

class Małżeństwo {
	void zawarte() {
		println "I jako małżeństwo"
		new ZdarzenieMiłości("Żyli długo i szczęśliwie")
	}
}

class ZdarzenieMiłości {
	ZdarzenieMiłości(String skutek) {
		println skutek
	}
}

class Goście {
	boolean chcąDaćKwiaty() {
		return true
	}
}