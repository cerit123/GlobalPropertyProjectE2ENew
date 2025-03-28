@APIEmre
Feature: API Report Controller Testleri
@apiAdmin
Scenario: TC01 | Admin olarak tum raporlari gorebilmeli

Given Url tum raporlari gormek icin duzenlenir
And Rapor icin Get request gonderilir ve response alinir
Then Status Code 200 oldugundan emin olunur

@apiAdmin
@US07API

Scenario: TC02 | Admin olarak tour requestraporlari gorebilmeli

Given Url tour request raporlari gormek icin duzenlenir
And Tour Request Rapor icin Get request gonderilir ve response alinir
Then Status Code 200 oldugundan emin olunur

@apiAdmin
@US07API

Scenario: TC03 | Admin olarak most popular ilan raporlari gorebilmeli

Given Url most popular raporlari gormek icin duzenlenir
And Most Popular raaporlar icin Get request gonderilir ve response alinir
Then Status Code 200 oldugundan emin olunur

@apiAdmin
@US07API

Scenario: TC04 | Admin olarak adverts raporlari gorebilmeli

Given Url adverts raporlari gormek icin duzenlenir
And Adverts raporlarini gormek icin Get request gonderilir ve response alinir
Then Status Code 200 oldugundan emin olunur