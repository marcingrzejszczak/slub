package wojciechowska.grzejszczak.slub

import spock.lang.Specification

class ŚlubSpec extends Specification {
	ByteArrayOutputStream outContent = new ByteArrayOutputStream()
	PrintStream originalOut = System.out

	def setup() {
		System.setOut(new PrintStream(outContent))
	}

	def cleanup() {
		System.setOut(originalOut);
	}

	def "should print the wedding message"() {
		when:
			Ślub.main()
		then:
			"""\
Narzeczeni Małgorzata Wojciechowska i Marcin Grzejszczak serdecznie zapraszają

Na ślub 
gdzie=Urząd Stanu Cywilnego Warszawa Białołęka
adres=ul. Modlińska 197, 03-122, Warszawa
data=2019-09-21
czas=14:00

I jako małżeństwo będą żyli długo i szczęśliwie!

Jeśli chcesz przynieść kwiaty, lepiej przynieść karmę lub żwirek dla 'Zwierzaków z Mińska', które są cześcią Fundacji Międzynarodowego Ruchu na Rzecz Zwierząt - Viva!
""".trim() == outContent.toString()
	}
}
