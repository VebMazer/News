Newz on yksinkertainen uutisten lukemiseen ja julkaisuun
tarkoitettu web palvelin sovellus.

Sovelluksessa on yhteensä viisi näkymää:

(front): 
Etusivu, jolla voi selata uutis artikkeleita. Tarjoaa mahdollisuuden valita, kuinka 
monta artikkelia sivulle listataan, sekä järjestetäänkö ne julkaisuajan, vai katsonta
kertojen perusteella. Sivulla on myös navigaatio palkki, josta voi valita haluamansa 
categorian, jolloin sivulle listataan, vain tämän categorian artikkeleita.
Näkymässä on myös linkki (admin) näkymään.
->(admin)
->(article)

(article):
Koko artikkelin pääsee lukemaan, kun napsauttaa (front) näkymässä, jotakin artikkelia.
Artikkeli näkymä on tarkoitettu, vain artikkelien lukemiseen.
Näkymästä on myös linkki, takaisin (front) näkymään.
->(front)

(admin):
Sovelluksen hallintaan tarkoitettu sivusto, joka listaa olemassa olevat tietokanta 
objektit, ja mahdollistaa niiden poistamisen. Kirjoittajia ja kategorioita voi myös lisätä tässä 
näkymässä.  artikkeli listasta voi myös valita artikkelin ja siirtyä sen muokkaus 
näkymään(edit). Näkymässä on myös linkki artikkelien luonti sivustolle(create).
->(front)
->(create)
->(edit)

(create)
Näkymässä on kentät Otsikolle, ingressille, tekstille ja kuvalle.
Näkymässä voi myös valita haluamansa jo olemassa olevat categoriat ja 
kirjoittajat luotavalle artikkelille. Kentän voi otsikkoa lukuunottamatta halutessaan 
jättää myös tyhjäksi. Valmiin artikkelin voi lähettää sivun alimmasta painikkeesta.
Näkymästä on myös linkki takaisin (admin) näkymään.
->(admin)

(edit)
Kuin (create), mutta näkymään pääsee valitsemalla artikkelin (admin) näkymästä, joka sitten
korvataan muokatulla versiolla, jos muokatun version lähettää. Jos uutta kuvaa ei lisätä
uusiksi, säilyy artikkelilla sen vanha kuva.
Näkymästä on myös linkki takaisin (admin) näkymään.
->(admin)


Puutteet:
- Artikkelien muokkaus ei toimi herokun kokoonpanossa.
(edit näkymä ei jostain syystä lataa) (Toimi, kyllä kotikoneellani.)
- Artikkelien katsoja lukumäärät eivät ole aikaan sidottuja.
- Testejä ei käytännössä ole.
- Koodin tarkempi kommentointi puuttuu.

Bugit:
- Artikkelin lisäys, ja muokkaus, joskus jokseenkin mystisesti epäonnistuu,
yleensä kuitenkin toimii.

