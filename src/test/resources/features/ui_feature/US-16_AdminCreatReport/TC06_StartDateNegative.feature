@US-16
@UI
@Admin
Feature: US-16_AdminCreatReport test

  Scenario:Gecersiz tarih araligi sectiginde hata mesaji almalidir

    Given Siteye gidilir
    When Admin olarak giris yapilir
    And Raporlar sekmesine gidilir
    And Start date kismina  gecerli  bir veri girilir
    And End date kismina "Start date " kisminda once bir tarih girilir
    And Category kismi secilir
    And Advert type kismi secilir
    And Status kismi secilir
    And Raporu Olustur butonuna tiklanir
    Then Raporun basariyla olusturulmadigi ve hata mesaji alindigi gorulur
    And logout butonuna tiklanir
    And Sayfa kapatilir
