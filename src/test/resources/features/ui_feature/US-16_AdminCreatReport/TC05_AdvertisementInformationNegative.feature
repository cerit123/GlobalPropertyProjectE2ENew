@US-16
@UI
@Admin
Feature: US-16_AdminCreatReport test

  Scenario:Eksik bilgi ile rapor olusturma yapildiginda hata mesaji almalidir

    Given Siteye gidilir
    When Admin olarak giris yapilir
    And Raporlar sekmesine gidilir
    And Start date kismina  bos birakilir
    And End date kismina gecerli bir veri girlir
    And Category kismi secilir
    And Advert type kismi secilir
    And Status kismi secilir
    And Raporu Olustur butonuna tiklanir
    Then Raporun basariyla olusturulmadigi ve hata mesaji alindigi gorulur
    And logout butonuna tiklanir
    And Sayfa kapatilir







