@US-16
@UI
@Admin
Feature: US-16_AdminCreatReport test

  Scenario: Yetkisiz kullanici ile rapor olusturma yapilmamalidir
    Given Siteye gidilir
    When Farkli bir kullanici ile giris yapilir
    And Profil kismina gidilir
    And Kontrol Paneli  sekmesine gidilir
    Then "Kontrol Paneli " sekmesinin olmadigi gorulur
    And logout butonuna tiklanir
    And Sayfa kapatilir



