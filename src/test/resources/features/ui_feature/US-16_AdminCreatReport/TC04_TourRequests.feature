@US-16
@UI
@Admin
Feature: US-16_AdminCreatReport test

  Scenario: Tur isteklerine gore rapor olusturabilmelidir
    Given Siteye gidilir
    When Profile tiklanir
    And Kontrol Paneline tiklanir
    And Rapor butonuna tiklanir
    And Start date kismina gecerli bir veri girilir
    And End date kismina gecerli bir veri girlir
    And Status kismi secilir
    And Raporu Olustur butonuna tiklanir
    Then Tur istekleri listelenir ve rapor basariyla olusturulur







