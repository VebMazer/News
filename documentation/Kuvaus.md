# Kuvaus

News on yksinkertainen uutisten lukemiseen ja julkaisuun
tarkoitettu web palvelin sovellus.

## Näkymät

Sovelluksessa on yhteensä viisi näkymää:

(front): 
Etusivu, jolla voi selata uutis artikkeleita. Tarjoaa mahdollisuuden valita, kuinka 
monta artikkelia sivulle listataan, sekä järjestetäänkö ne julkaisuajan, vai katsonta
kertojen perusteella. Sivulla on myös navigaatio palkki, josta voi valita haluamansa 
kategorian, jolloin sivulle listataan, vain tämän kategorian artikkeleita.
Linkit näkymässä: (admin), (article)

(article):
Koko artikkelin pääsee lukemaan, kun napsauttaa (front) näkymässä, jotakin artikkelia.
Artikkeli näkymä on tarkoitettu, vain artikkelien lukemiseen.
Linkit näkymässä: (front)

(admin):
Sovelluksen hallintaan tarkoitettu sivusto, joka listaa olemassa olevat tietokanta 
objektit, ja mahdollistaa niiden poistamisen. Kirjoittajia ja kategorioita voi myös lisätä tässä 
näkymässä.  artikkeli listasta voi myös valita artikkelin ja siirtyä sen muokkaus 
näkymään(edit).
Linkit näkymässä: (front) ,(create), (edit)

(create)
Näkymässä on kentät Otsikolle, ingressille, tekstille ja kuvalle. Näkymässä voi myös valita haluamansa jo olemassa olevat kategoriat ja kirjoittajat luotavalle artikkelille. Kentän voi otsikkoa lukuunottamatta halutessaan jättää myös tyhjäksi. Valmiin artikkelin voi lähettää sivun alimmasta painikkeesta.
Linkit näkymässä: (admin)

(edit)
Kuin (create), mutta näkymään pääsee valitsemalla artikkelin (admin) näkymästä, joka sitten korvataan muokatulla versiolla, jos muokatun version lähettää. Jos uutta kuvaa ei lisätä uusiksi, säilyy artikkelilla sen vanha kuva.
Linkit näkymässä:(admin)


## Puutteet
- Artikkelien katsoja lukumäärät kasvavat myös "spammilla".

## Bugit:
- Artikkelin lisäys, ja muokkaus, joskus epäonnistuu, yleensä kuitenkin toimii.

