@US-17
@UI
@Manager
Feature:  US-17_ManagerCreatReport test

  Scenario: Kullanici bilgilerine gore rapor olusturabilmelidir
    Given Manager olarak profil butonuna tiklanir
    And Mnager olarak kontrol paneline tiklanir
    And Manager olarak Raporlar sayfasina gidilir
    And Manager olarak Kullanicilar kismi Manager olarak secilir
    And Manager olarak Raporu Olustur butonuna tiklanir
    Then Manager olarak Manager kullanici bilgisiyle raporun olusturuldugu  gorulur
    And Sayfa kapatilir



